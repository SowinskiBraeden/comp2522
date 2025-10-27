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
public class Autobiography extends Biography implements Printable
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

    /**
     * display formatted information about the Autobiography
     */
    @Override
    public void display()
    {

        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Title: ");
        builder.append(this.title);
        builder.append(" - Year: ");
        builder.append(this.year);
        builder.append(" - Author: ");
        builder.append(this.author.getFullName());
        builder.append(" - Subject: ");
        builder.append(this.subject.getFullName());


        System.out.println(builder.toString());
    }
}
