package Event;
import Character.Hero;
public class SaveState {

    String heroName;
    int numberOfSlayedMonsters;
    int healthRemaining;
    int currentStrength;
    int totalScore;

    public SaveState (){

    }
    public SaveState (Hero hero){
        this.heroName = hero.getHeroName();
        this.numberOfSlayedMonsters = hero.getSlayedMonsters().size();
        this.healthRemaining = hero.getNbLifePoints();
        this.currentStrength = hero.getStrength();
        calculateScore();
    }

    private void calculateScore(){
        this.totalScore = this.currentStrength+this.healthRemaining*100+this.numberOfSlayedMonsters*1000
                +this.currentStrength*10;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getNumberOfSlayedMonsters() {
        return numberOfSlayedMonsters;
    }

    public void setNumberOfSlayedMonsters(int numberOfSlayedMonsters) {
        this.numberOfSlayedMonsters = numberOfSlayedMonsters;
    }

    public int getHealthRemaining() {
        return healthRemaining;
    }

    public void setHealthRemaining(int healthRemaining) {
        this.healthRemaining = healthRemaining;
    }

    public int getCurrentStrength() {
        return currentStrength;
    }

    public void setCurrentStrength(int currentStrength) {
        this.currentStrength = currentStrength;
    }
    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
