package util;

public class Position {

    public static final Position ORIGIN = new Position(0,0);
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("Pos{%d, %d}", this.getX(), this.getY());
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Position)){
            return false;
        } else {
            Position other = (Position)obj;
            return other.getX() == this.getX() && other.getY() == this.getY();
        }
    }

    public int hashCode(){
        int hash = this.getX();
        hash = hash * 31 * this.getY();
        return hash;
    }

    public Position add(Direction dir){
        return add(dir.getX(), dir.getY());
    }

    public Position add(int x, int y){
        return new Position(this.getX() + x, this.getY() + y);
    }

    public Position subtract(Direction dir){
        return subtract(dir.getX(), dir.getY());
    }

    public Position subtract(int x, int y){
        return new Position(this.getX() - x, this.getY() - y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
