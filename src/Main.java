import Event.ConfigDungeon;
import Event.GameEvent;
import Room.Dungeon;

public class Main {

    public static void main(String[] args) {
        System.out.println("Coucou");
        new Dungeon(ConfigDungeon.getNumberOfRoomTest());
    }
}
