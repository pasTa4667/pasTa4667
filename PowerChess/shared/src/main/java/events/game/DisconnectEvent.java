package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class DisconnectEvent extends Event {

    public DisconnectEvent() {
        super(EventType.DisconnectEvent);
    }

    public String toString(Function<ID, String> getName){
        return "Disconnected";
    }
}
