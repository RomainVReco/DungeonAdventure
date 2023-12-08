package GestionUtilisateur;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GestionUser {

    public GestionUser() {
    }

    public String promptString(String prompt) {
        System.out.print(prompt+" : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public String promptYesNo(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean validInput = false;
        do {
            System.out.print(prompt + " (Y/N): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1 && (input.equals("Y") || input.equals("N"))) {
                userInput = input;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!validInput);

        return userInput;
    }

}
