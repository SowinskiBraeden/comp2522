package ca.bcit.comp2522.lab09;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Game controller for Lucky Vault. Generates a random word and manages gameplay.
 * Tracks user guesses, logging, and high score updates.
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class LuckyVault
{
    private static final int STARTING_VALUE = 0;
    private static final int INVALID_MATCH  = -1;

    private final String country;
    private final LoggerService logger;
    private final HighScoreService highScore;

    /*
     * matchingChars checks how many characters match two
     * given strings
     * @param s1 string one to match
     * @param s2 string two to match
     * @return number of characters matching (same position)
     */
    private static int matchingChars(
        final String s1,
        final String s2
    ) {
        if (s1.length() != s2.length())
        {
            return INVALID_MATCH;
        }

        int matched = STARTING_VALUE;

        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) == s2.charAt(i))
            {
                matched++;
            }
        }

        return matched;
    }

    /**
     * Constructs a LuckyVault game with a random word.
     *
     * @throws IOException if files are missing or unreadable.
     */
    public LuckyVault()
        throws IOException, FileNotFoundException
    {
        final WordList countries = new WordList("./data/countries.txt");

        this.country = countries.getRandomWord();
        this.logger = new LoggerService(this.country);
        this.highScore = new HighScoreService();
    }

    /**
     * Runs the game session.
     */
    public void run()
    {
        final Scanner inputScanner = new Scanner(System.in);
        String input;
        int attempts = STARTING_VALUE;

        System.out.println("Lucky Vault — COUNTRY MODE. Type QUIT to exit.");
        System.out.printf("Secret Word Length: %d\n", country.length());
        System.out.println("Current Best: " + (this.highScore.getHighScore() == Integer.MAX_VALUE ?
                "-" :  this.highScore.getHighScore()));

        while(true)
        {
            System.out.print("Your guess: ");
            input = inputScanner.nextLine();

            if (input.isEmpty())
            {
                System.out.println("Empty guess. Try again.");
                continue;
            }

            if(input.equalsIgnoreCase("QUIT"))
            {
                System.out.println("Bye!");
                break;
            }

            attempts++;

            if (input.length() != this.country.length())
            {
                System.out.printf("Wrong length (%d). Need %d\n", input.length(), this.country.length());
                this.logger.log(input, "wrong_length");
                continue;
            }

            if (!input.equalsIgnoreCase(this.country))
            {
                final int matching = matchingChars(input, this.country);

                System.out.printf("Not it. %d letter(s) correct (correct position).\n", matching);
                this.logger.log(input, "matches=" + matching);
                continue;
            }

            System.out.printf("Correct in %d attempts! Word was: %s\n", attempts, this.country);

            this.logger.log(input, "CORRECT_in=" + attempts);
            this.highScore.updateCurrentScore(attempts);

            break;
        }

        inputScanner.close();
        this.logger.saveLog();
        this.highScore.saveHighScore();
    }
}
