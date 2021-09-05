package configuration;

import enums.BoardState;

public class ScenarioConfig {

    public final BoardState[][] scenario;
    private String author;
    private String name;

    public ScenarioConfig(BoardState[][] scenario, String author, String name) {
        this.scenario = scenario;
        this.author = author;
        this.name = name;
    }

    public boolean isScenarioValid(){
        BoardState[][] var1 = this.scenario;
        int var1Length = var1.length;
        int var2 = 2;
        int var3 = var1Length - var2;

        if(var1Length < 8 || var1Length > 20){
            return false;
        }

        for(int i = 0; i < var1Length; i++ ){
            if(var1Length != var1[i].length){
                return false;
            }

            for(int j = 0; j < var2; j++){
                if(var1[j][i] == BoardState.WOOD){
                    return false;
                }
            }

            for(int j = var1Length; j > var3; j--){
                if(var1[j][i] == BoardState.WOOD){
                    return false;
                }
            }
        }

        return true;
    }
}
