package events.character;

import enums.EventType;
import events.Event;
import util.ID;
import util.Position;

import java.util.function.Function;

public class MoveEvent extends Event {

    public final ID entity;
    public final Position origin;
    public final Position target;

    public MoveEvent(ID entity, Position origin, Position target) {
        super(EventType.MoveEvent);
        this.entity = entity;
        this.origin = origin;
        this.target = target;

    }

    public String toString(Function<ID, String> getName){
        return getName.apply(this.entity) + "moved to " + this.target.toString();

    }
}
