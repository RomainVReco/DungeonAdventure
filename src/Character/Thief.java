package Character;

import Item.HealthPotion;
import Weapon.Monster.Dagger;
import Weapon.Monster.Opinel;
import Weapon.ReduceLifePower;

/**
 *La classe Thief represente un type specifique de monstre dans le jeu,
 *un voleur. Cette classe definit les attributs et le comportement propre au voleur.
 * Son nom, son arme, et sa vulnérabilité à un type d'arme.
 * En fonction du nombre d'instances de Thief creees, on peut retrouver une
 * healthPotion sur lui
 */
public class Thief extends Monster {


    public Thief() {
        s_iNbThiefInstances += 1;
        this.setMonsterName("Thief");
        this.setWeapon(new Dagger());
        this.setEffectiveWeaponType("arrow"); //this.effectiveWeaponType = "Arrow";
        if (Monster.s_iNbThiefInstances % 6 == 1) {
            this.setPotion(new HealthPotion());
            this.setWeapon(new Opinel());
        }
    }

    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }
}