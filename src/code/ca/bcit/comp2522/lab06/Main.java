package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Main class to instantiate and test the HockeyPlayer and HockeyTeam class.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */

public class Main {

    private static HockeyTeam sampleTeam()
    {
        final List<HockeyPlayer> ps;

        ps = new ArrayList<>();

        ps.add(new HockeyPlayer("Alex Morgan", "F", 2002, 21));
        ps.add(new HockeyPlayer("Ben Carter",  "D", 1999, 6));
        ps.add(new HockeyPlayer("Casey Young", "F", 2004, 28));
        ps.add(new HockeyPlayer("Drew Singh",  "G", 2000, 0));
        ps.add(new HockeyPlayer("Eva Chen",    "D", 2001, 5));

        return new HockeyTeam("BCIT Blizzards", ps);
    }

    public static void main(final String[] args) {

        final int CURRENT_YEAR = 2025;
        final int TWENTY_GOALS = 20;
        final String FORWARD_POSITION = "F";
        final int MIN_AGE = 21;
        final int MIN_GOALS = 10;
        final int COUNTER_STARTER = 0;


        final HockeyTeam team = sampleTeam();
        final List<HockeyPlayer> roster = team.getRoster();


        //  SUPPLIER

        Supplier<HockeyPlayer> callUpSupplier = () ->
                new HockeyPlayer("John Doe","F",1998,2);

        roster.add(callUpSupplier.get());


        //  PREDICATE

        Predicate<HockeyPlayer> isForward = hockeyPlayer -> hockeyPlayer.getPosition().equals(FORWARD_POSITION);
        Predicate<HockeyPlayer> has20Plus = hockeyPlayer -> hockeyPlayer.getGoals() >= TWENTY_GOALS;

        for (HockeyPlayer p : roster) {
            if (isForward.and(has20Plus).test(p)) {
                System.out.println(p);
            }
        }


        //  FUNCTION

        Function<HockeyPlayer, String> playerFunction =
                p -> p.getPlayerName() + " — " + p.getPosition()
                        + " (" + p.getGoals()
                        + " goals)";

        for (HockeyPlayer p : roster)
        {
            String label = playerFunction.apply(p);
            System.out.println(label);
        }


        //  CONSUMER

        Consumer<HockeyPlayer> hockeyPlayerConsumer =
                hockeyPlayer -> System.out.println(hockeyPlayer.getPlayerName());

        for (final HockeyPlayer hockeyPlayer : roster)
        {
            hockeyPlayerConsumer.accept(hockeyPlayer);
        }


        //  UNARY OPERATOR

        UnaryOperator<String> toUpper = stringInput -> stringInput.toUpperCase();

        for (final HockeyPlayer hockeyPlayer : roster)
        {
            System.out.println(toUpper.apply(hockeyPlayer.getPlayerName()));
        }


        //  COMPARATOR - sort by goals DESC (no chaining)

        Comparator<HockeyPlayer> byGoalsDesc =
                (a, b) -> Integer.compare(b.getGoals(), a.getGoals());
        Collections.sort(roster, byGoalsDesc);

        System.out.println("Sorted by goals (DESC):");

        for (final HockeyPlayer p : roster)
        {
            System.out.println(p.getPlayerName()
                    + " - " + p.getGoals());
        }



        //  AGGREGATION (loop) — total goals

        int totalGoals = COUNTER_STARTER; // 0
        for (final HockeyPlayer p : roster)
        {
            totalGoals += p.getGoals();
        }
        System.out.println("Total goals on roster: " + totalGoals);


        // FUNCTIONAL INTERFACE (EligibilityRule)
        // A player is eligible if age >= minAge AND goals >= minGoals

        EligibilityRule rule = p ->
                ((CURRENT_YEAR - p.getYearOfBirth()) >= MIN_AGE)
                        && (p.getGoals() >= MIN_GOALS);

        System.out.println("Eligible players (age >= "
                + MIN_AGE + ", goals >= "
                + MIN_GOALS + "):");
        for (HockeyPlayer p : roster)
        {
            if (rule.isEligible(p))
            {
                System.out.println(p.getPlayerName());
            }
        }
    }
}