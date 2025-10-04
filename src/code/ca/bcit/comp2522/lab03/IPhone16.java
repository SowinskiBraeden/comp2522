package ca.bcit.comp2522.lab03;

/**
 * IPhone16 extends the IPhone and has additional
 * features.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class IPhone16 extends IPhone
{

    private static final int IPHONE_HASH_WITH_HIGH_RES     = 103;

    final boolean highResolutionCamera;
    final int     memoryGB;

    /**
     * IPhone16 constructor
     * @param remainingPhonePlanMinutes of this IPhone
     * @param carrier that the phone plan is registered to
     * @param highResolutionCamera status of this IPhone
     * @param memoryGB of this IPhone
     */
    public IPhone16(
        final double  remainingPhonePlanMinutes,
        final         String carrier,
        final boolean highResolutionCamera,
        final int     memoryGB
    ) {
        super(remainingPhonePlanMinutes, carrier);

        this.highResolutionCamera = highResolutionCamera;

        this.memoryGB = memoryGB;
    }

    /**
     * getHghResolutionCamera status of this IPhone
     * @return if this IPhone has a high resolution camera
     */
    public boolean getHighResolutionCamera() {
        return this.highResolutionCamera;
    }

    /**
     * toString returns the simple string details of the IPhone16
     * @return IPhone16 instance variables
     */
    @Override
    public String toString()
    {

        final StringBuilder builder;

        builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(" high-res camera: ");
        builder.append(this.highResolutionCamera);
        builder.append(" memory GB: ");
        builder.append(this.memoryGB);

        return builder.toString();

    }

    /**
     * equals check if a given IPhone16 has the same remaining
     * phone plan minutes as this IPhone16 and both have high
     * resolution cameras.
     * @param o the reference object with which to compare.
     * @return if the IPhone has the same remaining phone plan minutes and high resolution camera
     */
    @Override
    public boolean equals(final Object o)
    {

        // Ensure object exists
        if (o == null) {
            return false;
        }

        // Ensure object is an IPhone
        if(!(o.getClass().equals(this.getClass()))) {
            return false;
        }

        final IPhone16 otherIPhone;

        otherIPhone = (IPhone16) o;

        final boolean matchingMinutes;
        final boolean matchingCameraResolution;

        matchingMinutes          = otherIPhone.getRemainingPhonePlanMinutes() == this.getRemainingPhonePlanMinutes();
        matchingCameraResolution = this.highResolutionCamera && otherIPhone.getHighResolutionCamera();

        return matchingMinutes && matchingCameraResolution;

    }

    /**
     * hashCode of IPhone16
     * @return hash code of IPhone16
     */
    @Override
    public int hashCode()
    {

        int hash;

        hash = super.hashCode();

        if (this.highResolutionCamera) {
            hash *= IPHONE_HASH_WITH_HIGH_RES;
        }

        return hash;

    }
}
