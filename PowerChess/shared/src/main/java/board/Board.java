package board;

import units.Unit;
import util.ID;
import util.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    private int sizeX;
    private int sizeY;

    private Field[][] grid = new Field[][]{};
    private List<Unit> unit = new ArrayList();
    private HashMap<ID, Unit> idToUnit = new HashMap<>();

    public Board(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public boolean isValidPosition(Position position){
        if(position.getX() < 0 || position.getY() < 0){
            return false;
        } else if(position.getX() > this.getSizeX() || position.getY() > getSizeY()){
            return false;
        } else return true;
    }


    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

}
