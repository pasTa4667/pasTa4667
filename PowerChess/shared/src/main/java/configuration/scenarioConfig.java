package configuration;

import enums.BoardState;

public class scenarioConfig {

    private final BoardState[][] scenario;
    private String author;
    private String name;

    public scenarioConfig(BoardState[][] scenario, String author, String name) {
        this.scenario = scenario;
        this.author = author;
        this.name = name;
    }

    public boolean isScenarioValid(){
        BoardState[][] var1 = this.scenario;
        int var1Length = var1.length;
        if(var1Length < 8 || var1Length > 20){
            return false;
        }

        for(int i = 0; i < var1Length; i++ ){
            if(var1Length != var1[i].length){
                return false;
            }

            for(int j = 0; j < var1Length; j++){
                if(var1[i][j] == BoardState.WOOD){
                    return false;
                }
            }
        }

        return true;
    }
}
