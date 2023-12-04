package Character;

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
        this.setEffectiveWeaponType("Lance");
        this.setWeapon(new Club());
        // a checker si %4 == 0 est plus adapté que 3 car on parle de 1 sur 4 à partir de 3...
        if (Monster.s_iNbTrollInstances % 4 == 0) {
            this.setPotion(new StrengthPotion());
        }
    }

    /**
     * A coder
     * @param damages
     */
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
     * @param power
     */
    @Override
    public void hitByPower(ReduceLifePower power) {

    }

    /**
     * A coder
     */
    @Override
    public void search() {

    }
}