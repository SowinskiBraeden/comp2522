package ca.bcit.comp2522.lab06;

/**
 * Represents a hockey player and their basic statistics, including name, position,
 * year of birth, and total goals scored.
 *
 * <p>This class validates all input parameters to ensure
 * that player data is always initialized correctly.</p>
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class HockeyPlayer
{
    private static final String FORWARD = "F";
    private static final String DEFENCE = "D";
    private static final String GOALIE  = "G";

    private final String name;
    private final String position;
    private final int yearOfBirth;
    private final int goals;

    /**
     * Validates a string to ensure it is not null or empty.
     *
     * @param str the string to validate
     * @throws IllegalArgumentException if the string is null or empty
     */
    private static void validateString(final String str)
            throws IllegalArgumentException
    {
        if (str == null || str.isEmpty())
        {
            throw new IllegalArgumentException("Invalid string: cannot be null or empty.");
        }
    }

    /**
     * Validates a player's position to ensure it matches one of the accepted
     * values: F, D, or G.
     *
     * @param positionToValidate the position to validate
     * @throws IllegalArgumentException if the position is invalid
     */
    private void validatePosition(final String positionToValidate)
            throws IllegalArgumentException
    {
        if (positionToValidate == null
                || !(positionToValidate.equals(FORWARD)
                || positionToValidate.equals(DEFENCE)
                || positionToValidate.equals(GOALIE)))
        {
            throw new IllegalArgumentException("Position not accepted: must be F, D, or G.");
        }
    }

    /**
     * Constructs a new HockeyPlayer with the specified attributes.
     *
     * @param name the name of the player
     * @param position the player's position (F, D, or G)
     * @param yearOfBirth the year the player was born
     * @param goals the total number of goals scored by the player
     * @throws IllegalArgumentException if the name or position are invalid
     */
    public HockeyPlayer(
            final String name,
            final String position,
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

    /**
     * Returns the player's name.
     *
     * @return the player's name
     */
    protected String getPlayerName()
    {
        return this.name;
    }

    /**
     * Returns the player's position.
     *
     * @return the player's position
     */
    protected String getPosition()
    {
        return this.position;
    }

    /**
     * Returns the number of goals scored by the player.
     *
     * @return the number of goals
     */
    protected int getGoals()
    {
        return this.goals;
    }

    /**
     * Returns the player's year of birth.
     *
     * @return the player's year of birth
     */
    protected int getYearOfBirth()
    {
        return this.yearOfBirth;
    }

    /**
     * Returns a string representation of the hockey player,
     * which is the player's name.
     *
     * @return the player's name
     */
    @Override
    public String toString()
    {
        return this.name;
    }
}
