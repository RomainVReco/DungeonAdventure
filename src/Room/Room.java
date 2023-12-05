package Room;
import Character.*;
import Item.*;

import java.util.HashMap;
import java.util.stream.Stream;

public class Room implements Searchable {
    Monster monster;
    private HashMap<String, Item> setOfItems = new HashMap<>();
    private boolean hasBeenSearched = false;

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
     * @param hero
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