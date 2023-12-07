package Room;
import Character.Monster;
import Character.MonsterFactory;
import Character.Hero;
import Item.*;

import java.util.HashMap;

public class Room implements Searchable {
    Monster monster;
    MonsterFactory monsterFactory = new MonsterFactory();;
    private HashMap<String, Item> setOfItems = new HashMap<>();
    private boolean hasBeenSearched = false;

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
        while (this.monster.isAlive() && hero.isAlive()) {
            this.monster.attack(hero);
            if (hero.isAlive()) {
                hero.attack(this.monster);
            } else return;
        }
        // implanter une demande pour fouiller la pièce et/ou le monstre
        hero.searchForPotions(this);
        hero.searchForPotions(this.monster);
        System.out.println("The room has been purged");
    }

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