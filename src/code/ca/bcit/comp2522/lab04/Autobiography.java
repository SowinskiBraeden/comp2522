package ca.bcit.comp2522.lab04;

/**
 * Autobiography is just a Biography about the
 * author and not another Person.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Autobiography extends Biography
{
    /**
     * Autobiography constructor
     * @param title of autobiography
     * @param year published
     * @param author and subject of autobiography
     */
    public Autobiography(
        final String title,
        final int    year,
        final Author author
    ) {
        super(title, year, author, author);
    }
}
