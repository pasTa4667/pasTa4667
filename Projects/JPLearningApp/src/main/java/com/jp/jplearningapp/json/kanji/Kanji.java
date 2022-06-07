package com.jp.jplearningapp.json.kanji;

import com.jp.jplearningapp.json.Experience;
import com.jp.jplearningapp.json.Words;

import java.util.List;

public class Kanji extends Words {

    public List<String> readings_on, readings_kun;
    public List<String> wk_readings_on, wk_readings_kun, wk_meanings, wk_radicals;
    //not used
    public int jlpt_old, jlpt_new, strokes, grade, freq;


    public Kanji(){}

    public Kanji(String sign, List<String> readings_on, List<String> readings_kun, List<String> meanings, Experience experience,
                 List<String> wk_readings_on, List<String> wk_readings_kun, List<String> wk_meanings,
                 List<String> wk_radicals, int wk_level, int strokes, int grade, int freq, int jlpt_old, int jlpt_new) {
        super(sign, meanings, wk_level, experience);
        this.readings_on = readings_on;
        this.readings_kun = readings_kun;
        this.wk_readings_on = wk_readings_on;
        this.wk_readings_kun = wk_readings_kun;
        this.wk_meanings = wk_meanings;
        this.wk_radicals = wk_radicals;
        this.strokes = strokes;
        this.grade = grade;
        this.freq = freq;
        this.jlpt_old = jlpt_old;
        this.jlpt_new = jlpt_new;
    }


}
