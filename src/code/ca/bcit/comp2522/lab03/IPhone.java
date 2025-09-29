package ca.bcit.comp2522.lab03;

/**
 * IPhone is an IDevice that has a phone plan from a carrier, and
 * how many minutes remain on the phone plan.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class IPhone extends IDevice {
    private static final int MIN_CAREER_CHARACTERS = 3;
    private static final int MAX_CAREER_CHARACTERS = 15;
    private static final double NO_MINUTES_REMAINING = 0.0;
    private static final int IPHONE_HASH = 11;
    private static final int IPHONE_HASH_CODE = 101;

    private final double remainingPhonePlanMinutes;
    private final String carrier;

    /**
     * IPhone constructor
     * @param remainingPhonePlanMinutes on this IPhone
     * @param carrier that the phone plan is registered to
     */
    public IPhone(
        final double remainingPhonePlanMinutes,
        final String carrier)
    {
        super("talking");

        minutesValidator(remainingPhonePlanMinutes);
        this.remainingPhonePlanMinutes = remainingPhonePlanMinutes;

        stringValidator(carrier,
                MIN_CAREER_CHARACTERS,
                MAX_CAREER_CHARACTERS);
        this.carrier = carrier;
    }

    /**
     * getRemainingPhonePlanMinutes of this IPHone
     * @return remaining phone plan minutes
     */
    public double getRemainingPhonePlanMinutes() {
        return this.remainingPhonePlanMinutes;
    }

    /**
     * printDetails of IPhone including carrier and remaining
     * phone plan minutes
     */
    public void printDetails() {

        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.remainingPhonePlanMinutes);
        details.append(" remaining minutes (");
        details.append(this.carrier);
        details.append(")");

        System.out.println(details.toString());

    }

    /**
     * toString returns the simple string details of the IPhone
     * @return IPhone instance variables
     */
    @Override
    public String toString() {

        final StringBuilder iphoneDetails;

        iphoneDetails = new StringBuilder();

        iphoneDetails.append(super.toString());
        iphoneDetails.append(" ");
        iphoneDetails.append(this.remainingPhonePlanMinutes);
        iphoneDetails.append(" ");
        iphoneDetails.append(this.carrier);

        return iphoneDetails.toString();
    }

    /**
     * equals check if a given IPhone has the same remaining
     * phone plan minutes as this IPhone.
     * @param o the reference object with which to compare.
     * @return if the IPhone has the same remaining phone plan minutes
     */
    @Override
    public boolean equals(final Object o) {

        // Ensure object exists
        if (o == null) {
            return false;
        }

        // Ensure object is an IPhone
        if(!(o.getClass().equals(this.getClass()))) {
            return false;
        }

        final IPhone otherIPhone;

        otherIPhone = (IPhone) o;

        return otherIPhone.getRemainingPhonePlanMinutes() == this.remainingPhonePlanMinutes;

    }

    /**
     * hashCode of IPhone
     * @return hash code of IPhone
     */
    @Override
    public int hashCode() {

        int hash;

        hash = IPHONE_HASH_CODE * IPHONE_HASH * (int) this.remainingPhonePlanMinutes;

        return hash;

    }

    public void minutesValidator(final double mins)
    {
        if(mins < NO_MINUTES_REMAINING)
        {
            throw new IllegalArgumentException("Minutes cannot be negative");
        }

    }
}
