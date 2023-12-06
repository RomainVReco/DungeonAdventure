package Item;
import Character.Hero;

/**
 *
 */
public abstract class Item {
    protected String itemName;

    protected int effectValue;

    public abstract void applyEffect(Hero hero);

    public void setValue(int value){
        this.effectValue = value;
    }
    public int getEffectValue() {
        return effectValue;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}