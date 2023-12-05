package Character;

import Room.Dungeon;
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
        arsenal.put("Arrow", arrow);
        arsenal.put("Fire Arrow",fireArrow);
        arsenal.put("Spear", spear);
        arsenal.put("Sword",sword);
        arsenal.put("Water Flask", waterFlask);
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

    }
    public void discoverEnnemy(Monster monster){

    }
    public void improveHealth(int value){

    }
    public void improveStrength(int value){

    }
    public void searchForPotions(Searchable searchable){

    }
    public void tryPower(Dungeon dungeon){

    }


}