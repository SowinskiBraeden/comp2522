package ca.bcit.comp2522.lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        throws FileNotFoundException
    {
        this.wordList = new ArrayList<>();

        final Scanner fileScanner;
        final File file = new File(filePath);

        fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine())
        {
            this.wordList.add(fileScanner.nextLine());
        }

        fileScanner.close();
    }

    /**
     * Returns a random word from the list.
     *
     * @return a randomly selected word.
     */
    public String getRandomWord()
    {
        final Random rand = new Random();

        return this.wordList.get(rand.nextInt(this.wordList.size()));
    }
}
