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
    private static final int FIRE_POWER_USAGE = 10;
    private static final int FIRE_POWER_DAMAGE = 20;

    private int firePower;

    /**
     * validateFirePower ensures a given value is within
     * the correct firePower range
     *
     * @param firePower to verify
     * @throws IllegalArgumentException if firePower is outside valid range
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
        final Date   dateOfBirth,
        final int    health,
        final int    firePower
    ) {
        super(name, dateOfBirth, health);

        this.firePower = firePower;
    }

    /**
     * getDetails of Dragon with firepower
     *
     * @return details of dragon
     */
    @Override
    protected String getDetails() {
        return "Name: " + this.getName() + " FirePower: " + this.firePower;
    }

    /**
     * breathFire onto Creatures to deal damage
     * and reduces current firePower value
     *
     * @param target Creature to deal damage to
     * @throws LowFirePowerException if not enough firePower
     */
    protected void breatheFire(final Creature target)
        throws LowFirePowerException
    {
        if (firePower > FIRE_POWER_USAGE) {
            throw new LowFirePowerException("Fire power too low");
        }

        this.firePower -= FIRE_POWER_USAGE;

        target.takeDamage(FIRE_POWER_DAMAGE);
    }

    /**
     * restoreFirePower by a given value and is
     * maxed by MAX_FIRE_POWER
     *
     * @param amount to increase firePower
     */
    protected void restoreFirePower(final int amount) {
        this.firePower += amount;

        if (this.firePower > MAX_FIRE_POWER) {
            this.firePower = MAX_FIRE_POWER;
        }
    }
}
