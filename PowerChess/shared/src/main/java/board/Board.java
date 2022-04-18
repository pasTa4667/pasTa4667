package board;

import configuration.ScenarioConfig;
import enums.BoardState;
import events.Event;
import events.EventPriority;
import units.Unit;
import util.ID;
import util.IEventListener;
import util.Position;

import java.util.*;
import java.util.stream.IntStream;

public class Board {


    private Field[][] grid;
    private final Map<ID, Unit> idToUnit;
    private final Map<EventPriority, Map<Class<? extends Event>, List<IEventListener<?>>>> eventListeners;

    public Board(int sizeX, int sizeY){
        this(new ScenarioConfig((BoardState[][]) IntStream.range(0, sizeX).mapToObj((i) ->{
            return (BoardState[]) IntStream.range(0, sizeY).mapToObj((j) -> {
                return BoardState.GRASS;
            }).toArray((x$0) ->{
                return new BoardState[x$0];
            });
                }).toArray((x$0) -> {
                    return new BoardState[x$0][];
        }), "debug_author", "debug_name"
        ));
    }

    public Board(ScenarioConfig scenarioConfig) {
        this.idToUnit = new HashMap();
        this.eventListeners = new EnumMap(EventPriority.class);
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

    public <T extends Event> void registerEvent(Class<T> eventClass, EventPriority priority, IEventListener<T> listener){
        ((List)((Map)this.eventListeners.computeIfAbsent(priority, (key) -> {
            return new HashMap<>();
        })).computeIfAbsent(eventClass, (key) -> {
            return new ArrayList();
        })).add(listener);

    }

    public void removeEvent(IEventListener<?> listener){
        this.eventListeners.values().stream().map(Map::values).flatMap(Collection::stream).forEach((listeners) -> {
            listeners.removeIf((listener1) -> {
                return listener1 == listener;
            });
        });
    }


    public <T extends Event> void postEvent(T event){
        EventPriority.eventPriority().forEach((priority) -> {
            Map<Class<? extends Event>, List<IEventListener<?>>> map = (Map)this.eventListeners.getOrDefault(priority, Collections.emptyMap());

            for(Class eventClass = event.getClass(); eventClass != Object.class; eventClass = eventClass.getSuperclass()) {
                ((List)map.getOrDefault(eventClass, Collections.emptyList())).forEach((listener) -> {
                    listener.onEvent(event);
                });
            }

        });
    }


}
