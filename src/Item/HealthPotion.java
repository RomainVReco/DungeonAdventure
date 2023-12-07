package Item;
import Character.Hero;

/**
 *La classe HealthPotion est une extension de la classe Item.
 * Cette classe represente un modele pour la création d'une potion de sante dans le jeu.
 * cette potion pour augmenter les points de vie du héro.
 *
 * @author Walid, Romain, Godwill
 */
public class HealthPotion extends Item {

    /**
     * Default constructor
     */
    public HealthPotion() {
        this.setItemName("Health potion");
        this.setValue(10);
    }

    @Override
    public void applyEffect(Hero hero) {
        System.out.println("apply effect HealthPotion");
        hero.improveHealth(this.effectValue);
    }
}