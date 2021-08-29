package units;

import enums.UnitType;
import util.ID;

public abstract class Unit {

    private UnitType type;
    private ID id;

    protected Unit(ID id, UnitType type){
        this.id = id;
    }

}
