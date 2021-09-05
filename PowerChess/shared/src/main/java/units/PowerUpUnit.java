package units;

import board.Board;
import enums.UnitType;
import util.Position;

public class PowerUpUnit extends Unit{

    protected PowerUpUnit(int id, UnitType type, Board board, Position position) {
        super(id, type, board, position);
    }
}
