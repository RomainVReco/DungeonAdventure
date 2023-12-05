package Test;

import Room.Room;
import org.junit.jupiter.api.Test;
import Character.*;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void createRoom(){
        Room roomTest = new Room(1);
        assertNotNull(roomTest);
//        assertEquals(roomTest.getMonster().getClass(),Zombie.class);
    }

    @Test
    void getMonster() {
    }

    @Test
    void setMonster() {
    }

    @Test
    void getSetOfItems() {
    }

    @Test
    void setSetOfItems() {
    }

    @Test
    void enterRoom() {
    }
}