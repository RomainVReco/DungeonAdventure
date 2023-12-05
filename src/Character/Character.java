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
        this.getWeapon().inflictDamage(targetCharacter);
    }

    public int getNbLifePoints(){

        return lifePoints;
    }

    public void receiveDamages(int damages){
        this.lifePoints -= damages;
        System.out.println(damages+" dégats infligés. Points de vie restants : "+this.getNbLifePoints());
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