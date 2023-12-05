package Character;

import Item.Item;
import Item.StrengthPotion;
import Weapon.Monster.Bite;
import Weapon.ReduceLifePower;

/**
 *
 */
public class Zombie extends Monster {

    /**
     * Default constructor
     */
    public Zombie() {
        s_iNbZombieInstances += 1;
        this.setEffectiveWeaponType("FireArrow");
        this.setWeapon(new Bite());
        if (s_iNbZombieInstances % 5 == 0) {
            this.setPotion(new StrengthPotion());
        }
    }

    @Override
    public void hitByPower(ReduceLifePower power) {

    }
}