package board;

import units.Unit;
import util.Position;

public class Field {

    private Board board;
    private Position position;
    private Unit unit;

    public Field(Board board, int x, int y){
        this.board = board;
        this.position = new Position(x, y);
    }

    public Unit getUnit(){
        return this.unit;
    }

    public void setUnit(Unit unit){
        this.unit = unit;
    }

    public Position getPosition(){
        return this.position;
    }

    public boolean isEmpty(){
       return this.unit == null;
    }
}
