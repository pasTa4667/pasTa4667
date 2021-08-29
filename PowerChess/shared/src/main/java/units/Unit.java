package units;

import enums.UnitType;
import util.ID;

public abstract class Unit {

    private String name;
    private ID id;

    protected Unit(ID id, String name){
        this.name = name;
        this.id = id;
    }

}
