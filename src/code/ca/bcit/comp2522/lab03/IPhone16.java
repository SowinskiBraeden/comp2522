package ca.bcit.comp2522.lab03;

public class IPhone16 extends IPhone {
    final boolean highResolutionCamera;
    final int memoryGB;

    IPhone16(
        final double remainingPhonePlanMinutes,
        final String carrier,
        final boolean highResolutionCamera,
        final int memoryGB
    ) {
        super(remainingPhonePlanMinutes, carrier);

        this.highResolutionCamera = highResolutionCamera;
        this.memoryGB = memoryGB;
    }
}
