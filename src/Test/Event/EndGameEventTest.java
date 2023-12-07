package Test.Event;

import Event.GameEvent;
import Event.SaveState;
import org.junit.jupiter.api.Test;
import Character.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class EndGameEventTest {

    @Test
    void gameOver() {
        GameEvent event = new GameEvent();
        event.victory();
    }

    @Test
    void saveGame(){
        Hero hero = new Hero();
        List<Monster> listeMonster = new ArrayList<>();
        listeMonster.add(new Barbarian());
        listeMonster.add(new Barbarian());
        hero.setSlayedMonsters(listeMonster);
        hero.setLifePoints(10);
        hero.setStrength(5);

        SaveState save = new SaveState(hero);
        assertEquals(3055, save.getTotalScore());
        assertEquals(hero.getSlayedMonsters().size(), save.getNumberOfSlayedMonsters());
        assertEquals(hero.getNbLifePoints(), save.getHealthRemaining());
        assertEquals(hero.getStrength(), save.getCurrentStrength());
        assertEquals("Nameless Hero", save.getHeroName());
    }

    @Test
    void saveGameToJSON (){
        Hero hero = new Hero();
        List<Monster> listeMonster = new ArrayList<>();
        listeMonster.add(new Barbarian());
        listeMonster.add(new Barbarian());
        hero.setSlayedMonsters(listeMonster);
        hero.setLifePoints(10);
        hero.setStrength(5);

        SaveState save = new SaveState(hero);
        new GameEvent().SaveGame(save);
    }
}