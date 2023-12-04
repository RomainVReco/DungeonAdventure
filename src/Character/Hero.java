package Character;

import Weapon.Hero.HeroWeapons;
import Weapon.ReduceLifePower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class Hero extends Character {
    private int strength;
    private ReduceLifePower power;
    private HashMap<String, HeroWeapons> arsenal = new HashMap<>();





    /**
     * A coder
     * @param targetCharacter
     */
    @Override
    public void attack(Character targetCharacter) {

    }

    /**
     * A coder
     * @param damages
     */
    @Override
    public void receiveDamages(int damages) {

    }
}