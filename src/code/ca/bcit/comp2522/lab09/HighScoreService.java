package ca.bcit.comp2522.lab09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles loading, tracking, and saving the player's best score.
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class HighScoreService
{
    private static final String FILE_PATH = "./data/highscore.txt";
    private static final String PREFIX    = "COUNTRY=";

    private final BufferedWriter writer;
    private final int highScore;

    /**
     * Creates a HighScoreService and loads the stored high score.
     *
     * @throws IOException if the high score file cannot be read or created.
     */
    public HighScoreService()
        throws IOException
    {
        final File scoreFile;
        final BufferedReader reader;
        final String line;

        scoreFile = new File(FILE_PATH);
        scoreFile.createNewFile();

        reader = new BufferedReader(new FileReader(FILE_PATH));
        line = reader.readLine();

        if (line == null)
        {
            this.highScore = Integer.MAX_VALUE;
        }
        else
        {
            this.highScore = Integer.parseInt(line.replaceAll(PREFIX, ""));
        }

        reader.close();

        this.writer = new BufferedWriter(new FileWriter(FILE_PATH));
    }

    /**
     * Returns the current high score.
     *
     * @return the saved high score.
     */
    public int getHighScore()
    {
        return this.highScore;
    }

    /**
     * Updates the high score if the new score is better.
     *
     * @param newScore the new score to compare.
     */
    public void updateCurrentScore(final int newScore)
    {
        try
        {
            if (newScore < this.highScore)
            {
                this.writer.write(PREFIX + newScore);
            }
            else
            {
                this.writer.write(PREFIX + this.highScore);
            }
        }
        catch (IOException e)
        {
            System.err.printf("Failed to update high score: %s\n", e.getMessage());
        }
    }

    /**
     * Saves the high score file.
     */
    public void saveHighScore()
    {
        try
        {
            writer.close();
        }
        catch(IOException e)
        {
            System.err.println("Error closing the writer: " + e.getMessage());
        }
    }
}
