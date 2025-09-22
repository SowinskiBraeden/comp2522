package ca.bcit.comp2522.project;

import java.util.Scanner;

/**
 * Main program entry to access a games menu
 *
 * @author Braeden Sowinski
 * @version 1.0.0
 */
public class Main {
    public static void main(final String[] args) {
        final Scanner scanner;

        scanner = new Scanner(System.in);

        boolean run = true;

        do {
            final String input;

            System.out.println("Select a game: ");
            System.out.println("Word Game (W)");
            System.out.println("Number Game (N)");
            System.out.println("My Game (M)");
            System.out.println("Quit (Q)");
            System.out.print("> ");

            input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "W":
                    System.out.println("Word game...");
                    break;
                case "N":
                    System.out.println("Number game...");
                    break;
                case "M":
                    System.out.println("My game...");
                    break;
                case "Q":
                    System.out.println("Quitting...");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid input: " + input);
                    break;
            }

        } while (run);

        scanner.close();
    }
}
