package de.hskarlsruhe.vsmb4.gruppe8;


import de.hskarlsruhe.vsmb4.gruppe8.logic.Car;
import de.hskarlsruhe.vsmb4.gruppe8.logic.Field;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerLVL1 {

    private int startColomn;
    private int startRow;
    static final int CELLSIZE = 70;
    @FXML
    public Pane playPane;
    @FXML
    private Rectangle rct_red1, rct_dblue1, rct_yellow1, rct_bgreen1,
            rct_white1, rct_orange1, rct_dgreen1, rct_bblue1;
    private Field field;

    public ControllerLVL1(){
       System.out.println("controller1 c'tor");

    }

    public void initialize(){
        field = Field.getLevel(1);

        System.out.println("initialize " + playPane);
        Car redCar = field.getRedCar();
        System.out.println("redCat " + redCar );
        System.out.println("playPane " + playPane);
        ObservableList<Node> children = playPane.getChildren();
        System.out.println("children "+ children);
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

        if (rct_red1_bounds.intersects(rct_dblue1_bounds)) {
            Node n = (Node) event.getSource();
            n.setTranslateX(n.getTranslateX() -70);
        }

        if (rct_red1_bounds.intersects(rct_bblue1_bounds)) {
            Node n = (Node) event.getSource();
            n.setTranslateX(n.getTranslateX() +70);
        }

        else {
            dragHorizontal(event);

        }
    }

    public void dragDetected(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        System.out.println("dragDetected "+ node);
    }

    public void dragEntered(DragEvent dragEvent) {
        Node node = (Node) dragEvent.getSource();
        System.out.println("dragEntered "+ node);
    }

    public void dragAny(DragEvent dragEvent) {
        Node node = (Node) dragEvent.getSource();
        EventType<DragEvent> type = dragEvent.getEventType();
        System.out.println("dragAny " + node + " type: " + type);
    }

    public void mousePressed(MouseEvent event) {
        startRow = getRow(event);
        startColomn = getColumn(event);
    }

    public void mouseReleased(MouseEvent event) {
        int targetRow = getRow(event);
        int targetColumn = getColumn(event);
        field.move(startColomn, startRow, targetColumn, targetRow);
    }
}






