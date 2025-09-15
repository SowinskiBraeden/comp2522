package ca.bcit.comp2522.lab01;

/**
 * BankClient holds information of a client
 * such as name, dateBorn, dateDied, clientID,
 * and signup date.
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public final class BankClient {
    private static final int MIN_CLIENT_ID_LENGTH = 6;
    private static final int MAX_CLIENT_ID_LENGTH = 7;

    private final Name name;
    private final Date dateBorn;
    private final Date dateDied;
    private final String clientID;
    private final Date signupDate;

    /*
        validateObject ensures an input object is not null.
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
        validateClientID ensures the input string is not null
        and within the proper length range.
     */
    private static void validateClientID(final String clientID)
        throws IllegalArgumentException
    {

        if (
            clientID == null ||
            clientID.length() < MIN_CLIENT_ID_LENGTH ||
            clientID.length() > MAX_CLIENT_ID_LENGTH
        ) {

            throw new IllegalArgumentException("Invalid clientID: " + clientID);
        }
    }

    /**
     * BankClient constructor
     * @param name Name
     * @param dateBorn Date
     * @param dateDied Date
     * @param clientID String
     * @param signupDate Date
     */
    public BankClient(
            final Name name,
            final Date dateBorn,
            final Date dateDied,
            final String clientID,
            final Date signupDate
    ) {

        validateObject(name, "name");
        validateObject(dateBorn, "dateBorn");
        validateObject(signupDate, "signupDate");

        validateClientID(clientID);

        this.name = name;
        this.dateBorn = dateBorn;
        this.dateDied = dateDied;
        this.clientID = clientID;
        this.signupDate = signupDate;
    }

    /**
     * getFullName of client Name
     * @return full name of client
     */
    public final String getFullName() {

        return this.name.getFullName();
    }

    /**
     * getDetails of Bank Client
     * @return details including name, dates, and IDs
     */
    public final String getDetails() {

        final StringBuilder details;
        final String aliveStatus;

        if (this.dateDied == null) {
            aliveStatus = "(alive)";
        } else {
            aliveStatus = "(not alive)";
        }

        details = new StringBuilder();

        details.append(this.name.getFullName());
        details.append(" client #");
        details.append(this.clientID);
        details.append(" ");
        details.append(aliveStatus);
        details.append(" joined the bank on ");
        details.append(this.signupDate.getDayOfWeek());
        details.append(", ");
        details.append(this.signupDate.getMonth());
        details.append(" ");
        details.append(this.signupDate.getDay());
        details.append(", ");
        details.append(this.signupDate.getYear());

        return details.toString();
    }
}
