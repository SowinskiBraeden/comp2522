package ca.bcit.comp2522.lab03;

public class IPod extends IDevice {
    private final int numberOfSongs;
    private final double maxVolumeDecibels;

    IPod(
        final int numberOfSongs,
        final double maxVolumeDecibels
    ) {
        super("music");

        this.numberOfSongs = numberOfSongs;
        this.maxVolumeDecibels = maxVolumeDecibels;
    }

    protected void printDetails() {
        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.numberOfSongs);
        details.append(" songs, ");
        details.append(this.maxVolumeDecibels);
        details.append(" dB.");

        System.out.println(details.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " " +  this.numberOfSongs + " " + this.maxVolumeDecibels;
    }
}
