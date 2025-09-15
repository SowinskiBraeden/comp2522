package ca.bcit.comp2522.lab02;

/**
 * Dragon extends Creature and
 * holds a firePower value.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class Dragon extends Creature {
    private static final int MAX_FIRE_POWER = 100;
    private static final int MIN_FIRE_POWER = 0;

    private final int firePower;

    /*
        validateFirePower ensures input firepower is in valid
        range of MAX_FIRE_POWER and MIN_FIRE_POWER.
     */
    private static void validateFirePower(int firePower)
        throws IllegalArgumentException {

        if (firePower < MIN_FIRE_POWER || firePower > MAX_FIRE_POWER) {
            throw new IllegalArgumentException("Fire power is outside of valid range.");
        }
    }

    /**
     * Dragon constructor
     *
     * @param name        String
     * @param dateOfBirth Date
     * @param health      int
     * @param firePower   int
     */
    Dragon(
            final String name,
           final Date dateOfBirth,
           final int health,
           final int firePower
    ) {
        super(name, dateOfBirth, health);

        this.firePower = firePower;
    }

    @Override
    protected String getDetails() {
        return "a";
    }
}
