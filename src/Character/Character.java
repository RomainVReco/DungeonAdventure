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

    public void attack(Character targetCharacter){

    };
    public int getNbLifePoints(){
        return lifePoints;
    }
    public void receiveDamages(int damages){
        this.lifePoints -= damages;
        System.out.println(damages+" dégats infligés. Points de vie restants : "+this.getNbLifePoints());
    };
    public boolean isAlive() {
        return (this.getNbLifePoints() > 0);
    }
}