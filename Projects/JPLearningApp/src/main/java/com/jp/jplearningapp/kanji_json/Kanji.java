package com.jp.jplearningapp.kanji_json;

import com.jp.jplearningapp.Experience;

import java.util.List;

public class Kanji {

    public String sign;
    public List<String> readings_on, readings_kun, meanings;
    public List<String> wk_readings_on, wk_readings_kun, wk_meanings, wk_radicals;
    public int wk_level, strokes, grade, freq;
    public Experience experience = Experience.Noob;
    //not used
    public int jlpt_old, jlpt_new;


    public Kanji(){}

    public Kanji(String sign, List<String> readings_on, List<String> readings_kun, List<String> meanings, Experience experience,
                 List<String> wk_readings_on, List<String> wk_readings_kun, List<String> wk_meanings,
                 List<String> wk_radicals, int wk_level, int strokes, int grade, int freq, int jlpt_old, int jlpt_new) {
        this.sign = sign;
        this.readings_on = readings_on;
        this.readings_kun = readings_kun;
        this.meanings = meanings;
        this.experience = experience;
        this.wk_readings_on = wk_readings_on;
        this.wk_readings_kun = wk_readings_kun;
        this.wk_meanings = wk_meanings;
        this.wk_radicals = wk_radicals;
        this.wk_level = wk_level;
        this.strokes = strokes;
        this.grade = grade;
        this.freq = freq;
        this.jlpt_old = jlpt_old;
        this.jlpt_new = jlpt_new;
    }

    public void levelUp(){
        if(this.experience == Experience.GodKing) return;
        this.experience = Experience.intToExp(this.experience.getExpAsInt() + 1);
    }

    public void levelDown(){
        if(this.experience == Experience.Noob) return;
        this.experience = Experience.intToExp(this.experience.getExpAsInt() + 1);
    }

}
