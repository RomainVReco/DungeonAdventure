package Character;


import Item.Item;
import Room.Dungeon;
import Room.Room;
import Room.Searchable;
import Weapon.Hero.*;
import Weapon.ReduceLifePower;

import java.util.HashMap;

/**
 *
 */
public class Hero extends Character {

    /******* ATTRIBUTS******/
    private int strength;
    private ReduceLifePower power;
    private HashMap<String, HeroWeapons> arsenal = new HashMap<>();

    /****** CONSTRUCTEURS ******/

    public Hero(){
        Arrow arrow = new Arrow();
        WaterFlask waterFlask = new WaterFlask();
        Sword sword = new Sword();
        Spear spear = new Spear();
        FireArrow fireArrow = new FireArrow();

        this.arsenal.put("Arrow", arrow);
        this.arsenal.put("Fire Arrow",fireArrow);
        this.arsenal.put("Spear", spear);
        this.arsenal.put("Sword",sword);
        this.arsenal.put("Water Flask", waterFlask);

    }

    /******* GETTERS ******/
    public int getStrength() {return strength;}
    public ReduceLifePower getPower() {return power;}
    public HashMap<String, HeroWeapons> getArsenal() {return arsenal;}

    /******* SETTERS ******/
    public void setStrength(int strength) {this.strength = strength;}
    public void setPower(ReduceLifePower power) {this.power = power;}
    public void setArsenal(HashMap<String, HeroWeapons> arsenal) {this.arsenal = arsenal;}

    /******* METHODES ******/
    private void selectWeaponFromArsenal(String weaponClassName){
        this.setWeapon(this.getArsenal().get(weaponClassName));

    }
    public void discoverEnnemy(Monster monster){
        String weaponClassName = monster.getEffectiveWeaponType();
        this.selectWeaponFromArsenal(weaponClassName);

    }
    public void improveHealth(int value){
        this.lifePoints += value;

    }
    public void improveStrength(int value){
        this.strength += value;

    }
    // Attention à prévoir un retour null, dans le cas où le Searchable a déjà été fouillé
    public void searchForPotions (Searchable searchable){
            Item foundItem = searchable.search();
            if ( foundItem != null) {
                foundItem.applyEffect(this);
            }
        }

    /**
     * Fonction inutile pour le moment
     * @param dungeon
     */
    public void tryPower(Dungeon dungeon){

    }


}