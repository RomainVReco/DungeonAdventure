package Event;

public class EndGameEvent {

    public void startGame(){
    }

    public void gameOver(){
    }

    public void victory(){
        String endGameText = "In the dimly lit chambers of the ominous dungeon, a triumphant hush falls. The valiant hero,\n" +
                "armed with unwavering courage and a gleaming blade, has vanquished every monstrous foe that dared to roam the echoing halls.\n" +

        "\nThe once-menacing shadows have now succumbed to the radiance of victory, leaving behind a trail of defeated \n" +
                "adversaries. As the hero stands amidst the conquered rooms, a profound silence reigns, broken only by \n" +
                "the distant echoes of recent clashes. The air is thick with the sweet taste of success, and the \n" +
                "flickering torches cast dancing shadows on the worn dungeon walls.\n" +

        "\nThe hero, wearied but resolute, gazes upon the conquered realm with a sense of fulfillment. The dungeon, \n" +
                "once a labyrinth of peril, now bears witness to the hero's indomitable spirit. The scent of victory \n" +
                "lingers in the air, intertwining with the lingering traces of battles fought and won.\n" +

        "\nIn every corner, the remnants of defeated monsters serve as a testament to the hero's prowess. The hero's journey\n" +
                "through the depths of darkness has reached its zenith. The dungeon, once a realm of nightmares, now \n" +
                "basks in the glow of the hero's triumph. A new chapter awaits, and the hero, having conquered all, emerges\n" +
                "from the shadows into the light,ready for the next adventure that awaits beyond the dungeon's formidable gates.";

        System.out.println(endGameText);
    }

}
