package ca.bcit.comp2522.lab01;

/**
 * BankAccount information with simple deposit and withdraw methods
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public final class BankAccount {
    private static final double DEFAULT_BALANCE = 0.0;
    private static final int DEFAULT_PIN = 1000;
    private static final int MIN_ACCOUNT_NUMBER_LENGTH = 6;
    private static final int MAX_ACCOUNT_NUMBER_LENGTH = 7;

    private final BankClient client;
    private final int        pin;
    private final String     accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;

    private double balanceUSD;


    /*
        validateObject ensures that an input object
        is not null.
     */
    private static void validateObject(
        final Object object,
        final String objectTitle
    )
        throws IllegalArgumentException
    {

        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null: " + objectTitle);
        }
    }

    /*
        validateAccountNumber ensures that the input string is not null
        and within a valid length range.
     */
    private static void validateAccountNumber(final String accountNumber)
        throws IllegalArgumentException
    {

        if (accountNumber == null ||
            accountNumber.length() < MIN_ACCOUNT_NUMBER_LENGTH ||
            accountNumber.length() > MAX_ACCOUNT_NUMBER_LENGTH)
        {
            throw new IllegalArgumentException("Invalid account number: " + accountNumber);
        }
    }

    /*
        validatePin ensures the pin is in the valid range of the DEFAULT_PIN
     */
    private static void validatePin(final int pin)
        throws IllegalArgumentException
    {

        if (pin < DEFAULT_PIN) {
            throw new IllegalArgumentException("Ping must be greater than or equal to " + DEFAULT_PIN);
        }
    }

    /**
     * BankAccount constructor
     * @param client Client object
     * @param balanceUSD double
     * @param pin int
     * @param accountNumber String
     * @param accountOpened Date
     * @param accountClosed Date
     */
    public BankAccount(
            final BankClient client,
            final double     balanceUSD,
            final int        pin,
            final String     accountNumber,
            final Date       accountOpened,
            final Date       accountClosed
    ) {

        validateObject(client, "client");
        validateObject(accountOpened, "accountOpenedDate");

        validateAccountNumber(accountNumber);
        validatePin(pin);

        this.client        = client;
        this.balanceUSD    = balanceUSD;
        this.pin           = pin;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
    }

    /**
     * BankAccount constructor with default balance
     * @param client Client
     * @param pin int
     * @param accountNumber String
     * @param accountOpened Date
     * @param accountClosed Date
     */
    public BankAccount(
            final BankClient client,
            final int        pin,
            final String     accountNumber,
            final Date       accountOpened,
            final Date       accountClosed
    ) {

        this(client, DEFAULT_BALANCE, pin, accountNumber, accountOpened, accountClosed);
    }

    /**
     * BankAccount constructor with default pin
     * @param client Client
     * @param balanceUSD int
     * @param accountNumber String accountNumber
     * @param accountOpened Date
     * @param accountClosed Date
     */
    public BankAccount(
            final BankClient client,
            final double     balanceUSD,
            final String     accountNumber,
            final Date       accountOpened,
            final Date       accountClosed
    ) {

        this(client, balanceUSD, DEFAULT_PIN, accountNumber, accountOpened, accountClosed);
    }

    /**
     * BankAccount constructor with default pin and default balance
     * @param client Client
     * @param accountNumber String
     * @param accountOpened Date
     * @param accountClosed Date
     */
    public BankAccount(
            final BankClient client,
            final String     accountNumber,
            final Date       accountOpened,
            final Date       accountClosed
    ) {

        this(client, DEFAULT_BALANCE, DEFAULT_PIN, accountNumber, accountOpened, accountClosed);
    }

    /**
     * BankAccount constructor with default balance and no account close date
     * @param client Client
     * @param pin int
     * @param accountNumber String
     * @param accountOpened Date
     */
    public BankAccount(
            final BankClient client,
            final int        pin,
            final String     accountNumber,
            final Date       accountOpened
    ) {

        this(client, DEFAULT_BALANCE, pin, accountNumber, accountOpened, null);
    }

    /**
     * BankAccount constructor with default pin and no account closed date
     * @param client Client Object
     * @param balanceUSD double
     * @param accountNumber String
     * @param accountOpened Date
     */
    public BankAccount(
            final BankClient client,
            final double     balanceUSD,
            final String     accountNumber,
            final Date       accountOpened
    ) {

        this(client, balanceUSD, DEFAULT_PIN, accountNumber, accountOpened, null);
    }

    /**
     * BankAccount constructor with default balance and default pin and no account closed date
     * @param client Client
     * @param accountNumber String
     * @param accountOpened Date
     */
    public BankAccount(
            final BankClient client,
            final String     accountNumber,
            final Date       accountOpened
    ) {

        this(client, DEFAULT_BALANCE, DEFAULT_PIN, accountNumber, accountOpened, null);
    }

    /*
     *
     * @param withdrawUSD
     * @throws IllegalArgumentException
     */
    private void validateWithdrawAmount(final double withdrawUSD)
        throws IllegalArgumentException
    {

        if (withdrawUSD > this.balanceUSD) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    /**
     * deposit to balanceUSD
     * @param amountUSD to deposit
     */
    public final void deposit(final double amountUSD) {

        this.balanceUSD += amountUSD;
    }

    /**
     * withdraw from balance
     * @param amountUSD to withdraw as a double
     */
    public final void withdraw(final double amountUSD) {

        validateWithdrawAmount(amountUSD);

        this.balanceUSD -= amountUSD;
    }

    /**
     * withdraw from balance
     * @param amountUSD to withdraw as a double
     * @param pinToMatch int
     */
    public final void withdraw(
        final double amountUSD,
        final int pinToMatch
    ) {

        if (pinToMatch != this.pin) {
            throw new IllegalArgumentException("Invalid pin ");
        }

        validateWithdrawAmount(amountUSD);

        this.balanceUSD -= amountUSD;
    }

    /**
     * getDetails of account
     * @return account details
     */
    public final String getDetails() {

        final StringBuilder details;

        details = new StringBuilder();

        details.append(this.client.getFullName());
        details.append(" had $");
        details.append(this.balanceUSD);
        details.append(" USD in account #");
        details.append(this.accountNumber);
        details.append(" which was opened on ");
        details.append(this.accountOpened.getDayOfWeek());
        details.append(" ");
        details.append(this.accountOpened.getMonth());
        details.append(" ");
        details.append(this.accountOpened.getDay());
        details.append(", ");
        details.append(this.accountOpened.getYear());

        if (this.accountClosed != null) {
            details.append(" and closed ");
            details.append(this.accountClosed.getDayOfWeek());
            details.append(" ");
            details.append(this.accountClosed.getMonth());
            details.append(" ");
            details.append(this.accountClosed.getDay());
            details.append(", ");
            details.append(this.accountClosed.getYear());
        }

        details.append(".");

        return details.toString();
    }
}
