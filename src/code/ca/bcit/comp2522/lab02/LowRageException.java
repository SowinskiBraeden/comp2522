package ca.bcit.comp2522.lab02;

/**
 * LowRageException is a checked exception
 * when rage is too low to deal damage.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class LowRageException extends Exception {

    /**
     * LowRageException constructor
     * @param message LowRageException error message
     */
    public LowRageException(final String message) {
        super(message);
    }
}
