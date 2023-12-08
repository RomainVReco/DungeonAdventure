package Room;

import Character.Hero;
import Character.Monster;
import Event.ConfigDungeon;
import Event.GameEvent;
import Event.SaveState;
import GestionUtilisateur.GestionUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Créer un objet Dungeon qui va génerer automatiquement les Room, où évoluera le héros. La création nécessite un entier,
 * qui déterminera le nombre de pièce.
 * Le héros est généré automatiquement et il sera demandé au joueur de personnaliser le prénom via une demande de
 * la console.
 * Une fois le nom du héros renseigné, le jeu a proprement parlé est lancé
 *
 */
public class Dungeon {
    List<Room> listeRoom = new ArrayList<>();
    List<Monster> listeMonstres;
    int nombreRoom;
    int currentRoom = 0;
    GameEvent endGameEvent = new GameEvent();

    /**
     * Constructeur utilisé par la classe de test DungeonTest
     * @param nombreRoom
     * @param hero
     */
    public Dungeon(int nombreRoom, Hero hero){
        this.nombreRoom = nombreRoom;
        generateRoom(nombreRoom);
        this.listeMonstres = this.getAllMonstersFromDungeon();
    }

    /**
     * Contructeur du Dungeon
     * @param nombreRoom : le nombre de pièces configuré
     */
    public Dungeon(int nombreRoom) {
        this.nombreRoom = nombreRoom;
        generateRoom(nombreRoom);
        this.listeMonstres = this.getAllMonstersFromDungeon();
        Hero hero = generateHero();
        greetHeros(hero);
    }

    /**
     * Créer un héro lors de l'instranciation du Dungeon. Nécessite une entrée utilisateur via le clavier, pour déterminer
     * le nom
     * @return le héro nouvellement créé
     */
    private Hero generateHero() {
        GestionUser gestionUser = new GestionUser();
        String heroName = gestionUser.promptString("What is the Hero's name ?");
        return new Hero(heroName);
    }

    /**
     * A partir d'un entier, la méthode construit autant de Room que cet entier. Le joueur et son héro passeront donc
     * par autant de Room
     * @param nombreRoom un entier
     */
    private void generateRoom(int nombreRoom) {
        Room roomTemp;
        for (int i=1; i<=nombreRoom; i++){
            roomTemp = new Room(i);
            this.getListeRoom().add(roomTemp);
            roomTemp = null;
        }
    }

    /**
     * Une fois l'ensemble des Room générées à l'initialisation du Dungeon, la méthode stocke la liste de l'ensemble des
     * monstres dans l'ordre de leur création
     * @return une ArrayList de l'ensemble des monstres
     */
    public List<Monster> getAllMonstersFromDungeon() {
        List<Monster> listeMonstreRoom = new ArrayList<>();
        for (Room room : this.getListeRoom()){
            Monster monsterTemp = room.getMonster();
            listeMonstreRoom.add(monsterTemp);
        }
        return listeMonstreRoom;
    }

    /**
     * Lance le jeu et gère sa fin.
     * La fin est lancée en fonction de 2 évènements.
     * 1 : Le héro n'a plus de point de vie. Le score du joueur est sauvegardé et l'écran de défaite est lancé également.
     * Il est alors proposé au joueur de relancer une partie ou non.
     * 2 : Le héro a vaincu tous les monstres et a donc passé toutes les Room. Le score du joueur est sauvegardé.
     * L'écran de victoire est lancé. Il est alors proposé au joueur de relancer une partie ou non.
     *
     * Dans le cas où le joueur ne souhaite pas relancer une partie, alors le programme se ferme après avoir salué le joueur
     * @param hero : le héro généré par le Dungeon et personnalisé par le joueur
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
            System.out.println("You passed the last room");
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


}
