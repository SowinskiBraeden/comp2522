package ca.bcit.comp2522.lab03;

public class IPad extends IDevice {
    private final boolean hasCase;
    private final String OSVersion;

    IPad(
        final boolean hasCase,
        final String OSVersion
    ) {
        super("learning");

        this.hasCase = hasCase;
        this.OSVersion = OSVersion;
    }

    protected void printDetails() {
        final StringBuilder details;

        details = new StringBuilder();

        details.append("Has case: ");
        details.append(this.hasCase);
        details.append(" OS Version: ");
        details.append(this.OSVersion);

        System.out.println(details.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.hasCase + " " + this.OSVersion;
    }
}
