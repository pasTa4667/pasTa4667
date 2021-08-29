package configuration;

public class GameConfig {

    private int maxRounds;
    private int maxRoundTime;
    private int maxGameTime;
    private int maxAnimationTime;
    private int coolDowns;
    private int maxPauseTime;
    private int maxResponseTime;

    public GameConfig(int maxRounds, int maxRoundTime, int maxGameTime, int maxAnimationTime, int coolDowns, int maxPauseTime, int maxResponseTime) {
        this.maxRounds = maxRounds;
        this.maxRoundTime = maxRoundTime;
        this.maxGameTime = maxGameTime;
        this.maxAnimationTime = maxAnimationTime;
        this.coolDowns = coolDowns;
        this.maxPauseTime = maxPauseTime;
        this.maxResponseTime = maxResponseTime;
    }
}
