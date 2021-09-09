package events.entity;

import enums.EventType;
import events.Event;
import util.ID;
import util.Position;

import java.util.function.Function;

public class SpawnEntityEvent extends Event {

    public final ID entity;
    public final Position position;

    public SpawnEntityEvent(ID id, Position position) {
        super(EventType.SpawnEntityEvent);
        this.entity = id;
        this.position = position;
    }

    public String toString(Function<ID, String> getName){
        return getName.apply(this.entity) + " spawned at " + this.position.toString();
    }
}
