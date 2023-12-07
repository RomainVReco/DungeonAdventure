package Event;

import Weapon.Hero.HeroWeapons;

import java.util.HashMap;

public final class ConfigDungeon {
    private static ConfigDungeon configDungeon = null;
    private static final int numberOfRoomsMax = 25;
    private static final int numberOfRoomTest = 1;
    private static final int heroStrength = 1;
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

    private void createJSON() {

    }

}
