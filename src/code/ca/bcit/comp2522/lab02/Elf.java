package ca.bcit.comp2522.lab02;

/**
 * Elf extends Creature and
 * holds a mana value? Never heard of that
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class Elf extends Creature {
    private static final int MIN_MANA_VALUE = 0;
    private static final int MAX_MANA_VALUE = 50;
    private static final int MANA_DAMAGE = 10;
    private static final int MANA_USAGE = 5;

    private int mana;

    /*
     * validateManaValue ensures a given value is within
     * the correct mana range
     *
     * @param value to verify
     * @throws IllegalArgumentException if mana is outside valid range
     */
    private static void validateManaValue(final int value)
        throws IllegalArgumentException
    {
        if (value < MIN_MANA_VALUE || value > MAX_MANA_VALUE) {
            throw new IllegalArgumentException("Invalid mana value: " + value);
        }
    }

    /**
     * Elf constructor
     *
     * @param name        String
     * @param dateOfBirth Date
     * @param health      int
     * @param mana        int
     */
    Elf(
        final String name,
        final Date   dateOfBirth,
        final int    health,
        final int    mana
    ) {
        super(name, dateOfBirth, health);

        validateManaValue(mana);

        this.mana = mana;
    }

    /**
     * getDetails of elf with Mana
     *
     * @return details of elf
     */
    @Override
    protected String getDetails() {
        return "Name: " + this.getName() + " Mana: " + this.mana;
    }

    /**
     * castSpell onto target Creatures to deal damage
     * and reduces current mana value
     *
     * @param target Creature to deal damage to
     * @throws LowManaException if mana value is too low
     */
    protected void castSpell(final Creature target)
        throws LowManaException
    {
        if (this.mana < MANA_USAGE) {
            throw new LowManaException("Not enough mana to cast spell");
        }

        this.mana -= MANA_USAGE;

        target.takeDamage(MANA_DAMAGE);
    }

    /**
     * restoreMana by a given value and is maxed
     * to MAX_MANA_VALUE
     *
     * @param amount to increase mana
     */
    protected void restoreMana(final int amount) {
        this.mana += amount;

        if (this.mana > MAX_MANA_VALUE) {
            this.mana = MAX_MANA_VALUE;
        }
    }
}
