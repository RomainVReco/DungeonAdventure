package Test.Weapon;

import Weapon.Monster.Club;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterWeaponTest {

    @Test
    void createInstanceOfMonsterWeapon(){
        Club club = new Club();
        assertNotNull(club);
    }

    @Test
    void checkMaxRoundBeforeCritical(){
        Club club = new Club();
        assertEquals(-1, club.getMaxRoundBeforeCritical());
    }

    @Test
    void inflictDamage() {
    }
}