package events;

import enums.EventType;

public abstract class Event {

    public EventType eventType;

    public Event(EventType eventType){
        this.eventType = eventType;
    }
}
