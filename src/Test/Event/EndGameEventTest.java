package Test.Event;

import Event.GameEvent;
import org.junit.jupiter.api.Test;

class EndGameEventTest {

    @Test
    void gameOver() {
        GameEvent event = new GameEvent();
        event.victory();
    }
}