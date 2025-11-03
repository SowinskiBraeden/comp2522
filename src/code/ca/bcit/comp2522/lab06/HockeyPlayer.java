package ca.bcit.comp2522.lab06;

/**
 * HockeyPlayer holds information of a
 * hockey player and their simple stats.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class HockeyPlayer {
    private static String FORWARD = "F";
    private static String DEFENCE = "D";
    private static String GOALIE  = "G";

    private final String name;
    private final String position;
    private final int    yearOfBirth;
    private final int    goals;

    private static void validateString(final String str)
        throws IllegalArgumentException
    {
        if (str == null || str.isEmpty())
        {
            throw new IllegalArgumentException("invalid string");
        }
    }

    private void validatePosition(final String positionToValidate)
    {

        if (position != null &&
                (  position.equals(FORWARD)
                        || position.equals(DEFENCE)
                        || position.equals(GOALIE)))
        {
            throw new IllegalArgumentException("Position not accepted.");
        }
    }

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

    protected String getPlayerName(){
        return this.name;
    }

    protected String getPosition(){
        return this.position;
    }

    protected int getGoals(){
        return this.goals;
    }

    protected int getYearOfBirth(){
        return this.yearOfBirth;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
