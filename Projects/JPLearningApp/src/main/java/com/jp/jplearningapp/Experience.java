package com.jp.jplearningapp;

public enum Experience {

    Noob(0),
    Apprentice(1),
    Guru(2),
    Expert(3),
    Master(4),
    Enlightened(5),
    Ascended(6),
    GodKing(7);
    
    private final int expAsInt;
    
    Experience(int expAsInt){
        this.expAsInt = expAsInt;
    }

    public int getExpAsInt(){
        return expAsInt;
    }

    public static Experience intToExp(int i){
        return switch (i) {
            case 0 -> Noob;
            case 1 -> Apprentice;
            case 2 -> Guru;
            case 3 -> Expert;
            case 4 -> Master;
            case 5 -> Enlightened;
            case 6 -> Ascended;
            case 7 -> GodKing;
            default -> null;
        };
    }
    
}
