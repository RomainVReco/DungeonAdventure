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

    protected static int s_iNbZombieInstances = 0;
    protected static int s_iNbThiefInstances = 0;
    protected static int s_iNbSorcerInstances = 0;
    protected static int s_iNbBarbarianInstances = 0;
    protected static int s_iNbTrollInstances = 0;


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


    /**
     * A coder
     * @param weapon
     * @return
     */
    public boolean isWeaponEfficient(Weapon weapon){
        return false;
    }

    /**
     * A coder
     * @param power
     */
    public abstract void hitByPower(ReduceLifePower power);

    @Override
    public Item search(){
        this.setSearchDone(true);
        return this.getPotion();
    }
}