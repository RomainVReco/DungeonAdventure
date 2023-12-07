package Room;
import Character.Monster;
import Character.MonsterFactory;
import Character.Hero;
import GestionUtilisateur.GestionUser;
import Item.*;
import Weapon.Weapon;

import java.util.HashMap;
import java.util.Set;

public class Room implements Searchable {
    Monster monster;
    MonsterFactory monsterFactory = new MonsterFactory();;
    private HashMap<String, Item> setOfItems = new HashMap<>();
    private boolean hasBeenSearched = false;

    GestionUser gestionUser = new GestionUser();

    public Room(int p_iIndex) {
        this.monster = this.monsterFactory.createMonster(p_iIndex);

        if (p_iIndex % 7 == 0) {
            this.setOfItems.put("Health potion", new HealthPotion());
        }
        if (p_iIndex % 4 == 0) {
            this.setOfItems.put("Strength potion", new StrengthPotion());
        }
    }

    /**
     * La méthode enterRoom va déclencher la séquence de combat cf. diagramme de séquence Room fighting management
     *
     * @param hero : le héros créé à l'initialisation du jeu
     */
    public void enterRoom(Hero hero) {
        hero.discoverEnnemy(this.monster);
        // Continuer le combat jusqu'à ce que le monstre ou le hero soit mort
        while (this.monster.isAlive() && hero.isAlive()) {
            System.out.println("The monster is attacking you !");
            this.monster.attack(hero);
            // verifier si l'hero est encore en vie avant de lui permettre de contre-attaquer
            if (hero.isAlive()) {
                String weaponChoice = gestionUser.promptString("Which weapon would you like to use to attack the monster?").toLowerCase();
                try {
                    Weapon weaponToCompare = hero.getArsenal().get(weaponChoice);
                    if (monster.isWeaponEfficient(weaponToCompare)) {
                        System.out.println("The hero is attacking the monster");
                        hero.attack(this.monster);
                    }
                    else {
                        System.out.println("The weapon selected has no effect !");
                        System.out.println("As a result of that, the Hero loses his turn,and The Monster throws another Attack");
                        System.out.println("Keep in mind that the only effective against this spawn of Hell is "+monster.getEffectiveWeaponType());
                    }
                } catch (NullPointerException e){
                    System.out.println("You donkey ! This thing is not part of the Hero arsenal !");
                    System.out.println("You can chose from this set : ");
                    for (String weaponName : hero.getArsenal().keySet()){
                        System.out.print(weaponName+" ");
                    }
                }
            } else return;
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

    /**
     * la méthode search va déclencher la recherche de potion
     * @return
     */

    @Override
    public Item search() {
        if (!this.setOfItems.isEmpty()) {
            if (!this.hasBeenSearched) {
                this.hasBeenSearched = true;
                if (this.setOfItems.size() == 1) {
                    for (Item item : this.setOfItems.values()) {
                        System.out.println("You found a " + item.toString());
                        return item;
                    }
                }
                // Demander au jouer quelle potion il veut
                else {
                    String x = "";
                    if (x.equals("Health potion")) {
                        System.out.println("You chose a potion of " + this.setOfItems.get("x").toString());
                        return this.setOfItems.get("x");
                    } else {
                        System.out.println("You chose a potion of " + this.setOfItems.get("x").toString());
                        return this.setOfItems.get("Strength potion");
                    }
                }
            } else System.out.println("This room has already been searched");
        } else System.out.println("This room has no potion");
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