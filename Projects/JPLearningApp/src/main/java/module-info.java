module com.jp.jplearningapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;

    opens com.jp.jplearningapp to javafx.fxml;
    exports com.jp.jplearningapp;
    exports com.jp.jplearningapp.controllers;
    opens com.jp.jplearningapp.controllers to javafx.fxml;

}