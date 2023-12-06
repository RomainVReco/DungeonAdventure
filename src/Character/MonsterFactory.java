package Character;

public class MonsterFactory {

    public Monster createMonster(int index){
        if (index % 4 == 0 && index % 3 == 0) {
            return new Barbarian();
        } else if (index % 4 == 0) {
           return new Thief();
        } else if (index % 3 == 0) {
            return new Troll();
        } else if (isPrime(index)) {
            return new Sorcerer();
        } else {
            return new Zombie();
        }
    }

    private boolean isPrime(int p_iIndex) {
        if (p_iIndex == 2)
            return true;
        if (p_iIndex % 2 == 0 || p_iIndex < 3)
            return false;
        for (int i = 3; i <= Math.pow(p_iIndex, 0.5) + 1; i += 2) {
            if (p_iIndex % i == 0) return false;
        }
        return true;
    }
}
