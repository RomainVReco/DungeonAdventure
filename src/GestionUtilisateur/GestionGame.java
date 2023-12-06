package GestionUtilisateur;

public class GestionGame {
    public static void main(String[] args) {
        GestionUser userInput = new GestionUser();

        String playerName = userInput.promptString("Enter your name");
        System.out.println("Welcome, " + playerName + "!");

        int playerHealth = 100;
        int monstersDefeated = 0;

        // Main game loop
        while (playerHealth > 0 && monstersDefeated < 3) {
            char enterNextRoom = userInput.promptYesNo("Do you want to enter the next room? (Y/N)");

            if (enterNextRoom == 'Y' || enterNextRoom == 'y') {
                System.out.println("You enter the next room.");

                // Simulez une rencontre avec un monstre
                boolean hasMonster = Math.random() < 0.5; // 50% de chance de rencontrer un monstre
                if (hasMonster) {
                    System.out.println("A monster appears!");

                    // Simulez une bataille
                    int monsterHealth = 50;
                    while (playerHealth > 0 && monsterHealth > 0) {
                        // Simulez attaque Joueur
                        int playerAttack = (int) (Math.random() * 20) + 1; // Random attack value
                        monsterHealth -= playerAttack;
                        System.out.println("You attack the monster for " + playerAttack + " damage.");

                        // Simulez attaque monstre
                        int monsterAttack = (int) (Math.random() * 15) + 1; // valeur aleatoire attaque monstre
                        playerHealth -= monsterAttack;
                        System.out.println("The monster attacks you for " + monsterAttack + " damage.");

                        System.out.println("Your health: " + playerHealth + " | Monster's health: " + monsterHealth);
                    }

                    if (playerHealth > 0) {
                        System.out.println("Congratulations! You defeated the monster!");
                        monstersDefeated++;
                    } else {
                        System.out.println("You were defeated by the monster. Game over.");
                        break;
                    }
                } else {
                    System.out.println("No monsters in this room. You proceed.");

                    // Interaction 2: Chercher une potion
                    char searchRoom = userInput.promptYesNo("Do you want to search the room for a potion? (Y/N)");
                    if (searchRoom == 'Y' || searchRoom == 'y') {
                        System.out.println("You search the room...");

                        // Interaction 3: Prendre une potion
                        char takePotion = userInput.promptYesNo("Do you want to take the potion? (Y/N)");
                        if (takePotion == 'Y' || takePotion == 'y') {
                            // Simulation des different type de potions
                            int potionType = (int) (Math.random() * 2) + 1; // choix aleatoire entre 1 and 2

                            switch (potionType) {
                                case 1 -> System.out.println("Congrats, you found a StrengthPotion!");
                                case 2 -> System.out.println("Congrats, you found a HealthPotion!");
                            }
                        } else {
                            System.out.println("You decide not to take the potion.");
                        }
                    } else {
                        System.out.println("You choose not to search the room.");
                    }
                }
            } else {
                System.out.println("You decide not to enter the next room. Game over.");
                break;
            }
        }

        // verifier si le joueur a gagner ou pas
        if (playerHealth > 0 && monstersDefeated == 3) {
            System.out.println("Congratulations! You defeated all monsters and won the game!");
        } else {
            System.out.println("Thanks for playing. Better luck next time!");
        }

        // Demander au joueur s'il veut rejouer
        char playAgain = userInput.promptYesNo("Do you want to play again? (Y/N)");
        if (playAgain == 'Y' || playAgain == 'y') {
            // Reset le jeu
            System.out.println("Let's play again!");
        } else {
            System.out.println("Goodbye!");
        }

        userInput.closeScanner();
    }
}
