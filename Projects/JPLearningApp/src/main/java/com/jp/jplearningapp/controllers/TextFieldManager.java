package com.jp.jplearningapp.controllers;

import com.jp.jplearningapp.json.WordList;
import com.jp.jplearningapp.json.kanji.Kanji;
import com.jp.jplearningapp.json.kanji.KanjiReader;
import com.jp.jplearningapp.json.vocab.VocabReader;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.List;

public class TextFieldManager {


    private TextField meaningTF, onyomiTF, kunyomiTF;
    private Text promptText;
    private Text meaningCorr, onyomiCorr, kunyomiCorr;

    //stuff to iterate over the list
    private KanjiReader kReader;
    private VocabReader vReader;
    private WordList wordList;
    private int listPos = 0;
    private List levelList;
    private Kanji current = null;

    ControllerMain controllerMain;


    public TextFieldManager(int level, String choice){
        this.controllerMain = ControllerManager.getControllerMain();
        this.meaningCorr = controllerMain.meaningCorr;
        this.onyomiCorr = controllerMain.onyomiCorr;
        this.kunyomiCorr = controllerMain.kunyomiCorr;
        this.promptText = controllerMain.promptText;
        this.meaningTF = controllerMain.meaningTF;
        this.onyomiTF = controllerMain.onyomiTF;
        this.kunyomiTF = controllerMain.kunyomiTF;

        //focus traversable with Tab
        meaningTF.requestFocus();
        meaningTF.setFocusTraversable(true);
        onyomiTF.setFocusTraversable(true);
        kunyomiTF.setFocusTraversable(true);

        switch(choice){
            case "Kanji" :
                kReader = new KanjiReader();
                wordList = kReader.getKanjis();
                levelList = wordList.getShuffledList(level);
            case "Vocabs" :
                vReader = new VocabReader();
                wordList = vReader.getVocabList();
                levelList = wordList.getShuffledList(level);
            case "Kanji and Vocabs" :
                //TODO: do both
        }


        this.changePrompt();
    }

    public void resetTexts(){
        onyomiCorr.setText("");
        kunyomiCorr.setText("");
        onyomiTF.setText("");
        kunyomiTF.setText("");
        meaningCorr.setText("");
        meaningTF.setText("");
    }

    public boolean allCorrect(){
        if(!meaningTF.getText().equals("正")) return false;
        if(!onyomiTF.getText().equals("正") || onyomiTF.getText().equals("存在しない")) return false;
        return kunyomiTF.getText().equals("正") || kunyomiTF.getText().equals("存在しない");
    }

    //matches tf input with kanji
    public void matchTFInput(Object obj){
        if(obj.equals(this.meaningTF)){
            if(current.wk_meanings.contains(meaningTF.getText())){
                meaningTF.setText("正");
            }else{
                current.levelDown();
                this.meaningCorr.setText(current.wk_meanings.toString());
            }
        }else if(obj.equals(this.onyomiTF)){
            if(current.wk_readings_on.contains(onyomiTF.getText())){
                onyomiTF.setText("正");
            }else{
                current.levelDown();
                onyomiCorr.setText(current.wk_readings_on.toString());
            }
        }else if(obj.equals(this.kunyomiTF)) {
            if (current.wk_readings_kun.contains(kunyomiTF.getText())) {
                kunyomiTF.setText("正");
            } else {
                current.levelDown();
                kunyomiCorr.setText(current.wk_readings_kun.toString());
            }
        }
    }

    //changes prompt to random kanji
    public void changePrompt(){
        if(listPos < levelList.size()){
            current = (Kanji)levelList.get(listPos++);
            promptText.setText(current.sign);
            this.resetTexts();
            if(current.wk_readings_on.isEmpty()) onyomiTF.setText("存在しない");
            if(current.wk_readings_kun.isEmpty()) kunyomiTF.setText("存在しない");
        }else {
            this.resetTexts();
            promptText.setText("すべて完了");
        }
    }

    public WordList getKanjiList() {
        return wordList;
    }

    public List<Kanji> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Kanji> levelList) {
        this.levelList = levelList;
    }

    public Kanji getCurrent() {
        return current;
    }

    public void setCurrent(Kanji current) {
        this.current = current;
    }
}
