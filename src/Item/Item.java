package Item;
import Character.Hero;

/**
 *
 */
public abstract class Item {

    protected int effectValue;

    public abstract void applyEffect(Hero hero);

    public void setValue(int value){
        this.effectValue = value;
    }


}