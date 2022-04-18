package events;

import enums.EventType;
import util.ID;

import java.util.function.Function;

public abstract class Event {
    public final EventType eventType;

    protected Event(EventType eventType) {
        this.eventType = eventType;
    }

    public String toString(Function<ID, String> getName) {
        return "";
    }
}
