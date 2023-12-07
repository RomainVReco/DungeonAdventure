package Weapon.Hero;
import Character.Character;
import Weapon.Weapon;

/**
 * La classe HeroWeapons est une extension de la classe Weapon.
 * Elle represente les differentes armes attribuables au héros dans le jeu, et
 * ajoute un bonus d'attaque basé sur la force du heros.
 *
 *  <p>
 *  Cette méthode surcharge inflictDamage pour inclure le calcule du bonus d'attaque
 *  dans le calcul des degats infliges au monster (le personnage cicle)
 *  </p>
 *
 * @author Walid, Romain, Godwill
 *
 */
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

    /**
     * Cette methode met à jour le bonus d'attaque de l'arme.
     * Le bonus d'attaque est construit à partir de la force du personnage.
     * Dans son calcul, nous définissons le bonus d'attaque comme étant le double de la valeur d'attaque.
     *
     * @param strength est la force du personnage, on l'utilise pour calculer le bonus d'attaque.
     */
    public void calculateAttackBonus(int strength){
        this.attackBonus = strength * 2;
    }

}





