package Character;

import Item.HealthPotion;
import Weapon.Monster.Dagger;
import Weapon.ReduceLifePower;

/**
 *
 */
public class Thief extends Monster {


    public Thief() {
        s_iNbThiefInstances += 1;
        this.setWeapon(new Dagger());
        this.setEffectiveWeaponType("Arrow"); //this.effectiveWeaponType = "Arrow";
        if (Monster.s_iNbThiefInstances % 6 == 1) {
            this.setPotion(new HealthPotion());
        }

    }

    @Override
    public void receiveDamages(int damages) {

    }

    @Override
    public void attack(Character targetCharacter) {

    }

    @Override
    public void search() {

    }

    @Override
    public void hitByPower(ReduceLifePower power) {

    }
}