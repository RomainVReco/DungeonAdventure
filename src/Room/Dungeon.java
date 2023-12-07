package Room;

import Character.Hero;
import Character.Monster;
import Event.ConfigDungeon;
import Event.GameEvent;
import Event.SaveState;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    List<Room> listeRoom = new ArrayList<>();
    List<Monster> listeMonstres;
    int nombreRoom;
    int currentRoom = 1;
    GameEvent endGameEvent = new GameEvent();

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

    public List<Monster> getAllMonstersFromDungeon() {
        List<Monster> listeMonstreRoom = new ArrayList<>();
        for (Room room : this.getListeRoom()){
            Monster monsterTemp = room.getMonster();
            listeMonstreRoom.add(monsterTemp);
        }
        return listeMonstreRoom;
    }

    /**
     *
     * @param hero
     */
    public void greetHeros(Hero hero) {
        String playerChoice;
        System.out.print("Aventurier, bienvenue dans le donjon de la Muerte");
        do {
            System.out.println("Préparte toi à rentrer dans la pièce n°"+this.getCurrentRoom());
            Room roomToEnter = this.listeRoom.get(this.currentRoom);
            this.currentRoom +=1;
            roomToEnter.enterRoom(hero);
        } while((hero.isAlive())||(this.currentRoom<this.nombreRoom));
        SaveState newSave = new SaveState(hero);
        if (!hero.isAlive()) {
            playerChoice = this.endGameEvent.gameOver();
        } else {
            playerChoice = this.endGameEvent.victory();
            }
        switch (playerChoice){
            case "Y":
                new Dungeon(ConfigDungeon.getNumberOfRoomTest());
            case "N":
                System.exit(9999);
        }
        //        for (Room room : this.getListeRoom()){
//            System.out.println("Préparte toi à rentrer dans la pièce n°"+this.getCurrentRoom());
//            room.enterRoom(hero);
//
//            System.out.println("Bravo, tu as vaincu le "+room.getMonster()+". Un autre défi t'attend aventurier");
//            this.currentRoom +=1;
//        }
    }

    public List<Room> getListeRoom() {
        return listeRoom;
    }

    public List<Monster> getListeMonstres() {
        return listeMonstres;
    }
    public int getCurrentRoom() {
        return currentRoom;
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

    public void setListeMonstres(List<Monster> listeMonstres) {
        this.listeMonstres = listeMonstres;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }




}
