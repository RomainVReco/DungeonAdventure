package Character;

import Item.HealthPotion;
import Item.Item;
import Weapon.Monster.Lightning;
import Weapon.ReduceLifePower;

/**
 *
 */
public class Sorcerer extends Monster {

    /**
     * Default constructor
     */
    public Sorcerer() {
        s_iNbSorcerInstances +=1;
        this.setMonsterName("Sorcerer");
        this.setWeapon(new Lightning());
        this.setEffectiveWeaponType("water flask");
        if (Monster.s_iNbSorcerInstances % 3 == 0) {
            this.setPotion(new HealthPotion());
        }
    }

    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }

}