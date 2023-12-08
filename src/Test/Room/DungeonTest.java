package Test.Room;

import Room.Dungeon;
import Room.Room;
import Character.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class DungeonTest {

    static Dungeon dungeon = new Dungeon(8, new Hero());

    @Test
    void createRoom() {
        assertEquals(dungeon.getListeRoom().size(), 8);
    }

    @Test
    void createMaxRoom(){
        Dungeon dungeonTest = new Dungeon(25, new Hero());
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
    void getAllMonstersFromDungeon() {
        Dungeon dungeonTest = new Dungeon(25, new Hero());
        assertEquals(25,dungeonTest.getListeMonstres().size());
        int nbZombie = 0;
        int nbSorcer = 0;
        int nbBarbarian = 0;
        int nbTroll = 0;
        int nbThief = 0;
        for (Monster m : dungeonTest.getListeMonstres()){
            if (m.getClass() == Zombie.class ) {
                nbZombie += 1;
            }
            else if (m.getClass() == Sorcerer.class) {
                nbSorcer += 1;
            }
            else if (m.getClass() == Troll.class) {
                nbTroll += 1;
            }
            else if (m.getClass() == Thief.class) {
                nbThief +=1;
            }
            else nbBarbarian +=1;
        }
        assertEquals(2, nbBarbarian);
        assertEquals(8, nbSorcer);
        assertEquals(6, nbTroll);
        assertEquals(4, nbThief);
        assertEquals(5, nbZombie);
    }
    /**
     * Methode permettant de simuler la saisie utilisateur
     * @param data : la chaine de caractère à tester
     */
    public void provideInputString(String data){
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}