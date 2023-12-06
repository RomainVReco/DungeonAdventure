package Weapon.Hero;

import Weapon.Weapon;

public class HeroWeapons extends Weapon {
    String weaponName;
    private int attackBonus;

    /******CONSTRUCTEUR******/
    public HeroWeapons(){
    }


    /*****GETTERS******/
    public int getAttackBonus() {return attackBonus;}
    public String getWeaponName() {
        return weaponName;
    }

    /*****SETTERS******/
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;}
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    /******METHODES******/





}
