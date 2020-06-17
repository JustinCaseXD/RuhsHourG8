package de.hskarlsruhe.vsmb4.gruppe8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLVL2 {

    public void pressBack (ActionEvent eventB) throws IOException {

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage)((Node)eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }
}
