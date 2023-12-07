package Weapon.Hero;
import Character.Character;
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
    @Override
    public void inflictDamage(Character p_TargetCharacter) {
        int totalAttackPoints = m_iAttackPoints + this.attackBonus;
        p_TargetCharacter.receiveDamages(totalAttackPoints);
    }
    public void calculateAttackBonus(int strength){
        this.attackBonus = strength * 2;
    }
}





