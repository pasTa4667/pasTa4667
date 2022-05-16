package com.jp.jplearningapp;

import com.jp.jplearningapp.controllers.ControllerManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Application extends javafx.application.Application {

    final int WIDTH = 640;
    final int HEIGHT = 400;
    private final HashMap<String, Scene> scenes = new HashMap<>();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader pickLoader = new FXMLLoader(Application.class.getResource("LearningJP_Pick.fxml"));
        Scene pickScene = new Scene(pickLoader.load(), WIDTH, HEIGHT);


        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LearningJP_Scene.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);

        stage.setResizable(false);
        stage.setTitle("My Wanikani");
        stage.setScene(pickScene);

        stage.show();

        scenes.put("pickScene", pickScene);
        scenes.put("mainScene", mainScene);
        SceneManager sceneManager = new SceneManager(stage, scenes);

        ControllerManager.getControllerPick().setSceneManager(sceneManager);

    }

    public static void main(String[] args) {
        launch();
    }
}