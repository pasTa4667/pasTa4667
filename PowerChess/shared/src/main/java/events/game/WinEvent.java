package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class WinEvent extends Event {

    public final ID winner;

    public WinEvent( ID winner) {
        super(EventType.WinEvent);
        this.winner = winner;
    }

    public String getName(Function<ID, String> getName){
        return getName.apply(this.winner) + "is the Winner";
    }
}
