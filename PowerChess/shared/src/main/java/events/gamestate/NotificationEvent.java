package events.gamestate;

import enums.EventType;
import events.Event;

public class NotificationEvent extends Event {

    public NotificationEvent() {
        super(EventType.NotificationEvent);
    }
}
