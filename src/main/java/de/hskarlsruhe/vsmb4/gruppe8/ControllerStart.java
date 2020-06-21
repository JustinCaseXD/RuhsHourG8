package de.hskarlsruhe.vsmb4.gruppe8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerStart {

    public static int level;
    public void checkboxHandler (ActionEvent event){

    }

    public int pressStart1 (ActionEvent eventS) throws IOException{
            level = 1;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpielfeldEins.fxml"));
                        Parent start1 = fxmlLoader.load();
                        Controller controller = fxmlLoader.getController();
                        controller.initialize(level);
                        Scene field1 = new Scene(start1);
                        Stage window = (Stage)((Node)eventS.getSource()).getScene().getWindow();



            window.setScene(field1);
            window.show();
            return level;
        }

    public int pressStart2 (ActionEvent eventS) throws IOException{
            level = 2;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpielfeldEins.fxml"));
            Parent start1 = fxmlLoader.load();
            Controller controller = fxmlLoader.getController();
            controller.initialize(level);
            Scene field1 = new Scene(start1);
            Stage window = (Stage)((Node)eventS.getSource()).getScene().getWindow();



        window.setScene(field1);
        window.show();
    return level;
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


    public static int getLevel() {
        return level;
    }
}
