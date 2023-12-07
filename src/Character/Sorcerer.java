package Character;

import Item.HealthPotion;
import Weapon.Monster.Lightning;
import Weapon.ReduceLifePower;

/**
 *La classe Sorcerer, représente un type de monstre sorcier dans le jeu. Cette classe
 * est une extension de la classe monstre et definit les caractèristiques spécifiques du sorcerer.
 * Nous y retrouvons son nom, son arme, ainsi que sa vulnérabilité à un type d'arme spécifique à savoir
 * le "water flask".
 * Les Sorcerer disposent d'une HealthPotion.
 *
 * @author Walid, Romain, Godwill
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