package ca.bcit.comp2522.lab03;

/**
 * IPod is an IDevice that has a number of songs and a max
 * volume in decibels.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class IPod extends IDevice
{

    private static final int NO_SONGS       = 0;
    private static final int IPOD_HASH      = 7;
    private static final int IPOD_HASH_CODE = 97;

    private final int    numberOfSongs;
    private final double maxVolumeDecibels;

    /**
     * IPod constructor
     * @param numberOfSongs the IPod is holding
     * @param maxVolumeDecibels is the maximum volume
     */
    public IPod(
        final int numberOfSongs,
        final double maxVolumeDecibels
    ) {
        super("music");

        numberOfSongsValidator(numberOfSongs);
        this.numberOfSongs = numberOfSongs;

        this.maxVolumeDecibels = maxVolumeDecibels;
    }

    /**
     * printDetails of IPod including number of songs
     * and max volume in decibels.
     */
    public void printDetails()
    {

        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.numberOfSongs);
        details.append(" songs, ");
        details.append(this.maxVolumeDecibels);
        details.append(" dB.");

        System.out.println(details.toString());

    }

    /**
     * getNumberOfSongs of the IPod
     * @return the number of songs
     */
    public int getNumberOfSongs() {
        return this.numberOfSongs;
    }

    /**
     * toString returns the simple string details of the IPod
     * @return IPod instance variables
     */
    @Override
    public String toString()
    {

        final StringBuilder ipodDetails;

        ipodDetails = new StringBuilder();

        ipodDetails.append(super.toString());
        ipodDetails.append(" ");
        ipodDetails.append(this.numberOfSongs);
        ipodDetails.append(" ");
        ipodDetails.append(this.maxVolumeDecibels);

        return ipodDetails.toString();
    }

    /**
     * equals check if a given IPod has the same number of songs as
     * this IPod
     * @param o the reference object with which to compare.
     * @return if the IPods have the same number of songs
     */
    @Override
    public boolean equals(final Object o)
    {

        // Ensure object exists
        if (o == null) {
            return false;
        }

        // Ensure object is an IPod
        if(!(o.getClass().equals(this.getClass()))) {
            return false;
        }

        final IPod otherIPod;

        otherIPod = (IPod) o;

        return otherIPod.getNumberOfSongs() == this.numberOfSongs;

    }

    /**
     * hashCode of IPod
     * @return hash code of IPod
     */
    @Override
    public int hashCode()
    {

        int hash;

        hash = IPOD_HASH_CODE * IPOD_HASH + this.numberOfSongs;

        return hash;

    }

    /**
     * numberOfSongsValidator makes sure the number of songs being
     *                        passed are not negative.
     * @param songNumber passes the value of the number of songs.
     * */
    public void numberOfSongsValidator(final int songNumber)
            throws IllegalArgumentException
    {
        if(songNumber < NO_SONGS)
        {
            throw new IllegalArgumentException("Number of songs cannot be less than 0");
        }
    }
}
