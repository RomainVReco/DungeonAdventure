package Test.Event;

import Event.EndGameEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndGameEventTest {

    @Test
    void gameOver() {
        EndGameEvent event = new EndGameEvent();
        event.victory();
    }
}