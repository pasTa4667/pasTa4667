package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class TurnEvent extends Event {

    public final int turnCount;

    public TurnEvent(int turnCount, ID nextEntity) {
        super(EventType.TurnEvent);
        this.turnCount = turnCount;
    }

    public String toString(Function<ID, String> getName){
        return "Turn " + turnCount;
    }
}
