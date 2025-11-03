package ca.bcit.comp2522.lab06;

/**
 * EligibilityRule is a way to enforce defined rules of a
 * HockeyPlayer
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
*/
@FunctionalInterface
public interface EligibilityRule {
    /**
     * isEligible method.
     *
     * @param player A hockey player
     * @return True or False. True if player is eligible, false otherwise.
     */
    boolean isEligible(HockeyPlayer player);
}