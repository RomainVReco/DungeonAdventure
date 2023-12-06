package Test.Room;

import Room.Dungeon;
import Room.Room;
import Character.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonTest {

    static final Dungeon dungeon = new Dungeon(8);

    @Test
    void createRoom() {
        assertEquals(dungeon.getListeRoom().size(), 8);
    }

    @Test
    void createMaxRoom(){
        Dungeon dungeonTest = new Dungeon(25);
        assertEquals(25,dungeonTest.getListeRoom().size());
    }
    @Test
    void listOfMonsters(){
        assertEquals(8,dungeon.getListeMonstres().size());
    }

    @Test
    void checkRoomNotEquals(){
        Room room1 = dungeon.getListeRoom().get(0);
        Room room2 = dungeon.getListeRoom().get(1);
        assertNotEquals(room1, room2);
    }

    @Test
    void checkMonsterNotEqualsInRoom(){
        Room room1 = dungeon.getListeRoom().get(0);
        Room room2 = dungeon.getListeRoom().get(1);
        assertNotEquals(room1.getMonster(), room2.getMonster());
    }

    @Test
    void checkMonsterCreationOrder(){
        Room room1 = dungeon.getListeRoom().get(0);
        Room room2 = dungeon.getListeRoom().get(1);
        assertSame(Zombie.class, room1.getMonster().getClass());
        assertSame(Sorcerer.class, room2.getMonster().getClass());
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