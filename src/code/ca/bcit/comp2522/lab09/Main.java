package ca.bcit.comp2522.lab09;

import java.io.IOException;

/**
 * Entry point for the Lucky Vault game.
 *
 * @author Nico Agostini
 * @author Braeden Sowinski
 * @author Trishaan Shetty
 * @author Calvin Arifianto
 * @version 1.0.0
 */
public class Main
{
    /**
     * Starts the Lucky Vault application.
     *
     * @param args command line arguments (unused).
     */
    public static void main(final String[] args)
    {
        final LuckyVault vault;

        try {
            vault = new LuckyVault();
        }
        catch (final IOException e)
        {
            System.err.printf("An error occurred during an IO operation: %s\n", e.getMessage());
            return;
        }

        vault.run();
    }
}
