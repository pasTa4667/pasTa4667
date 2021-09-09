package events.character;

import enums.EventType;
import enums.PowerUpType;
import events.Event;
import units.PlayerUnit;
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

    public static UsePowerUpEvent useNPUp(PlayerUnit user){
        return new UsePowerUpEvent(user.getIDType(), PowerUpType.AP_UP, user.getPosition());
    }

    public static UsePowerUpEvent useMPUp(PlayerUnit user){
        return new UsePowerUpEvent(user.getIDType(), PowerUpType.MP_UP, user.getPosition());
    }

    public static UsePowerUpEvent useRangeUp(PlayerUnit user){
        return new UsePowerUpEvent(user.getIDType(), PowerUpType.RANGE_UP, user.getPosition());
    }
}
