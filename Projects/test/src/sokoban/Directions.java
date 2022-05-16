package sokoban;

public enum Directions {
    NORTH(-1, 0),
    SOUTH(+1, 0),
    WEST(0, -1),
    EAST(0, +1);

    public final int x;
    public final int y;

    Directions(int x,int y){
        this.x = x;
        this.y = y;
    }
}
