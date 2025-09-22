package ca.bcit.comp2522.lab02;

/**
 * Creature contains simple information regarding
 * a creature such as its health, name and date of birth.
 *
 * @author Braeden Sowinski, Nicolas Agostini, Trishaan Shetty
 * @version 1.0.0
 */
public class Creature {
    private static final int MIN_HEALTH = 1;
    private static final int MAX_HEALTH = 100;
    private static final int NO_HEALTH = 0;

    private final String name;
    private final Date dateOfBirth;

    private int health;

    /**
     * validateName ensures input name is not null or empty.
     *
     * @param name input
     * @throws IllegalArgumentException
     */
    private static void validateName(final String name)
        throws IllegalArgumentException
    {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    /**
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

    /**
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
    public Creature(final String name,
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
     * @throws RuntimeException if the creature is not alive
     */
    public void takeDamage(final int damage)
        throws DamageException, RuntimeException
    {
        if (!this.isAlive()){
            throw new RuntimeException("The creature is not alive.");
        }

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

    /**
     * getAgeYears calculates the age years
     * from Date.MAX_YEAR which is current year
     *
     * @return age in years
     */
    protected int getAgeYears() {
        return Date.MAX_YEAR - this.dateOfBirth.getYear();
    }

    /**
     * getDetails of the creature
     *
     * @return details of the creature.
     */
    public String getDetails() {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("Is alive: " + this.isAlive());
        builder.append("Name: " + this.name);
        builder.append("Date of birth: " + this.dateOfBirth);
        builder.append("Age: " + this.getAgeYears());
        builder.append("Health: " + this.health);



        return builder.toString();

    }

    /**
     * getName of creature
     *
     * @return name of the creature
     */
    public String getName() {
        return this.name;
    }

    /**
     * Prints the details of the creature.
     */
    public void printDetails() {
        System.out.println(getDetails());
    }
    /**
     * Prints the details of the creature.
     * @return health value of the creature
     */
    public int getHealth() { return this.health;}

    /**
     * Returns the date of birth of the creature.
     * @return Date of Birth of the creature.
     */
    public Date getDateOfBirth() { return this.dateOfBirth;}

}