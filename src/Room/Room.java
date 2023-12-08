package Room;
import Character.Monster;
import Character.MonsterFactory;
import Character.Hero;
import GestionUtilisateur.GestionUser;
import Item.*;
import Weapon.Weapon;
import java.util.HashMap;


/**
 * Classe représentant une Room qui à sa création et à partir d'un entier va générer un monstre que le joueur affrontera
 * Si certaintes conditions sont remplies, une potion ou plusieurs potions peuvent être stockées dans la Room.
 */
public class Room implements Searchable {
    Monster monster;
    MonsterFactory monsterFactory = new MonsterFactory();
    ItemFactory itemFactory = new ItemFactory();
    private HashMap<String, Item> setOfItems = new HashMap<>();
    private boolean hasBeenSearched = false;
    GestionUser gestionUser = new GestionUser();

    public Room(int p_iIndex) {
        this.monster = this.monsterFactory.createMonster(p_iIndex);
        this.setOfItems = this.itemFactory.createItem(p_iIndex);
    }

    /**
     * La méthode enterRoom va déclencher la séquence de combat cf. diagramme de séquence Room fighting management
     *
     * @param hero : le héros créé à l'initialisation du jeu
     */
    public void enterRoom(Hero hero) {
        hero.discoverEnnemy(this.monster);
        System.out.println("Oh ! A wild "+monster.getMonsterName()+" appears !");
        System.out.println("This abomination is sensitive to "+monster.getEffectiveWeaponType());

        while (this.monster.isAlive() && hero.isAlive()) {
            System.out.println("The monster is attacking !");
            this.monster.attack(hero);

            if (hero.isAlive()) {
                String weaponChoice = gestionUser.promptString("Which weapon would you like to use to attack the monster?").toLowerCase();
                    Weapon weaponToCompare = hero.getArsenal().get(weaponChoice);
                    if (weaponToCompare == null) {
                        System.out.println("You donkey ! This thing is not part of the Hero arsenal !");
                        System.out.println("You can chose from this set : ");
                        for (String weaponName : hero.getArsenal().keySet()){
                            System.out.print(weaponName+" ");
                        }
                    } else if (monster.isWeaponEfficient(weaponToCompare)) {
                        System.out.println("The hero is attacking the monster");
                        hero.attack(this.monster);
                    }
                    else {
                        System.out.println("The weapon selected has no effect !");
                        System.out.println("As a result, the Hero loses his turn,and The Monster throws another Attack");
                        System.out.println("Keep in mind that the only effective against this spawn of Hell is "+monster.getEffectiveWeaponType());
                    }
                } else return;
            }
        hero.getSlayedMonsters().add(this.monster);
        System.out.println("The room has been purged from the unholy creature");
        String searchRoom = gestionUser.promptYesNo("Do you want to search the room ?");

        if (searchRoom.equals("Y")) {
            hero.searchForPotions(this);
        }

        String searchMonster = gestionUser.promptYesNo("Do you want to search the defeated monster ?");
        if (searchMonster.equals("Y")) {
            hero.searchForPotions(this.monster);
        }
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
                else {
                    String potionChoice = gestionUser.promptYesNo("Do you want the Health potion[Y] or the Strength potion[N] search the defeated monster ?");
                    if (potionChoice.equals("Y")) {
                        System.out.println("You chose a potion of " + this.setOfItems.get("x").toString());
                        return this.setOfItems.get("Health potion");
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