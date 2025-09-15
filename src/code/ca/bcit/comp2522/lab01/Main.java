package ca.bcit.comp2522.lab01;

/**
 * Main class driver
 *
 * @author Braeden Sowinski
 * @author Nico Agostini
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public final class Main {
    // Albert Einstein data
    private static final int ALBERT_BIRTH_YEAR = 1879;
    private static final int ALBERT_BIRTH_MONTH = 3;
    private static final int ALBERT_BIRTH_DAY = 14;
    private static final int ALBERT_DEATH_YEAR = 1955;
    private static final int ALBERT_DEATH_MONTH = 4;
    private static final int ALBERT_DEATH_DAY = 18;
    private static final int ALBERT_SIGNUP_YEAR = 1900;
    private static final int ALBERT_SIGNUP_MONTH = 1;
    private static final int ALBERT_SIGNUP_DAY = 1;
    private static final int ALBERT_CLOSE_YEAR = 1950;
    private static final int ALBERT_CLOSE_MONTH = 10;
    private static final int ALBERT_CLOSE_DAY = 14;
    private static final int ALBERT_STARTING_BALANCE_USD = 1000;
    private static final int ALBERT_WITHDRAW_USD = 100;
    private static final int ALBERT_PIN = 3141;

    // Nelson Mandella data
    private static final int NELSON_BIRTH_YEAR = 1918;
    private static final int NELSON_BIRTH_MONTH = 7;
    private static final int NELSON_BIRTH_DAY = 18;
    private static final int NELSON_DEATH_YEAR = 2013;
    private static final int NELSON_DEATH_MONTH = 12;
    private static final int NELSON_DEATH_DAY = 5;
    private static final int NELSON_SIGNUP_YEAR = 1994;
    private static final int NELSON_SIGNUP_MONTH = 5;
    private static final int NELSON_SIGNUP_DAY = 10;
    private static final int NELSON_STARTING_BALANCE_USD = 2000;
    private static final int NELSON_WITHDRAW_USD = 200;
    private static final int NELSON_PIN = 4664;

    // Frida data
    private static final int FRIDA_BIRTH_YEAR = 1907;
    private static final int FRIDA_BIRTH_MONTH = 7;
    private static final int FRIDA_BIRTH_DAY = 6;
    private static final int FRIDA_DEATH_YEAR = 1954;
    private static final int FRIDA_DEATH_MONTH = 7;
    private static final int FRIDA_DEATH_DAY = 13;
    private static final int FRIDA_SIGNUP_YEAR = 1940;
    private static final int FRIDA_SIGNUP_MONTH = 1;
    private static final int FRIDA_SIGNUP_DAY = 1;
    private static final int FRIDA_CLOSE_YEAR = 1954;
    private static final int FRIDA_CLOSE_MONTH = 7;
    private static final int FRIDA_CLOSE_DAY = 13;
    private static final int FRIDA_STARTING_BALANCE_USD = 500;
    private static final int FRIDA_WITHDRAW_USD = 50;
    private static final int FRIDA_PIN = 1907;

    // Jackie Chan data
    private static final int JACKIE_BIRTH_YEAR = 1954;
    private static final int JACKIE_BIRTH_MONTH = 4;
    private static final int JACKIE_BIRTH_DAY = 7;
    private static final int JACKIE_SIGNUP_YEAR = 1980;
    private static final int JACKIE_SIGNUP_MONTH = 10;
    private static final int JACKIE_SIGNUP_DAY = 1;
    private static final int JACKIE_STARTING_BALANCE = 3000;
    private static final int JACKIE_WITHDRAW_USD = 500;
    private static final int JACKIE_PIN = 1954;

    /**
     * main program entry
     * @param args String[]
     */
    public static void main(final String[] args) {

        /*
            create Albert Einsteins accounts
            and perform actions.
         */
        final Name        nameAlbert;
        final Date        birthDateAlbert;
        final Date        deathDateAlbert;
        final Date        signupDateAlbert;
        final Date        closeDateAlbert;
        final String      clientIdAlbert;
        final BankClient  clientAlbert;
        final BankAccount accountAlbert;

        clientIdAlbert   = "abc123";
        nameAlbert       = new Name("Albert", "Einstein");
        birthDateAlbert  = new Date(ALBERT_BIRTH_YEAR, ALBERT_BIRTH_MONTH, ALBERT_BIRTH_DAY);
        deathDateAlbert  = new Date(ALBERT_DEATH_YEAR, ALBERT_DEATH_MONTH, ALBERT_DEATH_DAY);
        signupDateAlbert = new Date(ALBERT_SIGNUP_YEAR, ALBERT_SIGNUP_MONTH, ALBERT_SIGNUP_DAY);
        closeDateAlbert  = new Date(ALBERT_CLOSE_YEAR, ALBERT_CLOSE_MONTH, ALBERT_CLOSE_DAY);

        clientAlbert = new BankClient(
            nameAlbert,
            birthDateAlbert,
            deathDateAlbert,
            clientIdAlbert,
            signupDateAlbert
        );

        accountAlbert = new BankAccount(
            clientAlbert,
            ALBERT_STARTING_BALANCE_USD,
            ALBERT_PIN,
            clientIdAlbert,
            signupDateAlbert,
            closeDateAlbert
        );

        System.out.println(nameAlbert.getInitials() + " " + nameAlbert.getFullName() + " " + nameAlbert.getReverseName());
        System.out.println(clientAlbert.getDetails());
        System.out.println(accountAlbert.getDetails());
        System.out.println();
        accountAlbert.withdraw(ALBERT_WITHDRAW_USD, ALBERT_PIN);


        /*
            create Nelson Mandellas accounts
            and perform actions.
         */
        final Name        nameNelson;
        final Date        birthDateNelson;
        final Date        deathDateNelson;
        final Date        signupDateNelson;
        final String      clientIdNelson;
        final BankClient  clientNelson;
        final BankAccount accountNelson;

        clientIdNelson   = "654321";
        nameNelson       = new Name("Nelson", "Mandela");
        birthDateNelson  = new Date(NELSON_BIRTH_YEAR, NELSON_BIRTH_MONTH, NELSON_BIRTH_DAY);
        deathDateNelson  = new Date(NELSON_DEATH_YEAR, NELSON_DEATH_MONTH, NELSON_DEATH_DAY);
        signupDateNelson = new Date(NELSON_SIGNUP_YEAR, NELSON_SIGNUP_MONTH, NELSON_SIGNUP_DAY);

        clientNelson = new BankClient(
            nameNelson,
            birthDateNelson,
            deathDateNelson,
            clientIdNelson,
            signupDateNelson
        );

        accountNelson = new BankAccount(
            clientNelson,
            NELSON_STARTING_BALANCE_USD,
            NELSON_PIN,
            clientIdNelson,
            signupDateNelson,
            null
        );

        System.out.println(nameNelson.getInitials() + " " + nameNelson.getFullName() + " " + nameNelson.getReverseName());
        System.out.println(clientNelson.getDetails());
        System.out.println(accountNelson.getDetails());
        System.out.println();
        accountNelson.withdraw(NELSON_WITHDRAW_USD, NELSON_PIN);


        /*
            create Frida Kahlo accounts
            and perform actions.
         */
        final Name        nameFrida;
        final Date        birthDateFrida;
        final Date        deathDateFrida;
        final Date        signupDateFrida;
        final Date        closeDateFrida;
        final String      clientIdFrida;
        final BankClient  clientFrida;
        final BankAccount accountFrida;

        clientIdFrida   = "frd1233";
        nameFrida       = new Name("Frida", "Kahlo");
        birthDateFrida  = new Date(FRIDA_BIRTH_YEAR, FRIDA_BIRTH_MONTH, FRIDA_BIRTH_DAY);
        deathDateFrida  = new Date(FRIDA_DEATH_YEAR, FRIDA_DEATH_MONTH, FRIDA_DEATH_DAY);
        signupDateFrida = new Date(FRIDA_SIGNUP_YEAR, FRIDA_SIGNUP_MONTH, FRIDA_SIGNUP_DAY);
        closeDateFrida  = new Date(FRIDA_CLOSE_YEAR, FRIDA_CLOSE_MONTH, FRIDA_CLOSE_DAY);

        clientFrida = new BankClient(
                nameFrida,
                birthDateFrida,
                deathDateFrida,
                clientIdFrida,
                signupDateFrida
        );

        accountFrida = new BankAccount(
            clientFrida,
            FRIDA_STARTING_BALANCE_USD,
            FRIDA_PIN,
            clientIdFrida,
            signupDateFrida,
            closeDateFrida
        );

        System.out.println(nameFrida.getInitials() + " " + nameFrida.getFullName() + " " + nameFrida.getReverseName());
        System.out.println(clientFrida.getDetails());
        System.out.println(accountFrida.getDetails());
        System.out.println();
        accountFrida.withdraw(FRIDA_WITHDRAW_USD, FRIDA_PIN);


        /*
            create Jackie Chan's accounts
            and perform actions.
         */
        final Name        nameJackie;
        final Date        birthDateJackie;
        final Date        signupDateJackie;
        final String      clientIdJackie;
        final BankClient  clientJackie;
        final BankAccount accountJackie;

        clientIdJackie   = "chan789";
        nameJackie       = new Name("Jackie", "Chan");
        birthDateJackie  = new Date(JACKIE_BIRTH_YEAR, JACKIE_BIRTH_MONTH, JACKIE_BIRTH_DAY);
        signupDateJackie = new Date(JACKIE_SIGNUP_YEAR, JACKIE_SIGNUP_MONTH, JACKIE_SIGNUP_DAY);

        clientJackie = new BankClient(
            nameJackie,
            birthDateJackie,
            null,
            clientIdJackie,
            signupDateJackie
        );

        accountJackie = new BankAccount(
            clientJackie,
            JACKIE_STARTING_BALANCE,
            JACKIE_PIN,
            clientIdJackie,
            signupDateJackie,
            null
        );

        System.out.println(nameJackie.getInitials() + " " + nameJackie.getFullName() + " " + nameJackie.getReverseName());
        System.out.println(clientJackie.getDetails());
        System.out.println(accountJackie.getDetails());
        accountJackie.withdraw(JACKIE_WITHDRAW_USD, JACKIE_PIN);
    }
}
