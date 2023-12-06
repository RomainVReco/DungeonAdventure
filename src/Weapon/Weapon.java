package Weapon;
import Character.Character;

/**
 *
 */
public class Weapon {
    String weaponName;
    protected int m_iAttackPoints;
    /**
     * Default constructor
     */

    public Weapon() {
        m_iAttackPoints = 10;
    }

    /**
     * @param p_TargetCharacter
     */
    public void inflictDamage(Character p_TargetCharacter) {
        p_TargetCharacter.receiveDamages(m_iAttackPoints);
    }

    public int getAttackPoints() {
        return m_iAttackPoints;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

}