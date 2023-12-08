package Character;

import Item.HealthPotion;
import Item.StrengthPotion;
import Weapon.Monster.Axe;
import Weapon.ReduceLifePower;

/**
 * La classe barbarian represente un type specifique de monstre, le barbare.
 * Elle est une extension de la classe Monstre qui definit ses caracteristique et des comportements.
 * On y retrouve sont nom , son arme, ainsi que sa vulerabilite a un type d'arme.
 * les instances de Barbare alternent entre la detenttion d'une HealthPotion et
 * d'une StrenghtPotion
 *
 */
public class Barbarian extends Monster {

    /**
     * Default constructor
     */
    public Barbarian() {
        s_iNbBarbarianInstances += 1;
        this.setMonsterName("Barbarian");
        this.setEffectiveWeaponType("sword");
        this.setWeapon(new Axe());
        if (Monster.s_iNbBarbarianInstances % 2 == 1) {
            this.setPotion(new HealthPotion());
        } else {
            this.setPotion(new StrengthPotion());
        }
    }

    /**
     *
     * @param power
     */
    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }
}