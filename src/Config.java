import Weapon.Hero.HeroWeapons;

import java.util.HashMap;

public final class Config {
    private static Config config = null;
    private static final int numberOfRooms = 25;
    private static final HashMap<String, HeroWeapons> arsenal = new HashMap<>();

    private Config() {

    }

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public HashMap<String, HeroWeapons> getAllHeroWeapons(){
        return arsenal;
    }

}
