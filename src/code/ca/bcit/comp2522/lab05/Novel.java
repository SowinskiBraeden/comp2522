package ca.bcit.comp2522.lab05;

/**
 * Novel class stores basic information about a novel
 * and has useful methods for sorting alphabetically.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 */
public class Novel
        implements Comparable<Novel>
{
    private final String title;
    private final String authorName;
    private final int    yearPublished;

    /**
     * Novel constructor
     * @param title of novel
     * @param authorName of the novel
     * @param yearPublished of the novel
     */
    public Novel(
        final String title,
        final String authorName,
        final int    yearPublished
    ) {
        Validator.validateString(title);
        Validator.validateString(authorName);

        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    /**
     * getTitle of the novel
     * @return title of the novel
     */
    public String getTitle() { return this.title; }

    /**
     * getAuthorName of the novel
     * @return author name of the novel
     */
    public String getAuthorName() { return this.authorName; }

    /**
     * getYearPublished of the novel
     * @return novel year published
     */
    public int getYearPublished() { return this.yearPublished; }

    /**
     * compareTo to sort novels based on title
     * @param novel to compare to
     * @return number value of comparison, i.e. >1, 0, <1
     */
    @Override
    public int compareTo(final Novel novel) {
        return this.title.compareTo(novel.getTitle());
    }

    /**
     * toString gives a neat string representation
     * of the novel
     * @return the string representation of novel attributes
     */
    @Override
    public String toString() {
        final StringBuilder builder;
        builder = new StringBuilder();

        builder.append("\"");
        builder.append(this.title);
        builder.append("\"");
        builder.append(" by ");
        builder.append(this.authorName);
        builder.append(", ");
        builder.append(yearPublished);

        return builder.toString();
    }
}
