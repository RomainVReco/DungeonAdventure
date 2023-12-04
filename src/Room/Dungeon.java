package Room;

import Character.Hero;
import Character.Monster;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    List<Room> listeRoom = new ArrayList<>();
    int nombreRoom;

    public Dungeon(int nombreRoom) {
        this.nombreRoom = nombreRoom;
        genererRoom(nombreRoom);
    }

    private void genererRoom(int nombreRoom) {

    }


    public List<Room> getListeRoom() {
        return listeRoom;
    }

    public void setListeRoom(List<Room> listeRoom) {
        this.listeRoom = listeRoom;
    }

    public int getNombreRoom() {
        return nombreRoom;
    }

    public void setNombreRoom(int nombreRoom) {
        this.nombreRoom = nombreRoom;
    }

    public Room getRoom(int roomIndex) {
        return this.listeRoom.get(roomIndex);
    }

    public boolean ajouterRoom(Room nouvelleRoom){
        return this.listeRoom.add(nouvelleRoom);
    }

    public void greetHeros(Hero hero) {
        System.out.print("Aventurier, bienvenue dans le donjon de la Muerte");
    }

    public List<Monster> getAllMonstersFromDungeon() {
        return null;
    }


}
