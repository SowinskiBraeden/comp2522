package ca.bcit.comp2522.lab03;

/**
 * IPad is an IDevice that contains related variables to IPads
 * such as operating system version, and if it has a case.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class IPad extends IDevice {

    private final int MAX_OSVERSION_CHARACTERS = 10;
    private final int MIN_OSVERSION_CHARACTERS = 1;

    private final boolean hasCase;
    private final String OSVersion;

    /**
     * IPad constructor
     * @param hasCase determines if the IPad has a case
     * @param OSVersion of the IPad
     */
    public IPad(
        final boolean hasCase,
        final String OSVersion
    ) {
        super("learning");
        this.hasCase = hasCase;
        stringValidator(OSVersion,
                        MIN_OSVERSION_CHARACTERS,
                        MAX_OSVERSION_CHARACTERS);
        this.OSVersion = OSVersion;
    }

    /**
     * getOSVersion of IPad
     * @return operating system version
     */
    public String getOSVersion() {
        return this.OSVersion;
    }

    /**
     * printDetails of IPad including if it has a case
     * and which operating system version it is running
     */
    public void printDetails() {

        final StringBuilder details;

        details = new StringBuilder();

        details.append("Has case: ");
        details.append(this.hasCase);
        details.append(" OS Version: ");
        details.append(this.OSVersion);

        System.out.println(details.toString());

    }

    /**
     * toString returns the simple string details of the IPad
     * @return IPad instance variables
     */
    @Override
    public String toString() {

        final StringBuilder details;

        details = new StringBuilder();

        details.append(super.toString());
        details.append(" ");
        details.append(this.hasCase);
        details.append(" ");
        details.append(this.OSVersion);

        return details.toString();

    }

    /**
     * equals check if a given IPad has the same operating
     * system version as this IPad
     * @param o the reference object with which to compare.
     * @return if the IPads have the same OS Version
     */
    @Override
    public boolean equals(final Object o) {

        // Ensure object exists
        if (o == null) {
            return false;
        }

        // Ensure object is an IPad
        if(!(o.getClass().equals(this.getClass()))) {
            return false;
        }

        final IPad otherIPad;

        otherIPad = (IPad) o;

        return otherIPad.getOSVersion().equals(this.OSVersion);

    }

    /**
     * hashCode of IPad
     * @return hash code of IPad
     */
    @Override
    public int hashCode() {
        return this.OSVersion.hashCode();
    }
}
