package com.jp.jplearningapp.controllers;

import javafx.fxml.FXMLLoader;

public class ControllerManager {

    private static ControllerMain controllerMain;
    private static ControllerPick controllerPick;

    public static ControllerMain getControllerMain(){
        return controllerMain;
    }

    public static void setControllerMain(ControllerMain controllerMain){
        ControllerManager.controllerMain = controllerMain;
    }

    public static void setControllerMain(FXMLLoader controllerLoader){
        ControllerManager.controllerMain = controllerLoader.getController();
    }

    public static ControllerPick getControllerPick(){
        return controllerPick;
    }

    public static void setControllerPick(ControllerPick controllerPick){
        ControllerManager.controllerPick = controllerPick;
    }

    public static void setControllerPick(FXMLLoader controllerLoader){
        ControllerManager.controllerPick = controllerLoader.getController();
    }
}
