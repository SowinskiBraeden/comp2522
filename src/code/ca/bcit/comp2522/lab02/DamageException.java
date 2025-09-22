package ca.bcit.comp2522.lab02;

/**
 * DamageException is an unchecked exception
 * for when a given damage value is invalid.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class DamageException extends RuntimeException {

    /**
     * DamageException constructor
     * @param message of DamageException error
     */
    public DamageException(final String message) {
        super(message);
    }
}
