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


public class ControllerLVL2 {

    public int level;
    private int startColomn;
    private int startRow;
    private int targetColomn;
    private int targetRow;
    static final int CELLSIZE = 70;
    @FXML
    public Pane playPane2;
    //public text counter;
    private Field field;

    public ControllerLVL2(){
    }

    public void initialize(){
        field = Field.getLevel(2);
        //System.out.println(level);
        Car redCar = field.getRedCar();
        ObservableList<Node> children = playPane2.getChildren();
        playPane2.getChildren().add(field.getRedCar());
        playPane2.getChildren().addAll(field.getCars());
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






