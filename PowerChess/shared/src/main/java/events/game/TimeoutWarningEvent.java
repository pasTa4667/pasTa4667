package events.game;

import enums.EventType;
import events.Event;

public class TimeoutWarningEvent extends Event {

    public final String message;
    public final int timeLeft;

    public TimeoutWarningEvent(String message, int timeLeft) {
        super(EventType.TimeoutWarningEvent);
        this.message = message;
        this.timeLeft = timeLeft;
    }
}
