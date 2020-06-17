package de.hskarlsruhe.vsmb4.gruppe8;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerRules {

    public void pressBack (ActionEvent eventB) throws IOException{

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage)((Node)eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }

}