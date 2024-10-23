package com.example.javafxworkshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HelloController helloController = new HelloController();
        BorderPane root = helloController.getRoot(); //panes used in every application
        //create a scene
        Scene scene = new Scene(root,600,400); //always pass the layout to the scene (borderpane)
        //set the scene on the primary stage
        stage.setScene(scene);
        //show the new stage
        stage.setTitle("Dylan's Portfolio");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
