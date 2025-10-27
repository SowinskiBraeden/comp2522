package ca.bcit.comp2522.lab04;

/**
 * Validator provides useful validation methods
 * that many classes can use.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public final class Validator
{

    /**
     * validateString ensures a string is not empty, blank,
     * null or greater than maxLength
     * @param string String to validate
     * @param maxLength int max length that string can be
     */
    public static void validateString(final String string, final int maxLength) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("string cannot be null or empty");
        }

        if (string.length() > maxLength) {
            throw new IllegalArgumentException("string cannot be longer than " + maxLength);
        }
    }

    /**
     * validateObject ensures a given object is not null
     * @param object Object to ensure is not null
     * @param objectName variable name of object for log
     */
    public static void validateObject(
            final Object object,
            final String objectName
    ) {
        if (object == null) {
            throw new IllegalArgumentException(objectName + " cannot be null");
        }
    }

    /**
     * validateInteger ensures a given number is within
     * the correct provided range
     * @param number int to validate
     * @param min minimum int of range inclusive
     * @param max maximum int of range inclusive
     */
    public static void validateInteger(
        final int number,
        final int min,
        final int max
    ) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(number + " is out of range" + min + " to " + max);
        }
    }
}
