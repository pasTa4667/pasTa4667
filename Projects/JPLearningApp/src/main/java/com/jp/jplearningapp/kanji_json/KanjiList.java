package com.jp.jplearningapp.kanji_json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KanjiList {

        private List<Kanji> allKanji;

        public KanjiList(){}

        public KanjiList(List<Kanji> kanjiList){
                this.allKanji = kanjiList;
        }

        //returns list with kanji from that level
        public List<Kanji> getLevelList(int level){
                if(level < 1 || level > 60) throw new IndexOutOfBoundsException();

                List<Kanji> levelList = new ArrayList<>();

                for (Kanji kanji: allKanji) {
                        if(kanji.wk_level == level) levelList.add(kanji);
                }
                return levelList;
        }

        public List<Kanji> getShuffledList(int level){
                List<Kanji> shuffledList = this.getLevelList(level);
                Collections.shuffle(shuffledList);
                return shuffledList;
        }


        public Kanji getRdmKanjiFromLevel(int level){
                List<Kanji> list = this.getLevelList(level);
                int rdm = (int)(Math.random() * list.size());
                return list.get(rdm);
        }

        public List<Kanji> getAllKanji(){
                return allKanji;
        }

}
