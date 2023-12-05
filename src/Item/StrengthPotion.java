package Item;
import Character.Hero;
/**
 *
 */
public class StrengthPotion extends Item {

    public StrengthPotion() {
        this.setValue(20);
    }

    @Override
    public void applyEffect(Hero hero) {
        System.out.println("apply effect Strength Potion");
        hero.improveStrength(this.effectValue);
    }
}