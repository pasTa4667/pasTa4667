package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class TimeoutEvent extends Event {

    public final String message;

    public TimeoutEvent(String message) {
        super(EventType.TimeoutEvent);
        this.message = message;
    }

    public String toString(Function<ID, String> getName){
        return "Timed out";
    }
}
