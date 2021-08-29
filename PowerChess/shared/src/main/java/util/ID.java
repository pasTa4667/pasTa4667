package util;

import enums.IDType;

public class ID {

    private final IDType idType;
    private final int id;


    public ID(int id, IDType type){
        this.id = id;
        this.idType = type;
    }

}
