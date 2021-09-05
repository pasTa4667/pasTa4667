package board;

import configuration.ScenarioConfig;
import enums.BoardState;
import units.Unit;
import util.ID;
import util.Position;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Board {


    private Field[][] grid;
    private List<Unit> units;
    private Map<ID, Unit> idToUnit;

    public Board(int sizeX, int sizeY){
        this(new ScenarioConfig((BoardState[][]) IntStream.range(0, sizeX).mapToObj((i) ->{
            return (BoardState[]) IntStream.range(0, sizeY).mapToObj((j) -> {
                return BoardState.GRASS;
            }).toArray((x$0) -> {
                return new BoardState[x$0];
            });
        }).toArray((x$0) -> {
            return new BoardState[x$0][];
        }), "debug_author", "debug_name"
        ));
    }

    public Board(ScenarioConfig scenarioConfig) {
        this.idToUnit = new HashMap();
        int sizeX = scenarioConfig.scenario.length;
        int sizeY = scenarioConfig.scenario[0].length;
        this.grid = new Field[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++){
                this.grid[i][j] = new Field(this, i, j);
                if(scenarioConfig.scenario[i][j] == BoardState.WOOD){
                    //TODO: spawn wood
                }
            }
        }
    }

    public boolean spawnUnit(Unit unit){
        return true;
    }

    public boolean isValidPosition(Position position){
        int gridX = this.grid.length;
        int gridY = this.grid[0].length;

        if(position.getX() > gridX || position.getY() > gridY){
            return false;
        }

        if(position.getX() < 0 || position.getY() < position.getY()){
            return false;
        }

        return this.grid[position.getX()][position.getY()].isEmpty();

    }


}
