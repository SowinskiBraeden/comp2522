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

    public String getFullName(){
        return this.name.getFullName();
    }

    @Override
    public void display() {

        StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Date of Birth: ");
        builder.append(this.dateOfBirth);
        builder.append("\nDate of Death: ");
        builder.append(this.dateOfDeath);
        builder.append("\nName: ");
        builder.append(this.name.getFullName());

        System.out.println(builder.toString());
    }

    @Override
    public void backward()
    {
        final StringBuilder builder;
        final String fullName;

        builder =  new StringBuilder();
        fullName = this.name.getFullName();

        for (int i = fullName.length() - 1; i >= 0; i--) {
            builder.append(fullName.charAt(i));
        }

        System.out.println(builder.toString());
    }


    @Override
    public int compareTo(Person other) {
        return this.dateOfBirth.compareTo(other.dateOfBirth);
    }
}
