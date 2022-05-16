package com.jp.jplearningapp.controllers;

import com.jp.jplearningapp.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerPick {

    public Slider levelSlider;
    public ChoiceBox<String> choiceBox;
    public SubScene testSubScene;

    private SceneManager sceneManager;
    private TextFieldManager tfManager;

    private int level = 1;

    public void initialize(){
        ControllerManager.setControllerPick(this);

        this.choiceBox.getItems().add("Kanji");
        this.choiceBox.getItems().add("Vocabs");
        this.choiceBox.getItems().add("Kanji and Vocabs");

        this.levelSlider.showTickLabelsProperty();
        this.levelSlider.showTickMarksProperty();

    }

    @FXML
    private void onDragDone(DragEvent dragEvent) {}

    @FXML
    private void onKeyPressedVBox(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){

            this.level = (int)levelSlider.getValue();
            tfManager = new TextFieldManager(level);
            ControllerManager.getControllerMain().setTextFieldManager(this.tfManager);

            sceneManager.switchScenes("mainScene");
        }
    }

    public void setSceneManager(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public TextFieldManager getTextFieldManager(){
        return tfManager;
    }

}
