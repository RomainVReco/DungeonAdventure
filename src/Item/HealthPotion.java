package Item;
import Character.Hero;

/**
 *
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