package Weapon.Monster;
import Character.Character;
import Weapon.Weapon;

/**
 *
 */
public class MonsterWeapon extends Weapon {

    /*** Attributs ***/
    private int criticalCountDown;
    private int maxRoundBeforeCritical = -1;
    private float bonusDamage = 1;

    public MonsterWeapon() {
    }

    /**
     * Inflige des dommages au personnage passé en paramètre à partir des dégâts de l'arme -> attackPoints.
     * Chaque appel de cette fonction fait tourner un compteur de coup critique. Une fois le maximum du
     * compteur atteint -> maxRoundBeforeCritical, un multiplicateur -> bonusDamage est appliqué.
     * La formule de caclul des dommages prévoit la gestion décimalisée des dégâts
     *
     * S'il n'est pas prévu de coup critique, maxRoundBeforeCritical = -1, alors la variable -> criticalCountDown n'est
     * pas incrémentée
     * @param targetCharacter : le personnage qui va subir les dégâts de l'arme
     */
    @Override
    public void inflictDamage(Character targetCharacter) {
        if (this.maxRoundBeforeCritical !=-1 ){
            incrementCriticalCountDown();
        }
        if (this.criticalCountDown == this.maxRoundBeforeCritical){
            float baseDamage = Integer.valueOf(this.getAttackPoints()).floatValue();
            float damageToApply = this.bonusDamage * baseDamage;
            int finalDamage = Math.round(damageToApply);
            targetCharacter.receiveDamages(finalDamage);
            this.setCriticalCountDown(0);
        }
        else targetCharacter.receiveDamages(this.getAttackPoints());
    }
    /**
     * Cette méthode priée s'occupe d'incrémenter le compteur de coup critique. Son appel dépend du paramétrage
     * de la valeur de la variable -> maxRoundBeforeCritical
     */
    private void incrementCriticalCountDown(){
        this.criticalCountDown += 1;
    }

    /*** Getters ***/

    public int getCriticalCountDown() {
        return criticalCountDown;
    }
    public int getMaxRoundBeforeCritical() {
        return maxRoundBeforeCritical;
    }
    public float getBonusDamage() {
        return bonusDamage;
    }

    /*** Setters ***/
    public void setCriticalCountDown(int criticalCountDown) {
        this.criticalCountDown = criticalCountDown;
    }
    public void setMaxRoundBeforeCritical(int maxRoundBeforeCritical) {
        this.maxRoundBeforeCritical = maxRoundBeforeCritical;
    }
    public void setBonusDamage(float bonusDamage) {
        this.bonusDamage = bonusDamage;
    }
}
