package ca.bcit.comp2522.lab10;

/**
 * Validator is a helper class to validate inputs
 *
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Nico Agostini
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Validator
{
    /**
     * validateString ensures string input is not null or empty
     * @param str - The String to validate
     * @throws IllegalArgumentException if invalid string
     */
    public static void validateString(final String str)
        throws IllegalArgumentException
    {
        if (str == null || str.isEmpty())
        {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
    }
}
