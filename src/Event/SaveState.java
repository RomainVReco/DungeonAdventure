package Event;
import Character.Hero;

/**
 * Créer un POJO pour sauvegarder certaines informations de la partie afin de calculer un score et effectuer
 * une sérialisation de l'objet
 */
public class SaveState {

    String heroName;
    int numberOfSlayedMonsters;
    int healthRemaining;
    int currentStrength;
    int totalScore;

    /**
     * Constructeur par défaut
     */
    public SaveState (){

    }

    /**
     * Constructeur de l'objet SaveState, prend un objet Hero en paramètre, pour en extraire les informations nécesaires
     * au calcul du score
     * @param hero
     */
    public SaveState (Hero hero){
        this.heroName = hero.getHeroName();
        this.numberOfSlayedMonsters = hero.getSlayedMonsters().size();
        this.healthRemaining = hero.getNbLifePoints();
        this.currentStrength = hero.getStrength();
        calculateScore();
    }

    /**
     * Formule de calcul du score, qui privilégie le nombre de Room passées
     */
    private void calculateScore(){
        this.totalScore = this.currentStrength+(this.healthRemaining*100)+(this.numberOfSlayedMonsters*1000
        )+(this.currentStrength*10);
    }

    public String getHeroName() {
        return heroName;
    }
    public int getNumberOfSlayedMonsters() {
        return numberOfSlayedMonsters;
    }
    public int getHealthRemaining() {
        return healthRemaining;
    }
    public int getCurrentStrength() {
        return currentStrength;
    }
    public int getTotalScore() {
        return totalScore;
    }
}
