package Character;


import Event.ConfigDungeon;
import Item.Item;
import Room.Dungeon;
import Room.Searchable;
import Weapon.Hero.*;
import Weapon.ReduceLifePower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * La classe Hero represente le personnage héroïque du jeu.
 * Elle gère les caractéristiques comme la force du héros, ses pouvoirs,
 * et son arsenal d'armes.
 * Via cette classe le héros peut aussi intéragir avec certains éléments du jeu,
 * telles que les potions à rechercher ou encore les monstres.
 *
 * @author Equipe
 *
 */
public class Hero extends Character {

    /******* ATTRIBUTS******/
    private int strength;
    private ReduceLifePower power;
    private HashMap<String, HeroWeapons> arsenal = new HashMap<>();
    private List<Monster> slayedMonsters = new ArrayList<>();

    /****** CONSTRUCTEURS ******/

    public Hero(int strength){

        this.strength = strength;
        Arrow arrow = new Arrow();
        WaterFlask waterFlask = new WaterFlask();
        Sword sword = new Sword();
        Spear spear = new Spear();
        FireArrow fireArrow = new FireArrow();
        this.arsenal.put("arrow", arrow);
        this.arsenal.put("fire arrow",fireArrow);
        this.arsenal.put("spear", spear);
        this.arsenal.put("sword",sword);
        this.arsenal.put("water flask", waterFlask);

        /**
         * Boucle for pour parcourir toutes les valeurs dans l'HashMap
         * arsenal et appeler la methode 'calculateAttackBonus'
         * sur chacune d'elle.
         */
        for (HeroWeapons weapon : arsenal.values()){
            weapon.calculateAttackBonus(this.strength);
        }
    }

    public Hero(){
        this.strength = ConfigDungeon.getHeroStrength();
        Arrow arrow = new Arrow();
        WaterFlask waterFlask = new WaterFlask();
        Sword sword = new Sword();
        Spear spear = new Spear();
        FireArrow fireArrow = new FireArrow();
        this.arsenal.put("arrow", arrow);
        this.arsenal.put("fire arrow",fireArrow);
        this.arsenal.put("spear", spear);
        this.arsenal.put("sword",sword);
        this.arsenal.put("water flask", waterFlask);
        /**
         * Boucle for pour parcourir toutes les valeurs dans l'HashMap
         * arsenal et appeler la methode 'calculateAttackBonus'
         * sur chacune d'elle.
         */
        for (HeroWeapons weapon : arsenal.values()){
            weapon.calculateAttackBonus(this.strength);
        }
    }

    /******* GETTERS ******/
    public int getStrength() {return strength;}
    public ReduceLifePower getPower() {return power;}
    public HashMap<String, HeroWeapons> getArsenal() {return arsenal;}

    /******* SETTERS ******/
    public void setStrength(int strength) {
        this.strength = strength;
        for (HeroWeapons weapon : arsenal.values()) {
            weapon.calculateAttackBonus(this.strength);
        }
    }
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
