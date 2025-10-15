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
public class Biography extends Book implements Printable
{
    final Person subject;

    /**
     * Biography constructor
     * @param title of Biography
     * @param year published
     * @param author of Biography
     * @param subject that the Biography is about
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

    @Override
    public boolean equals(final Object o)
    {

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Biography other;
        other = (Biography)o;

        if (this == o)
        {
            return true;
        }

        return this.subject.equals(other.subject);
    }

    @Override
    public int hashCode()
    {
        if (subject == null)
        {
            return 0;
        }
        return subject.hashCode();
    }


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
}
