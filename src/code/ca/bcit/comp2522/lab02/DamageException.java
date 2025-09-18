package ca.bcit.comp2522.lab02;

/**
 * DamageException is an unchecked exception
 * for when a given damage value is invalid.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class DamageException extends RuntimeException {
    public DamageException(String message) {
        super(message);
    }
}
