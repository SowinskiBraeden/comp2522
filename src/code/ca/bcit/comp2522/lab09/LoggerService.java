package ca.bcit.comp2522.lab09;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Creates and writes game logs for each play session.
 * Each guess and outcome is recorded with a timestamp.
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class LoggerService
{
    private static final Path BASE_PATH = Paths.get("data", "logs");
    private static final String DATE_PATTERN = "YYYY-MM-dd_HH-mm-ss";

    private final BufferedWriter writer;

    /**
     * getDateTime returns a string of the
     * date and time for the logs
     * @return date time string formatted as the pattern
     */
    private static String getDateTime()
    {
        final LocalDateTime now;
        final DateTimeFormatter formatter;

        now = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        return now.format(formatter);
    }

    /**
     * Creates a new log file for a game session.
     *
     * @param country the correct word used in the round.
     * @throws IOException if the log directory or file cannot be created.
     */
    public LoggerService(final String country)
        throws IOException
    {
        Files.createDirectories(BASE_PATH);

        final String logFilename = BASE_PATH + "/" + getDateTime() + "_" + country + ".txt";

        this.writer = new BufferedWriter(new FileWriter(logFilename));
    }

    /**
     * Writes a log entry.
     *
     * @param guess   the player's guess.
     * @param outcome the result of the guess.
     */
    public void log(final String guess, final String outcome)
    {
        final StringBuilder log = new StringBuilder();

        log.append(getDateTime());
        log.append(" Guess: ");
        log.append(guess);
        log.append(" Outcome: ");
        log.append(outcome);

        try {
            this.writer.write(log.toString());
            this.writer.newLine();
        }
        catch (final IOException e)
        {
            System.err.printf("Failed to write to log: %s\n", e.getMessage());
        }
    }

    /**
     * Saves and closes the log file.
     */
    public void saveLog()
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
