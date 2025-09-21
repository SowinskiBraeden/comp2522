package ca.bcit.comp2522.lab03;

/**
 * IDevice holds common information between
 * devices and common functionality.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public abstract class IDevice {
    private final String purpose;

    /**
     * IDevice constructor
     * @param purpose of IDevice
     */
    public IDevice(final String purpose) {
        this.purpose = purpose;
    }

    /**
     * printDetails of IDevice child
     */
    public abstract void printDetails();

    /**
     * getPurpose of IDevice
     * @return purpose of IDevice
     */
    public String getPurpose() {
        return this.purpose;
    }

    /**
     * toString returns details of IDevice
     * @return purpose of IDevice
     */
    @Override
    public String toString() {
        return this.purpose;
    }
}
