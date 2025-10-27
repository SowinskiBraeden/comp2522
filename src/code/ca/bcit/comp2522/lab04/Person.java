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
        implements  Comparable<Person>,
                    Printable,
                    Reversible
{
    private static final int SUCCESSFUL_MATCH = 0;

    protected final Date dateOfBirth;
    protected final Date dateOfDeath;
    protected final Name name;

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

    /**
     * getFullName of the Person
     * @return the full name
     */
    public String getFullName(){
        return this.name.getFullName();
    }

    /**
     * getDateOfBirth of person
     * @return the date of birth of the person
     */
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * display formatted instance data of the person
     */
    @Override
    public void display()
    {

        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Date of Birth: ");
        builder.append(this.dateOfBirth.getYyyyMmDd());
        builder.append("\nDate of Death: ");
        builder.append(this.dateOfDeath.getYyyyMmDd());
        builder.append("\nName: ");
        builder.append(this.name.getFullName());

        System.out.println(builder.toString());
    }

    /**
     * backward version of the full name
     */
    @Override
    public void backward()
    {
        final StringBuilder builder;

        builder =  new StringBuilder(this.name.getFullName());

        builder.reverse();

        System.out.println(builder.toString());
    }

    /**
     * compareTo another person based on date of birth
     * @param other person to compare
     * @return if a person is older, younger or same age
     */
    @Override
    public int compareTo(final Person other) {
        return this.dateOfBirth.compareTo(other.dateOfBirth);
    }

    /**
     * equals checks if another given object is equal to this object
     * @param o   the reference object with which to compare.
     * @return if given object are equals
     */
    public boolean equals(final Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        final Person p = (Person)o;

        return p.getFullName().equals(this.getFullName()) &&
               this.getDateOfBirth().compareTo(p.getDateOfBirth()) == SUCCESSFUL_MATCH;
    }
}
