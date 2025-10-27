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
public class Name
        implements Printable
{
    private static final int MAX_NAME_CHARACTERS = 50;

    private final String first;
    private final String last;

    /**
     * Name constructor
     * @param first name to save
     * @param last name to save
     */
    public Name(final String first, final String last)
    {
        Validator.validateString(first, MAX_NAME_CHARACTERS);
        Validator.validateString(last, MAX_NAME_CHARACTERS);

        this.first = first;
        this.last = last;
    }

    /**
     * getFullName includes the first and last name
     * @return first name and last name
     */
    protected String getFullName(){
        return this.first + " " + this.last;
    }

    /**
     * display the full name, first and last
     */
    @Override
    public void display()
    {
        System.out.println(first + " " + last);
    }
}
