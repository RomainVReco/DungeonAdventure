package Character;

import Item.HealthPotion;
import Item.StrengthPotion;
import Weapon.ReduceLifePower;

/**
 *
 */
public class Barbarian extends Monster {

    /**
     * Default constructor
     */
    public Barbarian() {
        s_iNbBarbarianInstances += 1;
        this.setEffectiveWeaponType("Epée");
        if (Monster.s_iNbBarbarianInstances % 2 == 1) {
            this.setPotion(new HealthPotion());
        } else {
            this.setPotion(new StrengthPotion());
        }
    }

    @Override
    public void receiveDamages(int damages) {

    }

    /**
     * A coder
     * @param targetCharacter
     */
    @Override
    public void attack(Character targetCharacter) {

    }

    /**
     * A coder
     */
    @Override
    public void search() {

    }

    /**
     * A coder
     * @param power
     */
    @Override
    public void hitByPower(ReduceLifePower power) {

    }
}