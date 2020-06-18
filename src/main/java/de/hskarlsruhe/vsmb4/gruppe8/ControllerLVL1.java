package de.hskarlsruhe.vsmb4.gruppe8;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerLVL1 {


    public void pressBack(ActionEvent eventB) throws IOException {

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage) ((Node) eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }


    @FXML
    private Pane playPane;
    @FXML
    private Rectangle rct_red1, rct_dblue1, rct_yellow1, rct_bgreen1,
            rct_white1, rct_orange1, rct_dgreen1, rct_bblue1;


    public void dragVertical(MouseEvent event) {


        if (event.getButton() == MouseButton.PRIMARY) {
            Node n = (Node) event.getSource();
            n.setTranslateY(n.getTranslateY() + 70);
        }

        if (event.getButton() == MouseButton.SECONDARY) {
            Node n = (Node) event.getSource();
            n.setTranslateY(n.getTranslateY() - 70);
        }
    }

    public void dragHorizontal(MouseEvent event) {

        if (event.getButton() == MouseButton.PRIMARY) {
            Node n = (Node) event.getSource();
            n.setTranslateX(n.getTranslateX() - 70);
        }

        if (event.getButton() == MouseButton.SECONDARY) {
            Node n = (Node) event.getSource();
            n.setTranslateX(n.getTranslateX() + 70);
        }

    }


    public void moveBlocks(MouseEvent event) {



        Bounds rct_red1_bounds = rct_red1.getBoundsInParent();
        Bounds rct_dblue1_bounds = rct_dblue1.getBoundsInParent();
        Bounds rct_bblue1_bounds = rct_bblue1.getBoundsInParent();

        Node n = (Node) event.getSource();

        if (rct_red1_bounds.intersects(rct_dblue1_bounds)) {
            n.setTranslateX(n.getTranslateX() - 70);
        }

        if (rct_red1_bounds.intersects(rct_bblue1_bounds)) {
            n.setTranslateX(n.getTranslateX() + 70);
        }


        else {
            dragHorizontal(event);
        }

    }

}






