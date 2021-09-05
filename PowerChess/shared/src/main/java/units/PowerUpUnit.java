package units;

import board.Board;
import enums.PowerUpType;
import enums.UnitType;
import util.Position;

public class PowerUpUnit extends Unit{

    private final PowerUpType power;

    protected PowerUpUnit(int id, UnitType type, Board board, Position position, PowerUpType power) {
        super(id, type, board, position);
        this.power = power;
    }


}
