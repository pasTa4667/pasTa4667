package events.gamestate;

import enums.EventType;
import enums.IDType;
import events.Event;
import units.Unit;

public class GamesStateEvent extends Event {

    public final Unit[] entities;
    public final int[] boardSize;
    public final boolean gameOver;
    public final IDType activePlayer;

    public GamesStateEvent(Unit[] entities, int[] boardSize, boolean gameOver, IDType activePlayer) {
        super(EventType.GamestateEvent);
        this.entities = entities;
        this.boardSize = boardSize;
        this.gameOver = gameOver;
        this.activePlayer = activePlayer;
    }
}
