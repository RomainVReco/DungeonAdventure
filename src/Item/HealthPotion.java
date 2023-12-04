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

    }

    @Override
    public void applyEffect(Hero hero) {
        System.out.println("apply effect HealthPotion");
    }
}