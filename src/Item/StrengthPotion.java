package Item;
import Character.Hero;
/**
 *La classe StrengthPotion est une extension de la classe Item et represente un modele pour la
 * creation d'une potion de force dans le jeu.
 * Lorsque la potion est utilisee, elle augmente la force du hero.
 * Cette potion est conçue pour etre utilisee par des objets de type Hero et influe sur sa capacite.
 *
 * @author Walid, Romain, Godwill
 */
public class StrengthPotion extends Item {

    public StrengthPotion() {
        this.setItemName("Strength potion");
        this.setValue(20);
    }

    @Override
    public void applyEffect(Hero hero) {
        System.out.println("apply effect Strength Potion");
        hero.improveStrength(this.effectValue);
    }


}