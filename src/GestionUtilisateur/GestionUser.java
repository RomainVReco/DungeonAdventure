package GestionUtilisateur;

import java.util.Scanner;

public class GestionUser {
    private Scanner scanner;

    public GestionUser() {
        this.scanner = new Scanner(System.in);
    }

    public String promptString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public char promptChar(String prompt) {
        char userInput = '\0';
        boolean validInput = false;

        do {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine();

            if (input.length() == 1) {
                userInput = input.charAt(0);
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a single character.");
            }
        } while (!validInput);

        return userInput;
    }

    public char promptYesNo(String prompt) {
        char userInput = '\0';
        boolean validInput = false;

        do {
            System.out.print(prompt + " (Y/N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1 && (input.equals("Y") || input.equals("N"))) {
                userInput = input.charAt(0);
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!validInput);

        return userInput;
    }

    public void closeScanner() {
        scanner.close();
    }
}
