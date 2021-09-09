package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class TurnTimeoutEvent extends Event {

    public TurnTimeoutEvent() {
        super(EventType.TurnTimeoutEvent);
    }

    public String toString(Function<ID, String> getName){
        return "Timeout";
    }
}
