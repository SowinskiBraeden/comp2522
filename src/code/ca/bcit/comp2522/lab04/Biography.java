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
public class Biography extends Book
{
    private final Person subject;

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
}
