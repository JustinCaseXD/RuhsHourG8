package de.hskarlsruhe.vsmb4.gruppe8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Node; 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.shape.Shape;

public class ControllerLVL1 {

    public void pressBack (ActionEvent eventB) throws IOException {

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage)((Node)eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }


    public void dragVertical (MouseEvent event) {
        Node n = (Node)event.getSource();
        n.setTranslateY(n.getTranslateY() + event.getY());
    }

    public void dragHorizontal (MouseEvent event) {
        Node n = (Node)event.getSource();
        n.setTranslateX(n.getTranslateX() + event.getX());
    }


}




