package ca.bcit.comp2522.lab02;

/**
 * Orc extends Creature and
 * holds a rage value. Orcs need anger management.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class Orc extends Creature {
    private static final int MIN_RAGE_VALUE = 0;
    private static final int MAX_RAGE_VALUE = 30;
    private static final int RAGE_INCREMENT = 5;
    private static final int DAMAGE_THRESHOLD = 20;
    private static final int DAMAGE = 15;
    private static final int DOUBLE = 2;

    private int rage;

    /*
     * validateRageValue ensures a given value is within
     * the correct rage range
     *
     * @param value to verify
     * @throws IllegalArgumentException if rage is outside valid range
     */
    private static void validateRageValue(final int value)
        throws IllegalArgumentException
    {
        if (value < MIN_RAGE_VALUE || value > MAX_RAGE_VALUE) {
            throw new IllegalArgumentException("Invalid rage value: " + value);
        }
    }

    /**
     * Orc constructor
     *
     * @param name        String
     * @param dateOfBirth Date
     * @param health      int
     * @param rage        int
     */
    Orc(
        final String name,
        final Date   dateOfBirth,
        final int    health,
        final int    rage
    ) {
        super(name, dateOfBirth, health);

        validateRageValue(rage);

        this.rage = rage;
    }

    /**
     * getDetails of orc with rage
     *
     * @return details of orc
     */
    @Override
    protected String getDetails() {
        return "Name: " + this.getName() + " Rage: " + this.rage;
    }

    /**
     * bezerk goes the orc when he is really mad.
     * dealing damage to target Creatures with the
     * potential for double damage.
     *
     * @param target Creature to deal damage to
     * @throws LowRageException if rage value is too low
     */
    protected void bezerk(final Creature target)
        throws LowRageException
    {
        this.rage += RAGE_INCREMENT;

        if (this.rage > MAX_RAGE_VALUE) {
            this.rage = MAX_RAGE_VALUE;
        }

        if (rage < RAGE_INCREMENT) {
            throw new LowRageException("Rage too low");
        } else if (this.rage > DAMAGE_THRESHOLD) {
            target.takeDamage(DAMAGE * DOUBLE);
        } else {
            target.takeDamage(DOUBLE);
        }
    }
}
