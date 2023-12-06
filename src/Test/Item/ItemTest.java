package Test.Item;

import Item.HealthPotion;
import Item.StrengthPotion;
import Character.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void createHealthPotion() {
        HealthPotion hp = new HealthPotion();
        assertNotNull(hp);
        assertSame(HealthPotion.class, hp.getClass());
    }
    @Test
    void createStrengthPotion() {
        StrengthPotion sp = new StrengthPotion();
        assertNotNull(sp);
        assertSame(StrengthPotion.class, sp.getClass());
    }
    @Test
    void healthPotionValue(){
        HealthPotion hp = new HealthPotion();
        assertEquals(10, hp.getEffectValue());
    }
    @Test
    void strengthPotion(){
        StrengthPotion sp = new StrengthPotion();
        assertEquals(20, sp.getEffectValue());
    }
    @Test
    void applyEffectHealthPotion(){
        Hero hero = new Hero();
        int baseLifePoints = hero.getNbLifePoints();
        HealthPotion hp = new HealthPotion();
        hp.applyEffect(hero);
        int expectedLifePoints = baseLifePoints + hp.getEffectValue();
        assertEquals(expectedLifePoints, hero.getNbLifePoints());
    }
    @Test
    void applyEffectStrengthPotion(){
        Hero hero = new Hero();
        int baseStrength = hero.getStrength();
        StrengthPotion sp = new StrengthPotion();
        sp.applyEffect(hero);
        int expectedStrength = baseStrength + sp.getEffectValue();
        assertEquals(expectedStrength, hero.getStrength());
    }


}