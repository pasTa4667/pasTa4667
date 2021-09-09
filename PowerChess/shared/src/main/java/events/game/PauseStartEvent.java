package events.game;

import enums.EventType;
import events.Event;
import util.ID;

import java.util.function.Function;

public class PauseStartEvent extends Event {

    public final ID playerPaused;

    public PauseStartEvent(ID playerPaused) {
        super(EventType.PauseStartEvent);
        this.playerPaused = playerPaused;
    }

    public String getName(Function<ID, String> getName){
        return getName.apply(this.playerPaused) + "Paused";
    }
}
