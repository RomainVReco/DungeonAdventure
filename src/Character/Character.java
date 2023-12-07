package Character;
import Weapon.Weapon;



/**
 * La classe abstraite Charactere représente les personnages dans le contexte du jeu.
 * Cette classe sert de base pour differents types de personnages avec des points de vie, une
 * capacite d'attaquer et de recevoir des dégats.
 * Elle peut créer des personnages specifiques avec des comportements supplementaires.
 *
 * @author Walid, Romain, Godwill
 */

public abstract class Character {
    protected int lifePoints;
    protected Weapon weapon;

    /**
     * Default constructor
     */
    public Character() {
    }

    public void attack(Character targetCharacter){
        this.getWeapon().inflictDamage(targetCharacter);
    }

    public int getNbLifePoints(){
        return lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * Diminue les points de vie du personnage, du nombre de points passer en paramètre
     * @param damages : nombre entier représentant le nombre de dégâts que le personnage va subir
     */
    public void receiveDamages(int damages){
        this.lifePoints -= damages;
        System.out.println(damages+" damage received. Remaining HP : "+this.getNbLifePoints());
    }

    public boolean isAlive() {
        return (this.getNbLifePoints() > 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}