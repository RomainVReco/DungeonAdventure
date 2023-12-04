package Character;
import Weapon.Weapon;

/**
 *
 */
public abstract class Character {
    protected int lifePoints;
    protected Weapon weapon;

    /**
     * Default constructor
     */
    public Character() {
    }

    public abstract void attack(Character targetCharacter);
    public int getNbLifePoints(){
        return lifePoints;
    }
    public abstract void receiveDamages(int damages);
    public boolean isAlive() {
        return (this.getNbLifePoints() > 0);
    }
}