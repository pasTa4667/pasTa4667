package com.jp.jplearningapp.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordList<T extends Words> {

    private List<T> allWords;

    public WordList(List<T> allWords){
        this.allWords = allWords;
    }

    //returns list with Words from that level
    public List<T> getLevelList(int level){
        if(level < 1 || level > 60) throw new IndexOutOfBoundsException();

        List<T> levelList = new ArrayList<>();

        for (T word: allWords) {
            if(word.wk_level == level) levelList.add(word);
        }
        return levelList;
    }

    //returns shuffled list of a level
    public List<T> getShuffledList(int level){
        List<T> shuffledList = this.getLevelList(level);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }

    //returns one random word from a level
    public T getRdmFromLevel(int level){
        List<T> list = this.getLevelList(level);
        int rdm = (int)(Math.random() * list.size());
        return list.get(rdm);
    }

    public List<T> getAllWords(){
        return allWords;
    }

}
