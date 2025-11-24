package ca.bcit.comp2522.lab11;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz extends Application
{
    private static final int WIDTH          = 800;
    private static final int HEIGHT         = 600;
    private static final int QUESTION_SPLIT = 0;
    private static final int ANSWER_SPLIT   = 1;
    private static final String DELIMITER   = "\\|";
    private static final int NUM_QUESTIONS  = 10;

    private final List<Question> questions = new ArrayList<>();
    private Question current;

    private void readQuestions(final String file)
    {
        final BufferedReader reader;

        try
        {
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null)
            {
                final String question;
                final String[] answers;

                question = line.split(DELIMITER)[QUESTION_SPLIT];
                answers  = line.split(DELIMITER)[ANSWER_SPLIT].split(",");

                questions.add(new Question(
                    question,
                    answers
                ));
            }
        }
        catch (final FileNotFoundException e)
        {
            System.out.println("Unable to open file: " + file);
        }
        catch (final IOException e)
        {
            System.out.println("Error reading file: " + file);
        }
    }

    @Override
    public void start(final Stage stage)
    {
        final Scene scene;
        final VBox root;

        root = new VBox();
        root.setPrefSize(WIDTH, HEIGHT);
        scene = new Scene(root);

        this.current = this.questions.get(new Random().nextInt(this.questions.size()));



        readQuestions("./data/quiz.txt");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}
