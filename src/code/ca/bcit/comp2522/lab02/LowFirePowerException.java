package ca.bcit.comp2522.lab02;

/**
 * LowFirePowerException is a checked exception
 * when firePower is too low to deal damage.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class LowFirePowerException extends Exception
{
    public LowFirePowerException(final String message) {
        super(message);
    }
}
