package Weapon;

/**
 *
 */
public class Weapon {
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

}