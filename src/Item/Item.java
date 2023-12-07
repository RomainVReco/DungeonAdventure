package Item;
import Character.Hero;

/**
 *La classe abstraite Item represente le modele pour la creation de divers types d'items dans un jeu
 * qui peuvent avoir un effet sur les personnages, notamment le hero.
 * il s'agit ici des potions.
 * Cette classe definit une base avec un nom et une valeur d'effet.
 *
 * @author Walid, Romain, Godwill
 *
 *
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