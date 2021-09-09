package events.gamestate;

import enums.EventType;
import events.Event;

public class Nack extends Event {

    public Nack() {
        super(EventType.Nack);
    }
}
