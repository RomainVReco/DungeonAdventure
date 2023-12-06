package Room;
import Character.*;
import GestionUtilisateur.GestionUser;
import Item.*;
import java.util.HashMap;
import java.util.stream.Stream;

public class Room implements Searchable {
    Monster monster;
    private HashMap<String, Item> setOfItems = new HashMap<>();
    private boolean hasBeenSearched = false;

    GestionUser gestionUser = new GestionUser();

    public Room(int p_iIndex) {
        if (p_iIndex % 4 == 0 && p_iIndex % 3 == 0) {
            this.monster = new Barbarian();
        } else if (p_iIndex % 4 == 0) {
            this.monster = new Thief();
        } else if (p_iIndex % 3 == 0) {
            this.monster = new Troll();
        } else if (isPrime(p_iIndex)) {
            this.monster = new Sorcerer();
        } else {
            this.monster = new Zombie();
        }

        if (p_iIndex % 7 == 0) {
            this.setOfItems.put("Health potion", new HealthPotion());
        }
        if (p_iIndex % 4 == 0) {
            this.setOfItems.put("Strength potion", new StrengthPotion());
        }
    }

    private boolean isPrime(int p_iIndex) {
        if (p_iIndex == 2)
            return true;
        if (p_iIndex % 2 == 0 || p_iIndex < 3)
            return false;
        for (int i = 3; i <= Math.pow(p_iIndex, 0.5) + 1; i += 2) {
            if (p_iIndex % i == 0) return false;
        }
        return true;
    }

    /**
     * La méthode enterRoom va déclencher la séquence de combat cf. diagramme de séquence Room fighting management
     *
     * @param hero : le héros créer à l'initialisation du jeu
     */
    public void enterRoom(Hero hero) {
        // Notify the hero about the discovery of an enemy in the room
        hero.discoverEnnemy(this.monster);

        // Continue the battle until either the monster or the hero is defeated
        while (this.monster.isAlive() && hero.isAlive()) {
            // The monster attacks the hero
              this.monster.attack(hero);
            System.out.println(this.monster.getMonsterName() + " attacks the hero with " + this.monster.getWeapon() +
                    " and inflicts " + monsterAttackDamage + " damage.");
            System.out.println("Hero has been hit and has now " + hero.getHealth() + " life points left");

            // Check if the hero is still alive before allowing the hero to counter-attack
            if (hero.isAlive()) {
                // L'hero counter-attaque le monstre
                hero.attack(this.monster);
                System.out.println("Hero responds to the attack with its " + hero.getWeapon() +
                        " and inflicts " + heroAttackDamage + " damage.");
                System.out.println(this.monster.getMonsterName() + " has been hit and has now " + this.monster.getHealth() + " life points left");
            } else {

                return;
            }
        }

        // Apres le combat, demander au Hero s'il veut fouiller la piece
        char searchRoom = gestionUser.promptYesNo("Do you want to search the room? (Y/N)");

        if (searchRoom == 'Y' || searchRoom == 'y') {
            // L'Hero chercher des potions dans la piece
            hero.searchForPotions(this);
        }
        // Demander au Hero s'il veut fouiller le monstre qu'il a tué
        char searchMonster = gestionUser.promptYesNo("Do you want to search the defeated monster? (Y/N)");
        if (searchMonster == 'Y' || searchMonster == 'y') {
            hero.searchForPotions(this.monster);
        }

        System.out.println("La pièce a été purgée de ses éléments impurs");
    }

    @Override
    public Item search() {
        if (!this.hasBeenSearched) {
            this.hasBeenSearched = true;
            if (this.setOfItems.size() < 2) {
                for (Item item : this.setOfItems.values()) {
                    System.out.println("Vous avez trouvé une potion de " + item.toString());
                    return item;
                }
            }
            // Demander au jouer quelle potion il veut
            else {
                String x = "";
                if (x.equals("Health potion")) {
                    System.out.println("Vous avez choisi une potion de " + this.setOfItems.get("x").toString());
                    return this.setOfItems.get("x");
                } else {
                    System.out.println("Vous avez choisi une potion de " + this.setOfItems.get("x").toString());
                    return this.setOfItems.get("Strength potion");
                }
            }
        } else System.out.println("La pièce a déjà été fouillée");
        return null;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public HashMap<String, Item> getSetOfItems() {
        return setOfItems;
    }

    public void setSetOfItems(HashMap<String, Item> setOfItems) {
        this.setOfItems = setOfItems;
    }

}