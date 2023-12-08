package Test.Room;

import GestionUtilisateur.GestionUser;
import Item.HealthPotion;
import Item.StrengthPotion;
import Room.Room;
import org.junit.jupiter.api.Test;
import Character.*;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void createRoom(){
        Room roomTest = new Room(1);
        assertNotNull(roomTest);
    }

    @Test
    void getSetOfItems() {
        Room roomTest1 = new Room(7);
        Room roomTest2 = new Room(4);
        Room roomTest3 = new Room(28);
        assertEquals(1, roomTest1.getSetOfItems().size());
        assertEquals(1, roomTest2.getSetOfItems().size());
        assertEquals(2, roomTest3.getSetOfItems().size());
        assertSame(StrengthPotion.class, roomTest2.getSetOfItems().get("Strength potion").getClass());
        assertSame(HealthPotion.class, roomTest1.getSetOfItems().get("Health potion").getClass());
        assertSame(StrengthPotion.class, roomTest3.getSetOfItems().get("Strength potion").getClass());
        assertSame(HealthPotion.class, roomTest3.getSetOfItems().get("Health potion").getClass());
    }

    @Test
    void roomWithZombie(){
        Room roomTest = new Room(1);
        assertSame(Zombie.class, roomTest.getMonster().getClass());
    }
    @Test
    void roomWithBarbarian() {
        Room roomTest = new Room(12);
        assertSame(Barbarian.class, roomTest.getMonster().getClass());
    }
    @Test
    void roomWithSorcerer() {
        Room roomTest = new Room(2);
        assertSame(Sorcerer.class, roomTest.getMonster().getClass());
    }
    @Test
    void roomWithThief() {
        Room roomTest = new Room(4);
        assertSame(Thief.class, roomTest.getMonster().getClass());
    }

    @Test
    void roomWithTroll() {
        Room roomTest = new Room(3);
        assertSame(Troll.class, roomTest.getMonster().getClass());
    }
    @Test
    void searchRoomStrength(){
        Room roomWithoutPotion = new Room(1);
        assertNull(roomWithoutPotion.search());

        Room roomWithPotion = new Room(4);
        assertEquals(StrengthPotion.class, roomWithPotion.search().getClass());
    }

    @Test
    void searchRoomHealth(){
        Room roomWithoutPotion = new Room(1);
        assertNull(roomWithoutPotion.search());

        Room roomWithPotion = new Room(7);
        assertEquals(HealthPotion.class, roomWithPotion.search().getClass());
    }
    @Test
    void enterRoom() {
        Hero hero = new Hero();
        hero.setLifePoints(20);
        Room room = new Room(3);
        room.getMonster().setLifePoints(10);
        provideInputString("spear");
        GestionUser gestionUser = new GestionUser();
        assertThrows(NoSuchElementException.class,() -> gestionUser.promptYesNo("Coucou"));
    }

    /**
     * Methode permettant de simuler la saisie utilisateur
     * @param data : la chaine de caractère à tester
     */
    public void provideInputString(String data){
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Méthode pour simuler de multiples saisies
     * @param inputs
     */
    public void provideMultipleInputs(String... inputs) {
        for (String input : inputs) {
            provideInputString(input);
        }
    }
}