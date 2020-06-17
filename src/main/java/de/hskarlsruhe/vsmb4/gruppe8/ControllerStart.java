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

public class ControllerStart {

    public void checkboxHandler (ActionEvent event){

    }

    public void pressStart1 (ActionEvent eventS) throws IOException{

            Parent start1 = FXMLLoader.load(getClass().getResource("SpielfeldEins.fxml"));
            Scene field1 = new Scene(start1);
            Stage window = (Stage)((Node)eventS.getSource()).getScene().getWindow();

            window.setScene(field1);
            window.show();
        }

    public void pressStart2 (ActionEvent eventS) throws IOException{

        Parent start2 = FXMLLoader.load(getClass().getResource("SpielfeldZwei.fxml"));
        Scene field2 = new Scene(start2);
        Stage window = (Stage)((Node)eventS.getSource()).getScene().getWindow();

        window.setScene(field2);
        window.show();
    }

        public void pressRules (ActionEvent eventR) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("Regeln.fxml"));
        Scene rule = new Scene(rules);
        Stage window = (Stage)((Node)eventR.getSource()).getScene().getWindow();

            window.setScene(rule);
            window.show();
        }

        public void pressImprint (ActionEvent eventI) throws IOException{
        Parent imprint = FXMLLoader.load(getClass().getResource("Impressum.fxml"));
        Scene imprints = new Scene(imprint);
        Stage window = (Stage)((Node)eventI.getSource()).getScene().getWindow();

        window.setScene(imprints);
        window.show();
    }

        public void pressOptions (ActionEvent eventO) throws IOException{
        Parent option = FXMLLoader.load(getClass().getResource("Optionen.fxml"));
        Scene options = new Scene(option);
        Stage window = (Stage)((Node)eventO.getSource()).getScene().getWindow();

        window.setScene(options);
        window.show();
    }



}