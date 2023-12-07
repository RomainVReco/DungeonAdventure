package Character;

import Item.HealthPotion;
import Item.Item;
import Weapon.Monster.Dagger;
import Weapon.ReduceLifePower;

/**
 *
 */
public class Thief extends Monster {


    public Thief() {
        s_iNbThiefInstances += 1;
        this.setMonsterName("Thief");
        this.setWeapon(new Dagger());
        this.setEffectiveWeaponType("arrow"); //this.effectiveWeaponType = "Arrow";
        if (Monster.s_iNbThiefInstances % 6 == 1) {
            this.setPotion(new HealthPotion());
        }
    }

    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }
}