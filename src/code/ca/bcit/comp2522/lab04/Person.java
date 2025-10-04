package ca.bcit.comp2522.lab04;

// TODO: implement Comparable, Printable, Reversible

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
        Validator.validateObject(dateOfBirth, "date of birth");
        Validator.validateObject(name, "name");

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }
}
