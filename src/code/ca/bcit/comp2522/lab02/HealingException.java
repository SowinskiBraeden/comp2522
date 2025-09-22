package ca.bcit.comp2522.lab02;

/**
 * HealingException is an unchecked exception
 * for when a given healing value is invalid.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class HealingException extends RuntimeException
{
    public HealingException(final String message) {
        super(message);
    }
}
