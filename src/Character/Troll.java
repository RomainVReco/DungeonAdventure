package Character;

import Item.Item;
import Item.StrengthPotion;
import Weapon.Monster.Club;
import Weapon.ReduceLifePower;

/**
 *
 */
public class Troll extends Monster {

    /**
     * Default constructor
     */
    public Troll() {
        s_iNbTrollInstances += 1;
        this.setMonsterName("Troll");
        this.setEffectiveWeaponType("spear");
        this.setWeapon(new Club());
        // a checker si %4 == 0 est plus adapté que 3 car on parle de 1 sur 4 à partir de 3...
        if (Monster.s_iNbTrollInstances % 4 == 0) {
            this.setPotion(new StrengthPotion());
        }
    }
    /**
     * A coder
     * @param power
     */
    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }

}