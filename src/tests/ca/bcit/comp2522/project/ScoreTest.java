import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreTest {

    private static final String SCORE_FILE = "test_score.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    void setUp() throws IOException {
        // Clear the score file before each test to ensure no leftover data
        new FileWriter(SCORE_FILE, false).close();
    }

    @Test
    void testScoreCalculation() {
        // Testing score calculation based on correct first and second attempts
        Score score = new Score(LocalDateTime.now(), 1, 6, 2, 1); // 6 first attempts (2 points each), 2 second attempts (1 point each)
        assertEquals(14, score.getScore(), "Score should be 14 points (6 * 2 + 2 * 1)");
    }

    @Test
    void testToStringFormat() {
        // Testing the formatting of the toString() method
        LocalDateTime dateTime = LocalDateTime.now();
        Score score = new Score(dateTime, 1, 6, 2, 1);

        String expected = String.format(
                "Date and Time: %s\nGames Played: 1\nCorrect First Attempts: 6\nCorrect Second Attempts: 2\nIncorrect Attempts: 1\nScore: 14 points\n",
                dateTime.format(formatter)
        );

        assertEquals(expected, score.toString(), "The toString format should match the expected format.");
    }

    @Test
    void testAppendAndRetrieveLargeNumberOfScores() throws IOException {
        // Create 25 scores and write them to the file
        for (int i = 0; i < 25; i++) {
            Score score = new Score(LocalDateTime.now(), 1, i + 1, (i % 3) + 1, (i % 2) + 1);
            Score.appendScoreToFile(score, SCORE_FILE);
        }

        // Read scores from the file
        List<Score> scores = Score.readScoresFromFile(SCORE_FILE);

        // Validate the number of scores and their content
        assertEquals(25, scores.size(), "Twenty-five scores should have been read from the file.");
        for (int i = 0; i < 25; i++) {
            int expectedScore = ((i + 1) * 2) + ((i % 3) + 1);
            assertEquals(expectedScore, scores.get(i).getScore(), "Score for entry " + i + " should match the calculated value.");
        }
    }

    @Test
    void testCheckForNewHighScore() throws IOException {
        // Create some initial scores and add them to the file
        Score score1 = new Score(LocalDateTime.now(), 1, 6, 2, 1); // 14 points
        Score score2 = new Score(LocalDateTime.now(), 1, 9, 1, 0); // 19 points
        Score.appendScoreToFile(score1, SCORE_FILE);
        Score.appendScoreToFile(score2, SCORE_FILE);

        // Add a new score that is NOT a high score
        Score score3 = new Score(LocalDateTime.now(), 1, 7, 2, 1); // 16 points
        Score.appendScoreToFile(score3, SCORE_FILE);

        // Read scores from the file
        List<Score> scores = Score.readScoresFromFile(SCORE_FILE);

        // Verify the highest score is still 19
        int highScore = scores.stream().mapToInt(Score::getScore).max().orElse(0);
        assertEquals(19, highScore, "The highest score should still be 19 points.");
    }

    @Test
    void testNewHighScore() throws IOException {
        // Create some initial scores and add them to the file
        Score score1 = new Score(LocalDateTime.now(), 1, 6, 2, 1); // 14 points
        Score score2 = new Score(LocalDateTime.now(), 1, 9, 1, 0); // 19 points
        Score.appendScoreToFile(score1, SCORE_FILE);
        Score.appendScoreToFile(score2, SCORE_FILE);

        // Add a new score that IS a high score
        Score score3 = new Score(LocalDateTime.now(), 1, 10, 1, 0); // 21 points
        Score.appendScoreToFile(score3, SCORE_FILE);

        // Read scores from the file
        List<Score> scores = Score.readScoresFromFile(SCORE_FILE);

        // Verify the highest score is now 21
        int highScore = scores.stream().mapToInt(Score::getScore).max().orElse(0);
        assertEquals(21, highScore, "The highest score should now be 21 points.");
    }

    @Test
    void testAppendAndCheckMultipleReads() throws IOException {
        // Create initial scores and add them to the file
        for (int i = 0; i < 5; i++) {
            Score score = new Score(LocalDateTime.now(), 1, 5 + i, 1, 1); // Variable scores
            Score.appendScoreToFile(score, SCORE_FILE);
        }

        // Perform the first read
        List<Score> scores1 = Score.readScoresFromFile(SCORE_FILE);
        assertEquals(5, scores1.size(), "There should be 5 scores after the first write and read.");

        // Add more scores to the file
        for (int i = 5; i < 10; i++) {
            Score score = new Score(LocalDateTime.now(), 1, 5 + i, 1, 1); // Variable scores
            Score.appendScoreToFile(score, SCORE_FILE);
        }

        // Perform the second read
        List<Score> scores2 = Score.readScoresFromFile(SCORE_FILE);
        assertEquals(10, scores2.size(), "There should be 10 scores after the second write and read.");
    }

    @Test
    void testEmptyScoreFile() throws IOException {
        // Test reading from an empty score file, should return an empty list
        List<Score> scores = Score.readScoresFromFile(SCORE_FILE);
        assertTrue(scores.isEmpty(), "Reading from an empty file should return an empty list.");
    }

    @AfterEach
    void tearDown() {
        // Clean up by deleting the test score file after each test
        new File(SCORE_FILE).delete();
    }
}
