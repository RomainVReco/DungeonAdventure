package Item;

public class StrengthPotionFactory implements ItemFactory{
    @Override
    public Item createItem() {
        return new StrengthPotion();
    }
}
