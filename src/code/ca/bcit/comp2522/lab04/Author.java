package ca.bcit.comp2522.lab04;

/**
 * Authors are just a Person but also
 * have a genre in which they write.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Author extends Person implements Printable{
    private static final int MAX_GENRE_LENGTH = 30;

    private final String genre;

    /**
     * Author constructor
     * @param name of the author
     * @param dateOfBirth of the author
     * @param dateOfDeath of author if they did die (can be null)
     * @param genre that the author writes in
     */
    public Author(
        final Name name,
        final Date dateOfBirth,
        final Date dateOfDeath,
        final String genre
    ) {
        super(dateOfBirth, dateOfDeath, name);

        Validator.validateString(genre, MAX_GENRE_LENGTH);

        this.genre = genre;
    }

    @Override
    public void display() {

        StringBuilder builder;
        builder = new StringBuilder();

        builder.append("Name: ");
        builder.append(this.name.getFullName());
        builder.append("\nDate of Birth: ");
        builder.append(this.dateOfBirth);
        builder.append("\nDate of Death: ");
        builder.append(this.dateOfDeath);
        builder.append("\nGenre: ");
        builder.append(this.genre);


        System.out.println(builder.toString());
    }
}
