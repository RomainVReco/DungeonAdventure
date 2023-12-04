package Character;

/**
 *
 */
public class Barbarian extends Monster {

    /**
     * Default constructor
     */
    public Barbarian() {
        if (Monster.s_iNbBarbarianInstances % 2 == 0) {
            //create a health potion
        } else {
            //create a Item.StrengthPotion
        }
    }

    @Override
    public void search() {

    }
}