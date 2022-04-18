package events;

import java.util.stream.Stream;

public enum EventPriority {

    CRITICAL,
    HIGH,
    Normal,
    LOW;

    EventPriority(){}

    public static Stream<EventPriority> eventPriority(){
        return Stream.of(CRITICAL, HIGH, Normal, LOW);
    }
}
