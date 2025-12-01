package ca.bcit.comp2522.lab11;

/**
 * Represents a single quiz question containing a question prompt
 * and one or more valid answers. A user-provided answer is considered
 * correct if it matches any of the stored answers, ignoring case.
 *
 * This class performs validation to ensure question text and answer
 * strings are never null or blank.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Question
{
    private static final int MIN_ANSWERS = 1;

    private final String   question;
    private final String[] answers;

    /**
     * Validates that a string is not null or blank.
     *
     * @param str the string to validate
     * @throws IllegalArgumentException if the string is null or blank
     */
    private static void validateString(final String str)
    {
        if (str == null || str.isBlank())
        {
            throw new IllegalArgumentException("Invalid string");
        }
    }

    /**
     * Constructs a Question with a prompt and accepted answers.
     *
     * @param question the question text
     * @param answers  the list of valid answers
     * @throws IllegalArgumentException if question is invalid,
     *                                  or if answers is empty,
     *                                  or if any individual answer is invalid
     */
    public Question(
            final String question,
            final String[] answers
    ) {
        validateString(question);

        if (answers.length < MIN_ANSWERS)
        {
            throw new IllegalArgumentException("Answers must not be empty");
        }

        for (final String answer : answers)
        {
            validateString(answer);
        }

        this.question = question;
        this.answers  = answers;
    }

    /**
     * Returns the question text.
     *
     * @return the question string
     */
    public String getQuestion()
    {
        return this.question;
    }

    /**
     * Returns the list of accepted answers.
     *
     * @return an array of valid answers
     */
    public String[] getAnswers()
    {
        return this.answers;
    }

    public String getAnswersString()
    {
        final StringBuilder sb;
        sb = new StringBuilder();

        for (final String answer : this.answers)
        {
            sb.append(answer);
            sb.append(", ");
        }

        return sb.toString();
    }

    /**
     * Checks whether a user's answer is correct.
     * Matching is case-insensitive.
     *
     * @param userAnswer the answer provided by the user
     * @return true if it matches one of the valid answers; false otherwise
     */
    public boolean validateAnswer(final String userAnswer)
    {
        for (final String answer : this.answers)
        {
            if (answer.equalsIgnoreCase(userAnswer))
            {
                return true;
            }
        }

        return false;
    }
}
