package com.jp.jplearningapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class ControllerMain {

    public MenuBar menu;
    public MenuItem quit, _new, level_one, level_two, level_three, level_four, level_five, level_six;
    public TextField meaningTF, onyomiTF, kunyomiTF;
    public Text meaningLabel, onyomiLabel, kunyomiLabel, promptText;
    public Text meaningCorr, onyomiCorr, kunyomiCorr;

    TextFieldManager tfManager;

    public void initialize(){
        ControllerManager.setControllerMain(this);
    }

    @FXML
    private void onKeyPressedTextFields(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            Object obj = keyEvent.getSource();

            if(!tfManager.allCorrect()){
                tfManager.matchTFInput(obj);
            }else tfManager.changePrompt();
        }
    }

    @FXML
    private void onActionLevel(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(level_one)){
            tfManager.setLevelList(tfManager.getKanjiList().getShuffledList(1));
            tfManager.changePrompt();
        }
    }

    @FXML
    private void onActionQuit(ActionEvent actionEvent) {
    }

    @FXML
    private void onActionTextFields(ActionEvent actionEvent) {
    }

    @FXML
    private void onActionNew(ActionEvent actionEvent) {tfManager.changePrompt();}


    public void setTextFieldManager(TextFieldManager tfManager){
        this.tfManager = tfManager;
    }



}