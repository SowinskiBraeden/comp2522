package ca.bcit.comp2522.lab04;

/**
 * Biography is a Book about a Person
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Biography
        extends Book
        implements Printable
{
    private static final int DEFAULT_HASH_CODE = 0;
    private final Person subject;

    /**
     * Biography constructor
     * @param title String title of Biography
     * @param year int Year Biography was published
     * @param author Author of the Biography
     * @param subject Person that the Biography is about
     */
    public Biography(
        final String title,
        final int    year,
        final Author author,
        final Person subject
    ) {
        super(title, year, author);

        Validator.validateObject(subject, "subject");

        this.subject = subject;
    }

    /**
     * equals checks if a given object is equal to this object
     * @param o Object to check if it is equal to this.
     * @return if the given object is equal
     */
    @Override
    public boolean equals(final Object o)
    {

        if (o == null || !this.getClass().equals(o.getClass()))
        {
            return false;
        }

        final Biography other;
        other = (Biography)o;

        return this.subject.equals(other.getSubject());
    }

    /**
     * hashCode gives the hashcode of the biography
     * @return hash code of biography
     */
    @Override
    public int hashCode()
    {
        if (subject == null)
        {
            return DEFAULT_HASH_CODE;
        }
        return subject.hashCode();
    }

    /**
     * display formatted instance variable of the biography
     */
    @Override
    public void display()
    {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Title: ");
        builder.append(this.title);
        builder.append("\nYear: ");
        builder.append(this.year);
        builder.append("\nAuthor: ");
        builder.append(this.author.getFullName());
        builder.append("\nSubject: ");
        builder.append(this.subject.getFullName());


        System.out.println(builder.toString());
    }

    /**
     * getSubject of the Biography i.e. the Person it is about
     * @return subject of biography
     */
    public Person getSubject() {
        return this.subject;
    }
}
