package ca.bcit.comp2522.lab03;

/**
 * Main class to test IDevice classes, and abstract concepts.
 *
 * @author Braeden Sowinski
 * @author Nicolas Agostini
 * @author Trishaan Shetty
 * @version 1.0.0
 */
public class Main {

    /**
     * main program entry
     * @param args from user input
     */
    public static void main(final String[] args) {
        // Create IPod objects
        final IPod ipod1;
        final IPod ipod2;
        final IPod ipod3;

        ipod1 = new IPod(300, 80.0); // 300 songs, max volume 80.0 dB
        ipod2 = new IPod(400, 85.0); // 400 songs, max volume 85.0 dB
        ipod3 = new IPod(300, 70.0); // 300 songs, max volume 70.0 dB

        // Test equality and inequality for IPod
        System.out.println("IPod Equality Test:");
        if (!ipod1.equals(ipod2)) {
            System.out.println("CORRECT: ipod1 is not equal to ipod2");
        } else {
            System.out.println("INCORRECT: ipod1 should not be equal to ipod2");
        }

        if (ipod1.equals(ipod3)) {
            System.out.println("CORRECT: ipod1 is equal to ipod3");
        } else {
            System.out.println("INCORRECT: ipod1 should be equal to ipod3");
        }

        System.out.println();

        // Create IPad objects
        final IPad ipad1;
        final IPad ipad2;
        final IPad ipad3;

        ipad1 = new IPad(true, "iPadOS 15"); // Has case, OS version iPadOS 15
        ipad2 = new IPad(false, "iPadOS 14"); // No case, OS version iPadOS 14
        ipad3 = new IPad(true, "iPadOS 15"); // Has case, OS version iPadOS 15

        // Test equality and inequality for IPad
        System.out.println("IPad Equality Test:");

        if (!ipad1.equals(ipad2)) {
            System.out.println("CORRECT: ipad1 is not equal to ipad2");
        } else {
            System.out.println("INCORRECT: ipad1 should not be equal to ipad2");
        }

        if (ipad1.equals(ipad3)) {
            System.out.println("CORRECT: ipad1 is equal to ipad3");
        } else {
            System.out.println("INCORRECT: ipad1 should be equal to ipad3");
        }
        System.out.println();

        // Create IPhone objects
        final IPhone iphone1;
        final IPhone iphone2;
        final IPhone iphone3;
        iphone1 = new IPhone(120.0, "Verizon"); // 120 minutes, carrier Verizon
        iphone2 = new IPhone(180.0, "T-Mobile"); // 180 minutes, carrier T-Mobile
        iphone3 = new IPhone(120.0, "AT&T"); // 120 minutes, carrier AT&T

        // Test equality and inequality for IPhone
        System.out.println("IPhone Equality Test:");
        if (!iphone1.equals(iphone2)) {
            System.out.println("CORRECT: iphone1 is not equal to iphone2");
        } else {
            System.out.println("INCORRECT: iphone1 should not be equal to iphone2");
        }
        if (iphone1.equals(iphone3)) {
            System.out.println("CORRECT: iphone1 is equal to iphone3");
        } else {
            System.out.println("INCORRECT: iphone1 should be equal to iphone3");
        }
        System.out.println();

        // Create IPhone16 objects
        final IPhone16 iphone16_1;
        final IPhone16 iphone16_2;
        final IPhone16 iphone16_3;

        iphone16_1 = new IPhone16(100.0, "Verizon", true, 512); // 100 minutes, high-res camera, 512 GB
        iphone16_2 = new IPhone16(100.0, "Verizon", true, 256); // 100 minutes, high-res camera, 256 GB
        iphone16_3 = new IPhone16(100.0, "Verizon", false, 512); // 100 minutes, no high-res camera, 512 GB

        // Test equality and inequality for IPhone16
        System.out.println("IPhone16 Equality Test:");
        if (iphone16_1.equals(iphone16_2)) {
            System.out.println("CORRECT: iphone16_1 is equal to iphone16_2");
        } else {
            System.out.println("INCORRECT: iphone16_1 should be equal to iphone16_2");
        }
        if (!iphone16_1.equals(iphone16_3)) {
            System.out.println("CORRECT: iphone16_1 is not equal to iphone16_3");
        } else {
            System.out.println("INCORRECT: iphone16_1 should not be equal to iphone16_3");
        }
        System.out.println();
    }
}
