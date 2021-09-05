package units;

import board.Board;
import enums.UnitType;
import util.Position;

public class NPCUnit extends Unit{

    private String name;

    public NPCUnit(int id, UnitType type, Board board, Position position, String name) {
        super(id, type, board, position);
        this.name = name;
    }
}
