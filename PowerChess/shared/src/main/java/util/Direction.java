package util;

public enum Direction {
    NORTH(1, 0),
    SOUTH(-1, 0),
    WEST(0, -1),
    EAST(0, 1),
    NORTH_EAST(1, 1),
    NORTH_WEST(1, -1),
    SOUTH_WEST(-1, -1),
    SOUTH_EAST(-1, 1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
