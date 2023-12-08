package Event;

import Weapon.Hero.HeroWeapons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * La classe ConfigDungeon sert à configurer le donjon dans le jeu ou
 * dans la classe test.
 * Cette classe garanti qu'une seul instance de la configuration est cree et est utilisee dans tout
 * le jeu.
 * Elle fournit des parametres de configuration, et recupere par ses methodes des informations pour le
 * bon fonctionnement du jeu.
 */
public final class ConfigDungeon {
    private static int heroLifePoints = 50;
    private static ConfigDungeon configDungeon = null;
    private static final int numberOfRoomsMax = 25;
    private static final int numberOfRoomTest = 1;
    private static final int heroStrength = 1;
    String os = System.getProperty("os.name");
    private static List<String> savedGame  =new ArrayList<>();
    private static final HashMap<String, HeroWeapons> arsenal = new HashMap<>();

    private ConfigDungeon() {

    }

    public static ConfigDungeon getConfig() {
        if (configDungeon == null) {
            configDungeon = new ConfigDungeon();
        }
        return configDungeon;
    }

    public int getNumberOfRoomMax() {
        return numberOfRoomsMax;
    }

    public HashMap<String, HeroWeapons> getAllHeroWeapons(){
        return arsenal;
    }

    public static int getHeroStrength() {
        return heroStrength;
    }

    public static int getNumberOfRoomTest() {
        return numberOfRoomTest;
    }
    public String givePath(){
        if (this.os.contains("Mac")) return "Ressources/";
        else return "Ressouces\\";

    }
    public static int getHeroLifePoints(){
        return heroLifePoints;
    }

    public static List<String> getSavedGame(){
        return savedGame;
    }

}
