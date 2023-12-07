package Test.Character;

import Event.ConfigDungeon;
import Weapon.Hero.*;
import org.junit.jupiter.api.Test;
import Character.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    static final Hero heroTest = new Hero();

    @Test
    void createHero(){
        Hero hero = new Hero();
        assertSame(Hero.class, hero.getClass());
    }

    @Test
    void checkHeroListofWeapons(){
        Hero hero = new Hero();
        assertEquals(5, hero.getArsenal().size());
    }

    @Test
    void getWeaponByType(){
        Hero hero = new Hero();
        HashMap<String, HeroWeapons> listTest = hero.getArsenal();
        String arrow = "Arrow";
        String spear = "Spear";
        String fireArrow = "Fire Arrow";
        String sword = "Sword";
        String waterFlask = "Water Flask";
        assertNotNull(hero.getArsenal().get(arrow));
        assertSame(Arrow.class, hero.getArsenal().get(arrow).getClass());
        assertSame(Spear.class, hero.getArsenal().get(spear).getClass());
        assertSame(FireArrow.class, hero.getArsenal().get(fireArrow).getClass());
        assertSame(Sword.class, hero.getArsenal().get(sword).getClass());
        assertSame(WaterFlask.class, hero.getArsenal().get(waterFlask).getClass());
        assertNotSame(Arrow.class, hero.getArsenal().get(waterFlask).getClass());
    }

    @Test
    void heroStrength(){
        assertEquals(ConfigDungeon.getConfig(), heroTest.getStrength());
    }

    @Test
    void weaponAttackPoint() {
        assertEquals(10, heroTest.getArsenal().get("Arrow").getAttackPoints());
    }

    @Test
    void discoverEnnemy() {
        Barbarian barbarian = new Barbarian();
        heroTest.discoverEnnemy(barbarian);
        assertEquals(heroTest.getWeapon().getWeaponName(), barbarian.getEffectiveWeaponType());
        assertNotEquals(heroTest.getArsenal().get("arrow").getWeaponName(), barbarian.getEffectiveWeaponType());
    }

    @Test
    void inflictDamages(){
        Barbarian barbarian = new Barbarian();
        heroTest.discoverEnnemy(barbarian);
        heroTest.getWeapon().inflictDamage(barbarian);
        assertEquals(-12, barbarian.getNbLifePoints());
    }

    @Test
    void searchForPotions() {
    }

    @Test
    void tryPower() {
    }

}