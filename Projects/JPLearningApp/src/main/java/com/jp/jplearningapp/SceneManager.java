package com.jp.jplearningapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SceneManager {

    private final Stage rootStage;

    private HashMap<String, Scene> scenes;

    public SceneManager(Stage rootStage){
        if(rootStage == null){
            throw new IllegalArgumentException("Your Stage is null");
        }
        this.rootStage = rootStage;
        this.rootStage.setResizable(false);
    }

    public SceneManager(Stage rootStage, HashMap<String, Scene> scenes){
        if(rootStage == null){
            throw new IllegalArgumentException("Your Stage is null");
        }
        this.rootStage = rootStage;
        this.rootStage.setResizable(false);
        this.scenes = scenes;
    }

    public void switchScenes(String scene) {
        rootStage.setScene(scenes.get(scene));
    }
}
