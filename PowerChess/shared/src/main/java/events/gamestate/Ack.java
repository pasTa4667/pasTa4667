package events.gamestate;

import enums.EventType;
import events.Event;

public class Ack extends Event {

    public Ack() {
        super(EventType.Ack);
    }
}
