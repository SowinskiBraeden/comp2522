package ca.bcit.comp2522.lab11;

public class Question
{
    private static final int MIN_ANSWERS = 1;

    private final String question;
    private final String[] answers;

    private static void validateString(final String str)
    {
        if (str == null || str.isBlank())
        {
            throw new IllegalArgumentException("Invalid string");
        }
    }

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
        this.answers = answers;
    }

    public String getQuestion()
    {
        return this.question;
    }

    public String[] getAnswers()
    {
        return this.answers;
    }

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
