package ca.bcit.comp2522.lab04;

// TODO: Implement Comparable, Printable, Reversible

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
    private static final int MAX_TITLE_LENGTH = 100;
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

    @Override
    public void display() {

        StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Title: ");
        builder.append(this.title);
        builder.append("\nYear: ");
        builder.append(this.year);
        builder.append("\nAuthor: ");
        builder.append(this.author.getFullName());


        System.out.println(builder.toString());
    }

    @Override
    public void backward()
    {
        final StringBuilder builder;
        builder =  new StringBuilder();

        for (int i = this.title.length() - 1; i >= 0; i--) {
            builder.append(title.charAt(i));
        }

        System.out.println(builder.toString());
    }

    @Override
    public int compareTo(Book other) {
        if (this.year < other.year) {
            return -1;
        } else if (this.year > other.year) {
            return 1;
        }

        return 0;
    }
}
