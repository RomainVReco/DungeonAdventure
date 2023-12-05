package Character;

import Item.HealthPotion;
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
        this.setWeapon(new Lightning());
        this.setEffectiveWeaponType("WaterFlask");
        if (Monster.s_iNbSorcerInstances % 3 == 0) {
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
    public void hitByPower(ReduceLifePower power) {

    }

    @Override
    public void search() {

    }
}