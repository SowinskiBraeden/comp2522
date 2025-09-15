package ca.bcit.comp2522.lab02;

/**
 * Creature contains simple information regarding
 * a creature such as its health and name.
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class Creature {
    private static final int MIN_HEALTH = 1;
    private static final int MAX_HEALTH = 100;
    private static final int NO_HEALTH = 0;

    private final String name;
    private final Date dateOfBirth;

    private int health;

    /*
     * validateName ensures input name is not empty.
     *
     * @param name input
     * @throws IllegalArgumentException
     */
    private static void validateName(final String name)
        throws IllegalArgumentException
    {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /*
     * validateHealth ensures input health is within valid range
     * of MAX_HEALTH and MIN_HEALTH
     *
     * @param health to verify
     * @throws IllegalArgumentException
     */
    private static void validateHealth(final int health)
        throws IllegalArgumentException
    {
        if (health < MIN_HEALTH || health > MAX_HEALTH) {
            throw new IllegalArgumentException("Health must be between 1 and 100");
        }
    }

    /*
     * validateDateOfBirth ensures the date of birth
     * is not in the future.
     *
     * @param dateOfBirth to verify
     * @throws IllegalArgumentException
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
        throws IllegalArgumentException
    {
        if (dateOfBirth.isInFuture()) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
    }

    /**
     * Creature constructor
     *
     * @param name of creature
     * @param dateOfBirth of creature
     * @param health of creature to start
     */
    Creature(final String name,
            final Date dateOfBirth,
            final int health)
    {

        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    /**
     * isAlive checks if the health of the creature is
     * greater than the MIN_HEALTH to be considered
     * alive.
     *
     * @return if creature is alive.
     */
    protected boolean isAlive() {
        return this.health >= MIN_HEALTH;
    }

    /**
     * takeDamage decreases the health value.
     * The health value cannot be negative and
     * will stay at NO_HEALTH if any more damage is taken.
     *
     * @param damage to be dealt
     * @throws DamageException if damage is negative
     */
    protected void takeDamage(final int damage)
        throws DamageException
    {
        if (damage < NO_HEALTH) {
            throw new DamageException("Damage cannot be negative");
        }

        this.health -= damage;

        if (this.health < NO_HEALTH) {
            this.health = NO_HEALTH;
        }
    }

    /**
     * heal increases the health value.
     * If adding healAmount results in health to be
     * greater than MAX_HEALTH, health is capped at
     * MAX_HEALTH.
     *
     * @param healAmount to add to current health
     * @throws HealingException if healAmount is negative
     */
    protected void heal(final int healAmount)
        throws HealingException
    {
        if (healAmount < NO_HEALTH) {
            throw new HealingException("Heal amount cannot be negative");
        }

        this.health += healAmount;

        if (this.health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        }
    }

    protected int getAgeYears() {
        return 0;
    }

    protected String getDetails() {
        return "";
    }
}
