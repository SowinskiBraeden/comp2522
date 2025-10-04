package ca.bcit.comp2522.lab04;

/**
 * Name class holds first and last name,
 * and validates name lengths
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Name implements Printable
{
    private final String first;
    private final String last;

    private static final int MAX_CHARACTERS = 50;

    /**
     * stringValidator checks the string being passed into it for
     * being null, blank, empty or over the limit of characters.
     *
     * @param stringToCheck passes the string to be checked.
     * @param maxLength passes the integer value of the number of character count
     *                  the String can be.
     * */
    private static void stringValidator(final String stringToCheck, final int maxLength)
    {

        if (stringToCheck == null)
        {
            throw new IllegalArgumentException("String cannot be null");
        }

        if (stringToCheck.isEmpty() ||
            stringToCheck.isBlank())
        {
            throw new IllegalArgumentException("String cannot be empty or blank");
        }

        if (stringToCheck.length() > maxLength)
        {
            throw new IllegalArgumentException(
                    "String longer than " + maxLength +
                    " characters"
            );
        }
    }

    /**
     * stringValidator with default MAX_CHARACTERS restriction
     * @param stringToCheck passes the string to be checked
     */
    private static void stringValidator(final String stringToCheck)
    {
        stringValidator(stringToCheck, MAX_CHARACTERS);
    }

    /**
     * Name constructor
     * @param first name to save
     * @param last name to save
     */
    public Name(final String first, final String last)
    {
        stringValidator(first);
        stringValidator(last);

        this.first = first;
        this.last = last;
    }

    @Override
    public void display()
    {
        System.out.println("First: " + first + " Last: " + last);
    }
}
