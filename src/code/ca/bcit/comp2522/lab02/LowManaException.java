package ca.bcit.comp2522.lab02;

/**
 * LowManaException is a checked exception
 * when mana is too low to deal damage.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class LowManaException extends Exception {
    public LowManaException(final String message) {
        super(message);
    }
}
