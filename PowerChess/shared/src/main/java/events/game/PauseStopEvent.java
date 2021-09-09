package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class PauseStopEvent extends Event {

    public PauseStopEvent() {
        super(EventType.PauseStopEvent);
    }

    public String toString(Function<ID, String> getName){
        return "Resumed";
    }
}
