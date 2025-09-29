package ca.bcit.comp2522.lab03;

/**
 * IDevice holds common information between
 * devices and common functionality.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public abstract class IDevice
{

    private final static int MIN_PURPOSE_CHARACTER = 1;
    private final static int MAX_PURPOSE_CHARACTER = 255;

    private final String purpose;

    /**
     * IDevice constructor
     *
     * @param purpose of IDevice
     */
    public IDevice(final String purpose)
    {

        stringValidator(
            purpose,
            MIN_PURPOSE_CHARACTER,
            MAX_PURPOSE_CHARACTER
        );

        this.purpose = purpose;
    }

    /**
     * printDetails of IDevice child
     */
    public abstract void printDetails();

    /**
     * getPurpose of IDevice
     *
     * @return purpose of IDevice
     */
    public String getPurpose() {
        return this.purpose;
    }

    /**
     * toString returns details of IDevice
     *
     * @return purpose of IDevice
     */
    @Override
    public String toString() {
        return this.purpose;
    }

    /**
     * stringValidator checks if the string is within character
     * bounds and if it is blank, null or empty.
     * @param toBeValidated passes the string that needs to be validated.
     * @param maxCharacterCount passes the maximum number of characters that can be accepted
     *                          as an integer.
     * @param minCharacterCount passes the minimum number of characters that can be accepted
     *                          as an integer.
     * */
    public void stringValidator(
        final String toBeValidated,
        final int    minCharacterCount,
        final int    maxCharacterCount
    )
        throws IllegalArgumentException
    {

        if (toBeValidated == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (toBeValidated.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be empty");
        }
        if (toBeValidated.isBlank()) {
            throw new IllegalArgumentException("Value cannot be blank");
        }
        if (toBeValidated.length() < minCharacterCount ||
            toBeValidated.length() > maxCharacterCount
        )
        {
            throw new IllegalArgumentException("Value length must be between" +
                    minCharacterCount + "and " + maxCharacterCount + " characters");
        }
    }
}

