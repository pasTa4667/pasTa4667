package enums;

public enum EventType {
    GamestateEvent,
    Ack,
    Nack,
    CustomEvent,
    ConsumedAPEvent,
    ConsumedMPEvent,
    SpawnEntityEvent,
    DestroyedEntityEvent,
    MoveEvent,
    UsePowerUpEvent,
    RoundSetupEvent,
    TurnEvent,
    WinEvent,
    PauseStartEvent,
    PauseStopEvent,
    TurnTimeoutEvent,
    TimeoutWarningEvent,
    TimeoutEvent,
    DisconnectEvent,
    TeleportEvent,
    NotificationEvent;

    private EventType() {
    }
}
