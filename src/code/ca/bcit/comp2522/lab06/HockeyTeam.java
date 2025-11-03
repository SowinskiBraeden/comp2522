package ca.bcit.comp2522.lab06;

import java.util.List;

/**
 * Represents a hockey team containing a team name and a roster of HockeyPlayer objects.
 *
 * <p>This class validates input to ensure that a team's name
 * is properly initialized and that a valid roster is provided.</p>
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class HockeyTeam
{
    private final String name;
    private final List<HockeyPlayer> roster;

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
     * Constructs a new HockeyTeam with the specified name and roster.
     *
     * @param name the name of the team
     * @param roster the list of HockeyPlayer objects representing the team's roster
     * @throws IllegalArgumentException if the team name is invalid
     */
    public HockeyTeam(
            final String name,
            final List<HockeyPlayer> roster
    )
    {
        validateString(name);

        this.name = name;
        this.roster = roster;
    }

    /**
     * Returns the name of the team.
     *
     * @return the team name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the roster of HockeyPlayers belonging to the team.
     *
     * @return the team's roster as a List of HockeyPlayer objects
     */
    public List<HockeyPlayer> getRoster()
    {
        return this.roster;
    }
}
