package Character;

import Item.StrengthPotion;
import Weapon.Monster.Bite;
import Weapon.ReduceLifePower;

/**
 * La classe Zombie represente un modele pour le type de monstre "zombie" dans le jeu.
 * Cette classe qui est une extension de la classe monstre définit des caracteristiques specifiques au zombie
 * comme son nom, som arme, et sa vulnérabilité a un type arme (flèche enflammee).
 * Un zombie cree detient une StrenghtPotion.
 *
 */
public class Zombie extends Monster {

    /**
     * Le constructeur par default cree une instance de zombie
     */
    public Zombie() {
        s_iNbZombieInstances += 1;
        this.setMonsterName("Zombie");
        this.setEffectiveWeaponType("fire arrow");
        this.setWeapon(new Bite());
        if (s_iNbZombieInstances % 5 == 0) {
            this.setPotion(new StrengthPotion());
        }
    }

    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }
}