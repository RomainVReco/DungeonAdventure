package Weapon.Monster;
import Character.Character;
import Weapon.Weapon;

public class MonsterWeapon extends Weapon {

    String weaponName;
  
    public MonsterWeapon() {
    }

    /*** Attributs ***/
    private int criticalCountDown;
    private int maxRoundBeforeCritical;

    /*** Getters ***/

    public int getCriticalCountDown() {
        return criticalCountDown;
    }
    public int maxRoundBeforeCritical() {
        return maxRoundBeforeCritical;
    }
    public String getWeaponName() {
        return weaponName;
    }

    /*** Setters ***/

    public void setCriticalCountDown(int criticalCountDown) {
        this.criticalCountDown = criticalCountDown;
    }
    public void setMaxRoundBeforeCritical(int maxRoundBeforeCritical) {
        this.maxRoundBeforeCritical = maxRoundBeforeCritical;
    }
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void inflictDamage(Character TargetCharacter) {
        super.inflictDamage((Character) TargetCharacter);
    }
}
