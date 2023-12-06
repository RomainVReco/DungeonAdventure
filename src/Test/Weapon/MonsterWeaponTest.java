package Test.Weapon;

import Weapon.Monster.Club;
import org.junit.jupiter.api.Test;
import Character.*;

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
    void checkCriticalCountDownIncrement(){
        Club club = new Club();
        club.inflictDamage(new Hero());
        assertEquals(1, club.getCriticalCountDown());
    }

    @Test
    void checkCriticalCountDownReset(){
        Club club = new Club();
        club.setMaxRoundBeforeCritical(4);
        club.setBonusDamage(2);
        Hero hero = new Hero();
        for (int i=0; i<4; i++){
            club.inflictDamage(hero);
        }
        assertEquals(4, club.getCriticalCountDown());
        club.inflictDamage(hero);
        assertEquals(0, club.getCriticalCountDown());
    }

    @Test
    void inflictDamage() {
    }
}