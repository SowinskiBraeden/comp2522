package ca.bcit.comp2522.lab09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Loads a list of words from a text file and provides random selection.
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class WordList
{
    private final List<String> wordList;

    /**
     * Creates a word list by reading each line of the given file.
     *
     * @param filePath the file containing words.
     * @throws FileNotFoundException if the file cannot be opened.
     */
    public WordList(final String filePath)
        throws IOException
    {
        this.wordList = new ArrayList<>();

        final BufferedReader reader;

        reader = new BufferedReader(new FileReader(filePath));

        String line;
        while((line = reader.readLine()) != null)
        {
            this.wordList.add(line);
        }

        reader.close();
    }

    /**
     * Returns a random word from the list.
     *
     * @return a randomly selected word.
     */
    public String getRandomWord()
    {
        final Random rand;

        rand = new Random();

        return this.wordList.get(rand.nextInt(this.wordList.size()));
    }
}
