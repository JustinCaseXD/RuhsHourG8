
package de.hskarlsruhe.vsmb4.gruppe8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainApp extends Application {

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {

        Parent root = null;
        try {

       root = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("Rush Hour");

        primaryStage.show();

    }
}
