package units;

import board.Board;
import enums.UnitType;
import util.Position;

public class WoodUnit extends Unit{

    public WoodUnit(int id, UnitType type, Board board, Position position) {
        super(id, type, board, position);
    }
}
