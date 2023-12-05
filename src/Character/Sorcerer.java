package Character;

import Weapon.ReduceLifePower;

/**
 *
 */
public class Sorcerer extends Monster {

    /**
     * Default constructor
     */
    public Sorcerer() {
        if (Monster.s_iNbSorcerInstances % 3 == 0) {
            //create a health potion
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