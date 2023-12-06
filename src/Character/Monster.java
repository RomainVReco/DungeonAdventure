package Character;

import Room.Searchable;
import Weapon.Weapon;
import Weapon.ReduceLifePower;
import Item.Item;

/**
 *
 */
public abstract class Monster extends Character implements Searchable {
    public String effectiveWeaponType;
    private boolean searchDone = false;
    protected Item potion;
    private String monsterName;

    protected static int s_iNbZombieInstances = 0;
    protected static int s_iNbThiefInstances = 0;
    protected static int s_iNbSorcerInstances = 0;
    protected static int s_iNbBarbarianInstances = 0;
    protected static int s_iNbTrollInstances = 0;


    @Override
    public Item search(){
        if (!searchDone) {
            this.setSearchDone(true);
            return this.getPotion();
        } else {
            System.out.println("The monster's corpse has already been searched");
            return null;
        }
    }

    @Override
    public void receiveDamages(int damages){
        this.lifePoints -= damages;
        System.out.println(damages+" damage received. The "+this.getMonsterName()+" has "+this.getNbLifePoints()+" HP remaining.");
    }

    /**
     * A partir de l'arme sélectionnée par le héro, vérifie si elle peut infliger des dégats au monstre visé
     * @param weapon : arme sléectionnée par le héro
     * @return true si l'arme est efficace contre ce monste, false dans le cas contraire
     */
    public boolean isWeaponEfficient(Weapon weapon){
        return weapon.getWeaponName().equals(this.effectiveWeaponType);
    }

    public String getEffectiveWeaponType() {
        return effectiveWeaponType;
    }

    public boolean isSearchDone() {
        return searchDone;
    }

    public void setSearchDone(boolean searchDone) {
        this.searchDone = searchDone;
    }

    public void setEffectiveWeaponType(String effectiveWeaponType) {
        this.effectiveWeaponType = effectiveWeaponType;
    }

    public Item getPotion() {
        return potion;
    }

    public void setPotion(Item potion) {
        this.potion = potion;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    /**
     * A coder
     * @param power
     */
    public abstract void hitByPower(ReduceLifePower power);

}