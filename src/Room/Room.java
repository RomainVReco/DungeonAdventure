package Room;
import Character.*;
import Item.*;

import java.util.HashSet;
import java.util.Set;

public class Room {
    Monster monster;
    private Set<Item> setOfItems = new HashSet<>();

    public Room(int p_iIndex) {
        if (p_iIndex % 4 == 0 && p_iIndex % 3 == 0) {
            this.monster = new Barbarian();
            Barbarian barbare = new Barbarian();
            barbare.isAlive();
            barbare.getNbLifePoints();
        } else if (p_iIndex % 4 == 0) {
            this.monster = new Thief();
        } else if (p_iIndex % 3 == 0) {
            this.monster = new Troll();
        } else if (isPrime(p_iIndex)) {
            this.monster = new Sorcerer();
        } else {
            this.monster = new Zombie();
        }

        if (p_iIndex % 7 == 0){
            this.setOfItems.add(new HealthPotion());
        }
        if (p_iIndex % 4 == 0){
            this.setOfItems.add(new StrengthPotion());
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

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Set<Item> getSetOfItems() {
        return setOfItems;
    }

    public void setSetOfItems(Set<Item> setOfItems) {
        this.setOfItems = setOfItems;
    }

    /**
     * La méthode enterRoom va déclencher la séquence de combat cf. diagramme de séquence Room fighting management
     * @param hero
     */
    public void enterRoom(Hero hero){


    }
}
