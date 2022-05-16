package sokoban;

import blatt02.Pair;

import java.util.Arrays;

public class Sokoban {

    private char[][] field;
    private final int x;
    private final int y;

    public Sokoban(char[][] field){
        this.field = field;
        this.x = field[0].length;
        this.y = field.length;

    }

    public boolean move(Directions direction){
        int px = findPlayer().getFirst();
        int py = findPlayer().getSecond();

        if(field[px + direction.x][py + direction.y] == '.'){
            field[px + direction.x][py + direction.y] = '@';
            field[px][py] = '.';
            return true;
        }else if(field[px + direction.x][py + direction.y] == '$' &&
                field[px + direction.x * 2][py + direction.y * 2] == '.'){
            field[px + direction.x * 2][py + direction.y * 2] = '$';
            field[px + direction.x][py + direction.y] = '@';
            field[px][py] = '.';
            return true;
        } else return false;

    }


    public Pair<Integer, Integer> findPlayer(){
        for(int i = 0; i < field[0].length; i++){
            for(int j = 0; j < field.length; j++){
                if(field[i][j] == '@'){
                    return new Pair(i, j);
                }
            }
        }
        return null;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < field[0].length; i++){
            for(int j = 0; j < field[i].length; j++){
                string.append(field[i][j]);
            }
            string.append(System.lineSeparator());
        }
        return string.toString();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
