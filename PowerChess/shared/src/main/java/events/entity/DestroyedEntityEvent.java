package events.entity;

import enums.EventType;
import events.Event;
import util.ID;
import util.Position;

import java.util.function.Function;

public class DestroyedEntityEvent extends Event {

    public final ID entity;
    public final Position position;

    public DestroyedEntityEvent(ID id, Position position) {
        super(EventType.DestroyedEntityEvent);
        this.entity = id;
        this.position = position;
    }

    public String toString(Function<ID, String> getName){
        return getName.apply(this.entity) + " destroyed at " + this.position.toString();
    }
}
