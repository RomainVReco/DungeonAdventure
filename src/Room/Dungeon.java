package Room;

import Character.Hero;
import Character.Monster;
import Event.ConfigDungeon;
import Event.GameEvent;
import Event.SaveState;
import GestionUtilisateur.GestionUser;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    List<Room> listeRoom = new ArrayList<>();
    List<Monster> listeMonstres;
    int nombreRoom;
    int currentRoom = 0;
    GameEvent endGameEvent = new GameEvent();

    public Dungeon(int nombreRoom) {
        this.nombreRoom = nombreRoom;
        generateRoom(nombreRoom);
        this.listeMonstres = this.getAllMonstersFromDungeon();
        Hero hero = generateHero();
        greetHeros(hero);
    }

    private Hero generateHero() {
        GestionUser gestionUser = new GestionUser();
        String heroName = gestionUser.promptString("What is the Hero's name ?");
        return new Hero(heroName);
    }

    private void generateRoom(int nombreRoom) {
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
        System.out.println("Welcome to the dungeon de la Muerte, Adventurer");
        do {
            System.out.println("Be ready to enter room n°"+(this.getCurrentRoom()+1));
            Room roomToEnter = this.listeRoom.get(this.currentRoom);
            this.currentRoom +=1;
            roomToEnter.enterRoom(hero);
        } while((hero.isAlive())&&(this.currentRoom<this.nombreRoom));
        SaveState newSave = new SaveState(hero);
        this.endGameEvent.saveGame(newSave);
        if (!hero.isAlive()) {
            System.out.println("The Hero is dead");
            playerChoice = this.endGameEvent.gameOver();
        } else {
            playerChoice = this.endGameEvent.victory();
            }
        switch (playerChoice){
            case "Y":
                new Dungeon(ConfigDungeon.getNumberOfRoomTest());
            case "N":
                System.out.println("\nSee you later, alligator\n");
                System.exit(9999);
        }
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
