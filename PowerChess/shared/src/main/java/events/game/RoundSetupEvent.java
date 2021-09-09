package events.game;

import enums.EventType;
import events.Event;
import units.Unit;

public class RoundSetupEvent extends Event {

    public final Unit[] entities;
    public final int roundCount;

    public RoundSetupEvent(Unit[] entities, int roundCount) {
        super(EventType.RoundSetupEvent);
        this.entities = entities;
        this.roundCount = roundCount;
    }
}
