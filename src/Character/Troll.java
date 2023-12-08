package Character;

import Item.StrengthPotion;
import Weapon.Monster.Club;
import Weapon.ReduceLifePower;

/**
 * La classe Troll represente un type de monstre dans le jeu, un Troll.
 * Cette classe qui est une extension de la classe Monster definit des attributs et des comportements
 * spécifique au Troll.
 * Nous y retrouvons son nom, son arme, sa vulnerabilite a un type d'arme specifique et la
 * possibilité qu'il possede une "StrengthPotion" selon le nombre d'instances.
 */
public class Troll extends Monster {

    /**
     * Constructeur par defaut qui cree une instance de Troll
     *
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
     *
     * @param power
     */
    @Override
    public void hitByPower(ReduceLifePower power) {
        power.dischargeOnTarget(this);
    }

}