package ca.bcit.comp2522.lab04;

public class Name {
    private final String first;
    private final String last;

    private static final int MAX_CHARACTERS = 50;


    public Name(final String first, final String last)
    {
        stringValidator(first, MAX_CHARACTERS);
        stringValidator(last,  MAX_CHARACTERS);
        this.first = first;
        this.last = last;
    }

    /**
     * stringValidator checks the string being passed into it for
     * being null, blank, empty or over the limit of characters.
     *
     * @param stringToCheck passes the string to be checked.
     * @param maxLength passes the integer value of the number of character count
     *                  the String can be.
     * */
    public void stringValidator(final String stringToCheck,
                                final int maxLength){

        if (stringToCheck == null)
        {
            throw new IllegalArgumentException(
                    "String cannot be null");
        }

        if (stringToCheck.isBlank() ||
                stringToCheck.isEmpty())
        {
            throw new IllegalArgumentException(
                    "String cannot be empty or blank");
        }

        if (stringToCheck.length() > maxLength)
        {
            throw new IllegalArgumentException(
                    "String longer than " + maxLength +
                            " characters");
        }
    }

    public void stringValidator(final String stringToCheck)
    {

        if (stringToCheck == null)
        {
            throw new IllegalArgumentException(
                    "String cannot be null");
        }

        if (stringToCheck.isBlank() ||
                stringToCheck.isEmpty())
        {
            throw new IllegalArgumentException(
                    "String cannot be empty or blank");
        }
    }
}
