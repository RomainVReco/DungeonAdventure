package Item;

import java.util.HashMap;

/**
 * Factory pour les objets de type Item. Pour le moment, il n'y a que les deuq
 */
public class ConcreteItemFactory {

    public HashMap<String, Item> createItem(int index) {
        HashMap<String, Item> setOfItems = new HashMap<>();
        if (index % 7 == 0) {
            HealthPotionFactory healthPotionFactory = new HealthPotionFactory();
            setOfItems.put("Health potion", healthPotionFactory.createItem());
        }
        if (index % 4 == 0) {
            StrengthPotionFactory strengthPotionFactory = new StrengthPotionFactory();
            setOfItems.put("Strength potion", strengthPotionFactory.createItem());
        }
        return setOfItems;
    }
}
