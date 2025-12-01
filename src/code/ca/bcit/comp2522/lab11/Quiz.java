package ca.bcit.comp2522.lab11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz extends Application
{
    private static final int WIDTH           = 800;
    private static final int HEIGHT          = 600;
    private static final int QUESTION_SPLIT  = 0;
    private static final int COUNTER_STARTER = 0;
    private static final int ANSWER_SPLIT    = 1;
    private static final int ONE_SECOND      = 1;
    private static final int MIN_LENGTH      = 2;
    private static final String DELIMITER    = "\\|";
    private static final int NUM_QUESTIONS   = 10;
    private static final int START_TIME_SECS = 90;
    private static final Path QUIZ_FILE_PATH = Paths.get("comp2522", "data", "quiz.txt");

    private final List<Question> questions = new ArrayList<>();
    private List<Question> quizQuestions   = new ArrayList<>();

    private Question current;

    private int currentQuestionIndex;
    private int correctCount;
    private int wrongCount;
    private int remainingSeconds;

    private Timeline timeline;

    // UI
    private VBox root;
    private Label questionLabel;
    private Label feedbackLabel;
    private Label statusLabel;
    private TextField answerField;
    private Button submitButton;
    private Button startButton;
    private Button playAgainButton;

    private void readQuestions(final Path path)
    {
        if (!questions.isEmpty())
        {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(path.toAbsolutePath().toFile())))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                final String[] parts = line.split(DELIMITER);
                if (parts.length < MIN_LENGTH)
                {
                    // Skip lines
                    continue;
                }

                final String questionText = parts[QUESTION_SPLIT];
                final String[] answers    = parts[ANSWER_SPLIT].split(",");

                questions.add(new Question(
                        questionText,
                        answers
                ));
            }
        }
        catch (final FileNotFoundException e)
        {
            System.out.println("Unable to open file: " + path);
        }
        catch (final IOException e)
        {
            System.out.println("Error reading file: " + path);
        }
    }

    @Override
    public void start(final Stage stage)
    {

        root = new VBox();
        root.setPrefSize(WIDTH, HEIGHT);

        questionLabel = new Label("Click \"Start quiz\" to begin.");
        feedbackLabel = new Label();
        statusLabel = new Label();

        answerField = new TextField();
        answerField.setPromptText("Type your answer here");

        submitButton = new Button("Submit");
        startButton = new Button("Start quiz");
        playAgainButton = new Button("Play again");

        // Initial UI state: game not started yet
        answerField.setDisable(true);
        submitButton.setDisable(true);
        playAgainButton.setDisable(true);
        playAgainButton.setVisible(false);

        root.getChildren().addAll(
                questionLabel,
                answerField,
                submitButton,
                feedbackLabel,
                statusLabel,
                startButton,
                playAgainButton
        );

        Scene scene = new Scene(root);

        scene.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm()
        );

        readQuestions(QUIZ_FILE_PATH);

        if (questions.isEmpty())
        {
            questionLabel.setText("No questions loaded. Check quiz.txt path/contents.");
            startButton.setDisable(true);
            stage.setScene(scene);
            stage.show();
            return;
        }

        final Runnable submitAction = () -> {
            // If game is not running
            if (current == null)
            {
                return;
            }

            final String userAnswer;
            userAnswer = answerField.getText();

            if (userAnswer == null || userAnswer.isBlank())
            {
                feedbackLabel.setText("Please enter an answer.");
                return;
            }

            final String cleaned = userAnswer.trim();

            if (current.validateAnswer(cleaned))
            {
                correctCount++;
            }
            else {
                wrongCount++;
            }

            // One chance per question: move immediately to next
            currentQuestionIndex++;
            showNextQuestion();
        };

        submitButton.setOnAction(event -> submitAction.run());
        answerField.setOnAction(event -> submitAction.run());

        // Start quiz button
        startButton.setOnAction(event -> startGame());

        // Play again button (same as start, but different state)
        playAgainButton.setOnAction(event -> startGame());

        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();
    }

    private void startGame()
    {

        correctCount = COUNTER_STARTER;
        wrongCount   = COUNTER_STARTER;
        remainingSeconds = START_TIME_SECS;
        currentQuestionIndex = COUNTER_STARTER;
        feedbackLabel.setText("");
        questionLabel.setText("");

        quizQuestions = new ArrayList<>(questions);
        Collections.shuffle(quizQuestions);

        if (quizQuestions.size() > NUM_QUESTIONS)
        {
            quizQuestions = new ArrayList<>(quizQuestions.subList(COUNTER_STARTER, NUM_QUESTIONS));
        }

        // Timer
        if (timeline != null)
        {
            timeline.stop();
        }

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(ONE_SECOND), event -> {
                    remainingSeconds--;
                    updateStatusLabel();

                    if (remainingSeconds <= COUNTER_STARTER)
                    {
                        endGame("Time's up!");
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        answerField.setDisable(false);
        submitButton.setDisable(false);
        startButton.setDisable(true);
        playAgainButton.setDisable(true);
        playAgainButton.setVisible(false);

        // Start with first question
        showNextQuestion();
    }

    private void showNextQuestion()
    {

        if (currentQuestionIndex >= quizQuestions.size())
        {
            endGame("You answered all questions.");
            return;
        }

        current = quizQuestions.get(currentQuestionIndex);

        questionLabel.setText(current.getQuestion());
        answerField.clear();
        feedbackLabel.setText("");

        updateStatusLabel();
    }

    private void updateStatusLabel()
    {
        if (quizQuestions.isEmpty())
        {
            statusLabel.setText("");
            return;
        }

        final int displayIndex = Math.min(currentQuestionIndex + ONE_SECOND, quizQuestions.size());
        statusLabel.setText(
                displayIndex + "/" + quizQuestions.size()
                        + " ::: " + remainingSeconds + "s remaining"
        );
    }

    private void endGame(final String reason)
    {

        if (timeline != null)
        {
            timeline.stop();
        }
        
        submitButton.setDisable(true);
        answerField.setDisable(true);
        current = null; // mark game as ended

        // Final score on screen
        final String finalScore =
                reason + "\n\nFinal score:"
                        + "\nCorrect: " + correctCount
                        + "\nWrong:   " + wrongCount;

        feedbackLabel.setText(finalScore);

        // Clear question + status, show restart UI
        questionLabel.setText("Game over.");
        statusLabel.setText("");

        // Show "Play again" button
        playAgainButton.setVisible(true);
        playAgainButton.setDisable(false);

        startButton.setVisible(false);
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}
