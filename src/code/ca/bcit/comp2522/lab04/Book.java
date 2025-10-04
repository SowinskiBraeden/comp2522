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
{
    private static final int MAX_TITLE_LENGTH = 100;
    private static final int MIN_YEAR         = 1;
    private static final int MAX_YEAR         = 2025;

    private final String title;
    private final int    year;
    private final Author author;

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
}
