package ca.bcit.comp2522.lab03;

public abstract class IDevice {
    private final String purpose;

    IDevice(final String purpose) {
        this.purpose = purpose;
    }

    abstract void printDetails();

    protected String getPurpose() {
        return this.purpose;
    }

    @Override
    public String toString() {
        return this.purpose;
    }
}
