package ca.bcit.comp2522.lab01;

/**
 * Name contains first and last names,
 * as well as useful functions for names.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public final class Name {
    private static final int MAX_CHARACTERS = 45;
    private static final int FIRST_CHARACTER = 0;
    private static final int SECOND_CHARACTER = 1;
    private static final int HALF = 2;
    private static final int INDEX_OFFSET = 1;

    private final String first;
    private final String last;

    /*
        validateString ensures that any input string is not blank,
        within the string length limit, and does not contain admin.
     */
    private static void validateString(final String input)
            throws IllegalArgumentException {

        if (input.length() > MAX_CHARACTERS) {
            throw new IllegalArgumentException("input is too long");
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException("input cannot be empty");
        }

        if (input.contains("admin")) {
            throw new IllegalArgumentException("input cannot contain \"admin\"");
        }
    }

    /*
        capitalize takes in a String, and ensures the first letter is
        uppercase while all other letters are lowercase
     */
    private static String capitalize(final String input) {

        final String capitalizedFirstCharacter;
        final String lowerCaseRemainingCharacters;
        final String result;

        capitalizedFirstCharacter    = input.substring(FIRST_CHARACTER, SECOND_CHARACTER).toUpperCase();
        lowerCaseRemainingCharacters = input.substring(SECOND_CHARACTER).toLowerCase();

        result = capitalizedFirstCharacter + lowerCaseRemainingCharacters;

        return result;
    }

    /**
     * Name constructor
     * @param first name as String
     * @param last name as String
     */
    public Name(final String first, final String last) {

        validateString(first);
        validateString(last);

        this.first = capitalize(first);
        this.last = capitalize(last);
    }

    /**
     * getInitials returns first letter of first and last name.
     * @return initials
     */
    public final String getInitials() {

        return this.first.charAt(FIRST_CHARACTER) + "." + this.last.charAt(FIRST_CHARACTER) + ".";
    }

    /**
     * getFullName returns both the first and last name.
     * @return the first and last name
     */
    public final String getFullName() {

        return this.first + " " + this.last;
    }

    /**
     * getFirst name
     * @return first name
     */
    public final String getFirst() {

        return this.first;
    }

    /**
     * getLast name
     * @return last name
     */
    public final String getLast() {

        return this.last;
    }

    /**
     * getReverseName returns the full name in reverse
     * @return full name reversed
     */
    public final String getReverseName() {

        final String fullName;
        final String fullNameReversed;
        fullName = this.first + " " + this.last;

        char currentCharacter;
        final char[] nameCharacters;

        nameCharacters = fullName.toCharArray();

        for (int i = 0; i < nameCharacters.length / HALF; i++) {
            final int currentIndex;
            currentIndex = nameCharacters.length - INDEX_OFFSET - i;

            currentCharacter = nameCharacters[currentIndex];
            nameCharacters[currentIndex] = nameCharacters[i];
            nameCharacters[i] = currentCharacter;
        }

        fullNameReversed = new String(nameCharacters);

        return fullNameReversed;
    }
}
