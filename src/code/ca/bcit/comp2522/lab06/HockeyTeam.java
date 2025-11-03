package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * HockeyTeam holds information of a
 * hockey team composed by HockeyPlayers and the team's name.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */

public class HockeyTeam {
    private final String name;
    private final List<HockeyPlayer> roster;

    private static void validateString(final String str)
            throws IllegalArgumentException
    {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("invalid string");
        }
    }

    public HockeyTeam(final String name,
                      final List<HockeyPlayer> roster) {

        validateString(name);

        this.name =   name;
        this.roster = roster;
    }

    public String getName() {
        return this.name;
    }

    public List<HockeyPlayer> getRoster() {
        return this.roster;
    }
}
