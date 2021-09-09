package events.portal;

import enums.EventType;
import events.Event;
import util.ID;
import util.Position;

import java.util.function.Function;

public class TeleportEvent extends Event {

    public final ID entity;
    public final Position origin;
    public final Position target;
    public final ID originPortal;
    public final ID targetPortal;

    public TeleportEvent(ID entity, Position origin, Position target, ID originPortal, ID targetPortal) {
        super(EventType.TeleportEvent);
        this.entity = entity;
        this.origin = origin;
        this.target = target;
        this.originPortal = originPortal;
        this.targetPortal = targetPortal;
    }

    public String toString(Function<ID, String> getName){
        return getName.apply(this.entity) + "teleported from " + this.origin.toString();
    }
}
