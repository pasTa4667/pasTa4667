package events.character;

import enums.EventType;
import enums.PowerUpType;
import events.Event;
import util.ID;
import util.Position;

public class UsePowerUpEvent extends Event {

    public final ID entity;
    public final PowerUpType powerUp;
    public final Position position;

    public UsePowerUpEvent(ID entity, PowerUpType powerUp, Position position) {
        super(EventType.UsePowerUpEvent);
        this.entity = entity;
        this.powerUp = powerUp;
        this.position = position;
    }
}
