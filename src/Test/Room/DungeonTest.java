package Test.Room;

import Room.Dungeon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonTest {

    static final Dungeon dungeon = new Dungeon(5);

    @Test
    void createRoom() {
        assertEquals(dungeon.getListeRoom().size(), 5);
    }

    @Test
    void createMaxRoom(){
        Dungeon dungeonTest = new Dungeon(25);
        assertEquals(25,dungeonTest.getListeRoom().size());
    }
    @Test
    void listOfMonsters(){
        assertEquals(5,dungeon.getListeMonstres().size());
    }

    @Test
    void greetHeroes(){

    }

    @Test
    void getRoom() {
    }

    @Test
    void ajouterRoom() {
    }

    @Test
    void greetHeros() {
    }

    @Test
    void getAllMonstersFromDungeon() {
    }
}