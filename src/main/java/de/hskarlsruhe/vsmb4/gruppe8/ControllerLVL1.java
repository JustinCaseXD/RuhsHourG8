package de.hskarlsruhe.vsmb4.gruppe8;


import de.hskarlsruhe.vsmb4.gruppe8.logic.Car;
import de.hskarlsruhe.vsmb4.gruppe8.logic.Field;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerLVL1 {

    private int startColomn;
    private int startRow;
    private int targetColomn;
    private int targetRow;
    static final int CELLSIZE = 70;
    @FXML
    public Pane playPane;
    //public text counter;
    private Field field;

    public ControllerLVL1(){
    }

    public void initialize(){
        field = Field.getLevel(1);
        Car redCar = field.getRedCar();
        ObservableList<Node> children = playPane.getChildren();
        playPane.getChildren().add(field.getRedCar());
        playPane.getChildren().addAll(field.getCars());
    }

    public void pressBack(ActionEvent eventB) throws IOException {

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage) ((Node) eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }

    public void pressRestart (ActionEvent eventB) throws IOException {

        Parent back = FXMLLoader.load(getClass().getResource("SpielfeldEins.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage) ((Node) eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }

    public int getRow(MouseEvent event) {

        return (int) (event.getSceneY() / CELLSIZE)  ;
    }
    public int getColumn(MouseEvent event) {

        return (int) (event.getSceneX() / CELLSIZE)  ;
    }

    public void mousePressed(MouseEvent event) {
        startRow = getRow(event);
        startColomn = getColumn(event);
    }

    public void mouseReleased(MouseEvent event) {
        targetRow = getRow(event);
        targetColomn = getColumn(event);
        if (field.move(startColomn, startRow, targetColomn, targetRow)){
        //    counter ++;
        }
        if (field.isSolved()){
            //hier soll was passieren
        }
    }
}






