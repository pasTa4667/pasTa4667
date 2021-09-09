package events.entity;

import enums.EventType;
import events.Event;
import util.ID;
import util.Position;

import java.util.function.Function;

public class ConsumedMPEvent extends Event {

    public final int amount;
    public final ID entity;
    public final Position position;

    public ConsumedMPEvent(int AP, ID entity, Position position) {
        super(EventType.ConsumedMPEvent);
        this.amount = AP;
        this.entity = entity;
        this.position = position;
    }

    public String toString(Function<ID, String> getName){
        return getName.apply(this.entity) + " consumed " + this.amount + " AP";
    }
}

