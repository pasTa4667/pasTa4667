package util;

import events.Event;

@FunctionalInterface
public interface IEventListener<T extends Event> {
    void onEvent(T var1);
}
