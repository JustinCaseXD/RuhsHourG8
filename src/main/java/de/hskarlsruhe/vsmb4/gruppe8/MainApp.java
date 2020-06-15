package de.hskarlsruhe.vsmb4.gruppe8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



import static javafx.application.Application.launch;

public class MainApp extends Application {

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        Button btn = new Button();
        btn.setText("Hallo");
        btn.setOnAction((event -> Platform.exit()));
        Pane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root,300,150));
        primaryStage.show();

    }
}
