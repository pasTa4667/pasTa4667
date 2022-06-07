package com.jp.jplearningapp.json;

import java.util.List;
import java.util.Objects;

public abstract class Words {

    public String sign;
    public List<String> meanings;
    public int wk_level;
    public Experience experience;

    public Words(){}

    public Words(String sign, List<String> meanings, int wk_level, Experience experience) {
        this.sign = sign;
        this.meanings = meanings;
        this.wk_level = wk_level;
        this.experience = Objects.requireNonNullElse(experience, Experience.Noob);

    }

    public Words(String sign, List<String> meanings, int wk_level){
        this.experience = Experience.Noob;
        this.sign = sign;
        this.meanings = meanings;
        this.wk_level = wk_level;
    }

    public void levelUp(){
        if(this.experience == Experience.GodKing) return;
        this.experience = Experience.intToExp(this.experience.getExpAsInt() + 1);
    }

    public void levelDown(){
        if(this.experience == Experience.Noob) return;
        this.experience = Experience.intToExp(this.experience.getExpAsInt() + 1);
    }

    public void levelReset(){
        if(this.experience == Experience.Noob) return;
        this.experience = Experience.Noob;
    }

}
