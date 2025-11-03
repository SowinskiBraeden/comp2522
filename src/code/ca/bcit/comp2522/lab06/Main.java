package ca.bcit.comp2522.lab06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Demonstrates the use of the HockeyPlayer and HockeyTeam classes along with
 * functional programming concepts such as Supplier, Predicate, Function,
 * Consumer, UnaryOperator, and Comparator.
 *
 * <p>This class creates a sample team, performs various operations
 * using functional interfaces, and prints the results to the console.</p>
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Main
{
    private static final int CURRENT_YEAR = 2025;
    private static final int HIGH_SCORE_THRESHOLD = 20;
    private static final String FORWARD_POSITION = "F";
    private static final int MIN_AGE = 21;
    private static final int MIN_GOALS = 10;
    private static final int COUNTER_STARTER = 0;
 
    /**
     * Creates and returns a sample hockey team with several HockeyPlayer objects.
     *
     * @return a HockeyTeam instance representing a sample team
     */
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

    /**
     * The program entry point. Demonstrates creation and manipulation
     * of HockeyPlayer and HockeyTeam objects, as well as use of various
     * Java functional interfaces.
     *
     * <p>This method showcases examples of Supplier, Predicate, Function,
     * Consumer, UnaryOperator, and Comparator applied to HockeyPlayer objects.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args)
    {
        final HockeyTeam team;
        final List<HockeyPlayer> roster;
        team = sampleTeam();
        roster = team.getRoster();

        // SUPPLIER — creates a new player on demand
        final Supplier<HockeyPlayer> callUpSupplier =
                () -> new HockeyPlayer("John Doe", "F", 1998, 2);
        roster.add(callUpSupplier.get());

        // PREDICATE — filter players who are forwards and high scorers
        final Predicate<HockeyPlayer> isForward =
                (p) -> p.getPosition().equalsIgnoreCase(FORWARD_POSITION);
        final Predicate<HockeyPlayer> highScore =
                (p) -> p.getGoals() >= HIGH_SCORE_THRESHOLD;

        for (final HockeyPlayer p : roster)
        {
            if (isForward.and(highScore).test(p))
            {
                System.out.println(p);
            }
        }

        // FUNCTION — transform a HockeyPlayer into a formatted string
        final Function<HockeyPlayer, String> playerFunction =
                (p) -> p.getPlayerName() + " — " + p.getPosition()
                        + " (" + p.getGoals() + " goals)";

        for (final HockeyPlayer p : roster)
        {
            System.out.println(playerFunction.apply(p));
        }

        // CONSUMER — process and print player names
        final Consumer<HockeyPlayer> hockeyPlayerConsumer =
                (p) -> System.out.println(p.getPlayerName());

        for (final HockeyPlayer hockeyPlayer : roster)
        {
            hockeyPlayerConsumer.accept(hockeyPlayer);
        }

        // UNARY OPERATOR — convert player names to uppercase
        final UnaryOperator<String> toUpper = (stringInput) -> stringInput.toUpperCase();

        for (final HockeyPlayer hockeyPlayer : roster)
        {
            System.out.println(toUpper.apply(hockeyPlayer.getPlayerName()));
        }

        // COMPARATOR — sort players by goals in descending order
        final Comparator<HockeyPlayer> byGoalsDesc =
                (a, b) -> Integer.compare(b.getGoals(), a.getGoals());
        Collections.sort(roster, byGoalsDesc);

        System.out.println("Sorted by goals (DESC):");
        for (final HockeyPlayer p : roster)
        {
            System.out.println(p.getPlayerName() + " - " + p.getGoals());
        }

        // AGGREGATION — calculate total goals on the roster
        int totalGoals = COUNTER_STARTER;
        for (final HockeyPlayer p : roster)
        {
            totalGoals += p.getGoals();
        }
        System.out.println("Total goals on roster: " + totalGoals);

        // FUNCTIONAL INTERFACE (EligibilityRule)
        // A player is eligible if age >= minAge AND goals >= minGoals
        final EligibilityRule rule =
                (p) -> ((CURRENT_YEAR - p.getYearOfBirth()) >= MIN_AGE)
                        && (p.getGoals() >= MIN_GOALS);

        System.out.println("Eligible players (age >= "
                + MIN_AGE + ", goals >= "
                + MIN_GOALS + "):");

        for (final HockeyPlayer p : roster)
        {
            if (rule.isEligible(p))
            {
                System.out.println(p.getPlayerName());
            }
        }
    }
}
