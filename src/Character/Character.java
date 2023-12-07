package Character;
import Weapon.Weapon;


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