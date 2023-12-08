package Item;

public class HealthPotionFactory implements ItemFactory{

    @Override
    public Item createItem() {
        return new HealthPotion();
    }
}
