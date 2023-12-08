package Item;

import java.util.HashMap;

public class ItemFactory {

    public HashMap<String, Item> createItem(int index) {
        HashMap<String, Item> setOfItems = new HashMap<>();
        if (index % 7 == 0) {
            setOfItems.put("Health potion", new HealthPotion());
        }
        if (index % 4 == 0) {
            setOfItems.put("Strength potion", new StrengthPotion());
        }
        return setOfItems;
    }
}
