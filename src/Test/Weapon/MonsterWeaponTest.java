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
    void inflictDamage() {
        Club club = new Club();
        Hero hero = new Hero();
        int baseLifePoint = hero.getNbLifePoints();
        assertEquals(0, hero.getNbLifePoints());
        club.inflictDamage(hero);
        assertEquals(baseLifePoint- club.getAttackPoints(), hero.getNbLifePoints());
    }

    @Test
    void inflictDamageWithBonusDamage(){
        Club club = new Club();
        Hero hero = new Hero();
        club.setBonusDamage(2);
        club.setMaxRoundBeforeCritical(1);
        int baseLifePoint = hero.getNbLifePoints();
        club.inflictDamage(hero);
        int damageDone = baseLifePoint-(club.getAttackPoints())*(Float.valueOf(club.getBonusDamage()).intValue());
        assertEquals(damageDone,hero.getNbLifePoints() );
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
        assertEquals(0, club.getCriticalCountDown());
    }

    @Test
    void checkCriticalCountDownReset(){
        Club club = new Club();
        club.setMaxRoundBeforeCritical(4);
        club.setBonusDamage(2);
        Hero hero = new Hero();
        for (int i=1; i<=4; i++){
            club.inflictDamage(hero);
        }
        assertEquals(0, club.getCriticalCountDown());
    }

    @Test
    void noIncrementCriticalCountDown(){
        Club club = new Club();
        club.inflictDamage(new Hero());
        club.inflictDamage(new Hero());
        assertEquals(0, club.getCriticalCountDown());
    }

}