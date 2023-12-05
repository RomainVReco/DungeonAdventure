package Room;

import Character.Hero;
import Character.Monster;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    List<Room> listeRoom = new ArrayList<>();
    List<Monster> listeMonstres = new ArrayList<>();
    int nombreRoom;
    int currentRoom;

    public Dungeon(int nombreRoom) {
        this.nombreRoom = nombreRoom;
        genererRoom(nombreRoom);
        this.listeMonstres = this.getAllMonstersFromDungeon();
    }

    private void genererRoom(int nombreRoom) {
        Room roomTemp;
        for (int i=1; i<=nombreRoom; i++){
            roomTemp = new Room(i);
            this.getListeRoom().add(roomTemp);
            roomTemp = null;
        }

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

    public List<Monster> getListeMonstres() {
        return listeMonstres;
    }

    public void setListeMonstres(List<Monster> listeMonstres) {
        this.listeMonstres = listeMonstres;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<Monster> getAllMonstersFromDungeon() {
        List<Monster> listeMonstreRoom = new ArrayList<>();
        for (Room room : this.getListeRoom()){
            Monster monsterTemp = room.getMonster();
            listeMonstreRoom.add(monsterTemp);
        }
        return listeMonstreRoom;
    }


}
