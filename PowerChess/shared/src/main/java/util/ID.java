package util;

import enums.IDType;

public class ID {

    private IDType idType;
    private int id;


    public ID(int id, IDType type){
        this.id = id;
        this.idType = type;
    }

    public IDType getType() {
        return idType;
    }

    public int getId() {
        return id;
    }

}
