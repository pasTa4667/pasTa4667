package units;

import board.Board;
import enums.UnitType;
import util.Position;

public abstract class Unit {

    private UnitType type;
    private Board board;
    private Position position;
    private int id;

    protected Unit(int id, UnitType type, Board board, Position position){
        this.id = id;
        this.type = type;
        this.board = board;
        this.position = position;
    }

    public UnitType getType() {
        return type;
    }

    public Board getBoard() {
        return board;
    }

    public Position getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }
}
