package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.List;

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

    public HockeyTeam(final String name) {
        validateString(name);

       this.name = name;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<HockeyPlayer> getRoster() {
        return this.roster;
    }
}
