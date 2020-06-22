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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    int level;
    private int startColomn;
    private int startRow;
    private int targetColomn;
    private int targetRow;
    static final int CELLSIZE = 70;
    @FXML
    public Pane playPane;
    //public text counter;
    public Field field;
    String filepath = "C:\\Users\\Kai\\Desktop\\Studium\\RushHourG8\\dontleave.wav";


    public Controller(){
    }

    public void initialize(int level){
        field = Field.getLevel(3);
        //System.out.println(level);
        Car redCar = field.getRedCar();
        ObservableList<Node> children = playPane.getChildren();
        playPane.getChildren().add(field.getRedCar());
        playPane.getChildren().addAll(field.getCars());

       /* Sound musicObject = new Sound();
        musicObject.playMusic(filepath); */
        new Sound(filepath);
        Sound.play();
        Sound.loop();




    }

    public void pressBack(ActionEvent eventB) throws IOException {

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage) ((Node) eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }

    public void pressRestart (ActionEvent eventB) throws IOException {

        Sound.stop();

        level = ControllerStart.getLevel();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpielfeldEins.fxml"));
        Parent start1 = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.initialize(level);
        Scene field1 = new Scene(start1);
        Stage window = (Stage)((Node)eventB.getSource()).getScene().getWindow();
        window.setScene(field1);
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

    public void won () {

        Sound.stop();
        String filepath = "C:\\Users\\Kai\\Desktop\\Studium\\RushHourG8\\jubel.wav";
        new Sound(filepath);
        Sound.play();

        ObservableList<Node> children = playPane.getChildren();
        Rectangle gewonnen = new Rectangle(420, 420);
        Text text = new Text("Du bist ein Gewinnertyp!");

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(this.getClass().getResource("Obama.gif").toExternalForm()));

        playPane.getChildren().add(gewonnen);
            gewonnen.setFill(Color.LIGHTGRAY);
        playPane.getChildren().add(text);
            text.setX(105);
            text.setY(100);
            text.setUnderline(true);
            text.setSelectionFill(Color.WHITE);
            text.setFont(new Font(20));
        playPane.getChildren().add(imageView);
            imageView.setX(65);
            imageView.setY(160);

    }

    public void mouseReleased(MouseEvent event) {
        targetRow = getRow(event);
        targetColomn = getColumn(event);
        if (field.move(startColomn, startRow, targetColomn, targetRow)){
        //    counter ++;
        }
        if (field.isSolved()){
            won();
        }
    }
}






