package Character;

/**
 * La classe MonsterFactory est utilisee pour creer des instances de differents types
 * de monstres. Elle genere des monstres en fonction de certaines regles, comme
 * des criteres numeriques ou des conditions specifiques.
 */
public class MonsterFactory {


    /**
     * Les types de montres crees dependent de la valeur de l'index
     * selon les regles suivantes:
     * - Si l'index est un multiple de 4 et 3, elle cree un barbare.
     * - Si l'index est un multiple de 4, elle cree un voleur.
     * - Si l'index est un multiple de 3, elle cree un Troll.
     * - Si l'index est un nombre premier, elle cree un sorcier.
     * - Dans les autres cas, elle cree un Zombie.
     *
     * @param index c'est l'index numerique pour determiner le type de monster a creer
     * @return Une instance de Monstre selon l'index donné.
     */
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
