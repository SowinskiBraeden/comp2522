package ca.bcit.comp2522.lab06;

/**
 * HockeyPlayer holds information of a
 * hockey player and their simple stats.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class HockeyPlayer {
    private static char FORWARD = 'F';
    private static char DEFENCE = 'D';
    private static char GOALIE  = 'G';

    private final String name;
    private final char position;
    private final int yearOfBirth;
    private final int goals;

    private static void validateString(final String str)
        throws IllegalArgumentException
    {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("invalid string");
        }
    }

    private static void validatePosition(final char pos)
        throws IllegalArgumentException
    {
        final char posUpper = Character.toUpperCase(pos);

        if (posUpper != FORWARD &&
            posUpper != DEFENCE &&
            posUpper != GOALIE
        ) {
            throw new IllegalArgumentException("invalid position");
        }
    }

    public HockeyPlayer(
        final String name,
        final char position,
        final int yearOfBirth,
        final int goals
    ) {
        validateString(name);
        validatePosition(position);

        this.name = name;
        this.position = position;
        this.yearOfBirth = yearOfBirth;
        this.goals = goals;
    }
}
