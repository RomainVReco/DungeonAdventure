package Event;

import GestionUtilisateur.GestionUser;
import Room.Dungeon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe permettant de gérer les événements majeurs du programme : lancement, victoire, défaite, sauvegarde du score
 */
public class GameEvent {

    GestionUser gestionUser = new GestionUser();

    public Dungeon startGame(){
       return new Dungeon(ConfigDungeon.getNumberOfRoomTest());
    }

    /**
     * Ecran de défaite affichant un texte approprié à la situation. Une fois le texte affiché, il est demandé au joueur
     * s'il veut rejouer
     * @return le choix du joueur pour lancer ou non une nouvelle partie "Y" ou "N"
     */
    public String gameOver(){
        String defeatEndGameText = "\nIn the echoing depths of the foreboding dungeon, a haunting silence descends as the \n" +
                "valiant hero lies fallen, defeated by the malevolent forces that lurk within. The once-hopeful mission \n" +
                "to purge the evil that gripped the darkened halls has ended in tragedy. \n" +

                "\nThe hero's armor, once gleaming with resilience, now bears the scars of an unwinnable battle. The air\n" +
                "is heavy with an oppressive gloom as the malevolence, once contained within the dungeon's confines, seeps\n" +
                "out like an ominous mist, ready to spread its tendrils beyond. \n" +

                "\nIn the wake of the hero's demise, a sense of foreboding creeps into the very stones of the dungeon. \n" +
                "The evil, now unchained, hungers for dominion over the realm of Earth. The failed mission has become a \n" +
                "harbinger of doom, and the consequences of the hero's defeat weigh heavily on the fate of all.";
        System.out.println(defeatEndGameText);
        return this.gestionUser.promptYesNo("\nDefeat has befallen our valiant hero. Would you dare to rise again, " +
                "face the looming shadows, and rewrite the destiny that awaits in the dungeon's depths ?\n");
    }

    /**
     * Ecran de victoire affichant un texte approprié à la situation. Une fois le texte affiché, il est demandé au joueur
     * s'il veut rejouer
     * @return le choix du joueur pour lancer ou non une nouvelle partie "Y" ou "N"
     */
    public String victory(){
        String victoryEndGameText = "\nIn the dimly lit chambers of the ominous dungeon, a triumphant hush falls. The valiant hero,\n" +
                "armed with unwavering courage and a gleaming blade, has vanquished every monstrous foe that dared to roam the echoing halls.\n" +

        "\nThe once-menacing shadows have now succumbed to the radiance of victory, leaving behind a trail of defeated \n" +
                "adversaries. As the hero stands amidst the conquered rooms, a profound silence reigns, broken only by \n" +
                "the distant echoes of recent clashes. The air is thick with the sweet taste of success, and the \n" +
                "flickering torches cast dancing shadows on the worn dungeon walls.\n" +

        "\nIn every corner, the remnants of defeated monsters serve as a testament to the hero's prowess. The hero's journey\n" +
                "through the depths of darkness has reached its zenith. The dungeon, once a realm of nightmares, now \n" +
                "basks in the glow of the hero's triumph. A new chapter awaits, and the hero, having conquered all, emerges\n" +
                "from the shadows into the light,ready for the next adventure that awaits beyond the dungeon's formidable gates.";
        System.out.println(victoryEndGameText);
        return this.gestionUser.promptYesNo("\nWould you like to play again ?\n");
    }

    /**
     * A partir d'un objet SaveState, transforme en une chaine de caractère compatible avec le format JSON, et la sauvegarde
     * dans une liste. Dans une évolution future, il sera nécessaire de sauvegarder au format JSON ou
     * @param newSave POJO représentant les éléments de fin de partie utilisée pour le score
     */
    public void saveGame(SaveState newSave) {
        String jsonString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writeValueAsString(newSave);
        } catch (JsonProcessingException e) {
            System.out.println("Echec transposition JSON");
        }
        System.out.println(jsonString);
        ConfigDungeon.getSavedGame().add(jsonString);
    }
}
