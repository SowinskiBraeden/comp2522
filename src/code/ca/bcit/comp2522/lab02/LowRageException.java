package ca.bcit.comp2522.lab02;

/**
 * LowRageException is a checked exception
 * when rage is too low to deal damage.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class LowRageException extends Exception {
    public LowRageException(final String message) {
        super(message);
    }
}
