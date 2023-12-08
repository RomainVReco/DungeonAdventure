package Weapon;
import Character.Character;

/**
 * La classe Weapon représente le modèle générique pour une arme dans le jeu.
 * Cette classe contient des informations de base sur l'arme, comme son nom, et ses points d'attaque,
 * et elle fournit une fonctionnalité pour infliger des dégats à sa cible.
 *
 * @author Equipe
 */
public abstract class Weapon {
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

