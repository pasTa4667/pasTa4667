package com.jp.jplearningapp.json.vocab;

import com.jp.jplearningapp.json.Experience;
import com.jp.jplearningapp.json.Words;

import java.util.List;

public class Vocab extends Words {

    public List<String> readings;

    public Vocab(){}

    public Vocab(String sign, List<String> meanings, List<String> readings, int wk_level, Experience experience){
        super(sign, meanings, wk_level, experience);
        this.readings = readings;
    }
}
