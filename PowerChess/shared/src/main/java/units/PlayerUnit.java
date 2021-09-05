package units;

import board.Board;
import enums.FieldType;
import enums.FigureType;
import enums.UnitType;
import util.BaseFigure;
import util.Direction;
import util.Position;

public class PlayerUnit extends Unit{

    private String name;
    private final int PID;
    private FigureType type;
    private int MP, AP;

    public PlayerUnit(int id, Board board, int MP, int AP, int PID){
        super(id, UnitType.FIGURE, board, Position.ORIGIN);
        this.MP = MP;
        this.AP = AP;
        this.PID = PID;
    }

    public PlayerUnit(BaseFigure figure, Board board, int PID){
        this(figure.figureID, board, figure.MP, figure.AP, PID);
        this.name = figure.name;;
    }

    public PlayerUnit(int id, Board board, int MP, int AP, String name, int PID) {
        this(id, board, MP, AP, PID);
        this.name = name;
    }

    public boolean move(Direction dir){
        switch(type){
            case KNIGHT:
                return knightMove(dir);
            case ROOK:
                return rookMove(dir);
            case PAWN:
                return pawnMove(dir);
            case QUEEN:
                return queenMove(dir);
            case KING:
                return kingMove(dir);
            case BISHOP:
                return bishopMove(dir);
            default:
                return false;

        }
    }

    private boolean knightMove(Direction dir){
        if(this.getBoard().isValidPosition(this.getPosition().add(dir))){

        }
        return false;
    }

    private boolean pawnMove(Direction dir){
        if(this.getBoard().isValidPosition(this.getPosition().add(dir))){

        }
        return false;
    }

    private boolean kingMove(Direction dir){
        if(this.getBoard().isValidPosition(this.getPosition().add(dir))){

        }
        return false;
    }

    private boolean queenMove(Direction dir){
        if(this.getBoard().isValidPosition(this.getPosition().add(dir))){

        }
        return false;
    }

    private boolean rookMove(Direction dir){
        if(this.getBoard().isValidPosition(this.getPosition().add(dir))){

        }
        return false;
    }

    private boolean bishopMove(Direction dir){
        if(this.getBoard().isValidPosition(this.getPosition().add(dir))){

        }
        return false;
    }
}
