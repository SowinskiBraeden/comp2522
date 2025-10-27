package ca.bcit.comp2522.lab04;

/**
 * Book has an Author, year, and title
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Book
        implements  Comparable<Book>,
                    Printable,
                    Reversible
{
    private static final int LESS_THAN        = -1;
    private static final int GREATER_THAN     = 1;
    private static final int EQUALS           = 0;
    private static final int MAX_TITLE_LENGTH = 1000;
    private static final int MIN_YEAR         = 1;
    private static final int MAX_YEAR         = 2025;

    protected final String title;
    protected final int    year;
    protected final Author author;

    /**
     * Book constructor
     * @param title of the book
     * @param year the book was published
     * @param author of the book
     */
    public Book(
        final String title,
        final int    year,
        final Author author
    ) {
        Validator.validateString(title, MAX_TITLE_LENGTH);
        Validator.validateObject(author, "author");
        Validator.validateInteger(year, MIN_YEAR, MAX_YEAR);

        this.title = title;
        this.year = year;
        this.author = author;
    }

    /**
     * display formatted instance data of the book
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


        System.out.println(builder.toString());
    }

    /**
     * backward prints the name of the title in reverse
     */
    @Override
    public void backward()
    {
        final StringBuilder builder;
        builder = new StringBuilder(this.title);

        builder.reverse();

        System.out.println(builder.toString());
    }

    /**
     * compareTo another book, books are equal if they are written in the same
     * year
     * @param other book to compare to
     * @return if the given book is older, newer or same age as this book
     */
    @Override
    public int compareTo(final Book other)
    {
        if (this.year < other.year) {
            return LESS_THAN;
        } else if (this.year > other.year) {
            return GREATER_THAN;
        }

        return EQUALS;
    }
}
