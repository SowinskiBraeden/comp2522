package ca.bcit.comp2522.lab03;

public class IPhone extends IDevice {
    private final double remainingPhonePlanMinutes;
    private final String carrier;

    IPhone(
        final double remainingPhonePlanMinutes,
        final String carrier
    ) {
        super("talking");

        this.remainingPhonePlanMinutes = remainingPhonePlanMinutes;
        this.carrier = carrier;
    }

    protected void printDetails() {
        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.remainingPhonePlanMinutes);
        details.append(" remaining minutes (");
        details.append(this.carrier);
        details.append(")");

        System.out.println(details.toString());
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.remainingPhonePlanMinutes + " " + this.carrier;
    }
}
