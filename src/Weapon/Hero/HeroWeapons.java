package Weapon.Hero;

import Weapon.Weapon;

public class HeroWeapons extends Weapon {

    private int attackBonus;

    /******CONSTRUCTEUR******/
    public HeroWeapons(){
    }


    /*****GETTERS******/
    public int getAttackBonus() {return attackBonus;}

    /*****SETTERS******/
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;}

    /******METHODES******/
public void calculateAttackBonus(int strength){
    this.attackBonus = strength * 2;
}

}





