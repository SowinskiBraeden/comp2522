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

/**
 * A timed quiz application that loads questions from an external file
 * and presents them to the user in randomized order. The user has a
 * limited amount of time to answer a fixed number of questions.
 * Final results are shown when time expires or all questions are answered.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
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

    private VBox root;
    private Label questionLabel;
    private Label feedbackLabel;
    private Label statusLabel;
    private TextField answerField;
    private Button submitButton;
    private Button startButton;
    private Button playAgainButton;

    /**
     * Reads and loads quiz questions from a file.
     *
     * @param path the path to the quiz data file
     */
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

    /**
     * Initializes the UI and starts the JavaFX application.
     *
     * @param stage the primary stage
     */
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

            currentQuestionIndex++;
            showNextQuestion();
        };

        submitButton.setOnAction(event -> submitAction.run());
        answerField.setOnAction(event -> submitAction.run());
        startButton.setOnAction(event -> startGame());
        playAgainButton.setOnAction(event -> startGame());

        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();
    }

    /**
     * Starts a new quiz round, resets counters, shuffles questions,
     * and initializes the timer.
     */
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

        showNextQuestion();
    }

    /**
     * Displays the next question or ends the quiz if none remain.
     */
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

    /**
     * Updates the status label to show progress and remaining time.
     */
    private void updateStatusLabel()
    {
        if (quizQuestions.isEmpty())
        {
            statusLabel.setText("");
            return;
        }

        final int displayIndex =
                Math.min(currentQuestionIndex + ONE_SECOND, quizQuestions.size());

        statusLabel.setText(
                displayIndex + "/" + quizQuestions.size()
                        + " ::: " + remainingSeconds + "s remaining"
        );
    }

    /**
     * Ends the game, stops the timer, and displays the final score.
     *
     * @param reason explanation for ending (e.g., time expired)
     */
    private void endGame(final String reason)
    {
        if (timeline != null)
        {
            timeline.stop();
        }

        submitButton.setDisable(true);
        answerField.setDisable(true);
        current = null;

        final String finalScore =
                reason + "\n\nFinal score:"
                        + "\nCorrect: " + correctCount
                        + "\nWrong:   " + wrongCount;

        feedbackLabel.setText(finalScore);

        questionLabel.setText("Game over.");
        statusLabel.setText("");

        playAgainButton.setVisible(true);
        playAgainButton.setDisable(false);
        startButton.setVisible(false);
    }

    /**
     * Standard Java entry point. Launches the JavaFX app.
     *
     * @param args CLI arguments
     */
    public static void main(final String[] args)
    {
        launch(args);
    }
}
