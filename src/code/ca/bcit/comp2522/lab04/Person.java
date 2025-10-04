package ca.bcit.comp2522.lab04;

/**
 * Person contains date of birth, death, and a name.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Person
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    /**
     * validateObject ensures a given object is not null
     * @param object to ensure is not null
     * @param objectName variable name of object for log
     */
    private static void validateObject(
            final Object object,
            final String objectName
    ) {
        if (object == null) {
            throw new IllegalArgumentException(objectName + " cannot be null");
        }
    }

    /**
     * Person construct
     * @param dateOfBirth of person, cannot be null
     * @param dateOfDeath of person, can be null
     * @param name of person
     */
    public Person(
        final Date dateOfBirth,
        final Date dateOfDeath,
        final Name name
    ) {
        validateObject(dateOfBirth, "date of birth");
        validateObject(name, "name");

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }
}
