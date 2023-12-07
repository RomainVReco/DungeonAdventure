package Weapon.Hero;
import Character.Character;
import Weapon.Weapon;

/**
 * La classe HeroWeapons extends de la classe Weapon.
 * Elle represente les différentes armes attribuables au héros dans le jeu, et
 * ajoute un bonus d'attaque basé sur la force du héros.
 *
 *  <p>
 *  Cette méthode surcharge inflictDamage pour inclure le calcule du bonus d'attaque
 *  dans le calcul des dégats infligés au monster (le personnage cicle)
 *  </p>
 *
 * @author Equipe
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





