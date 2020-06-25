package de.hskarlsruhe.vsmb4.gruppe8;


import de.hskarlsruhe.vsmb4.gruppe8.logic.Car;
import de.hskarlsruhe.vsmb4.gruppe8.logic.Field;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStream;


public class Controller {

    int level;
    private int startColomn;
    private int startRow;
    private int targetColomn;
    private int targetRow;
    static final int CELLSIZE = 70;
    public int playtime;
    public Field field;
    @FXML
    public Pane playPane;
    @FXML
    public Text counter;

    public Controller(){
    }

    public void initialize(int level) {

            if (level == 1) {
                playtime = 60;
            }
            if (level == 2) {
                playtime = 150;
            }
            field = Field.getLevel(level);
            Car redCar = field.getRedCar();
            ObservableList<Node> children = playPane.getChildren();
            playPane.getChildren().add(field.getRedCar());
            playPane.getChildren().addAll(field.getCars());

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("dontleave.wav");
            Sound.sound1(inputStream);
            Sound.play1();
            Sound.loop();

            startTimer();

        }

        private void startTimer () {
            Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (playtime >= 0) {
                        counter.setText(String.valueOf(playtime));
                        playtime--;

                    }
                    if (playtime == 0){
                        lose();
                    }
                }
            }));
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();
        }





    public void pressBack(ActionEvent eventB) throws IOException {

        Sound.stop1();

        Parent back = FXMLLoader.load(getClass().getResource("Startseite.fxml"));
        Scene backs = new Scene(back);
        Stage window = (Stage) ((Node) eventB.getSource()).getScene().getWindow();

        window.setScene(backs);
        window.show();
    }

    public void pressRestart (ActionEvent eventB) throws IOException {

        Sound.stop1();

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

        Sound.stop1();
        InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream("jubel.wav");
        Sound.sound(inputStream2);
        Sound.play();


        ObservableList<Node> children = playPane.getChildren();
        Rectangle recWon = new Rectangle(420, 420);
        Text text = new Text("Du bist ein Gewinnertyp!");

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(this.getClass().getResource("Obama.gif").toExternalForm()));

        playPane.getChildren().add(recWon);
            recWon.setFill(Color.LIGHTGRAY);
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

    public void lose () {
        ObservableList<Node> children = playPane.getChildren();

        Rectangle recLose = new Rectangle(420, 420);
        Text text = new Text("Zeit abgelaufen");
        Text text2 = new Text("versuchs nochmal...");

        /*ImageView imageView2 = new ImageView();
        imageView2.setImage(new Image(this.getClass().getResource("Obama1.gif").toExternalForm()));*/

        Sound.stop1();
        playPane.getChildren().add(recLose);
        recLose.setFill(Color.LIGHTGRAY);
        playPane.getChildren().add(text);
        text.setX(70);
        text.setY(100);
        text.setUnderline(true);
        text.setSelectionFill(Color.WHITE);
        text.setFont(new Font(20));
        playPane.getChildren().add(text2);
        text2.setX(70);
        text2.setY(180);
        text2.setUnderline(true);
        text2.setSelectionFill(Color.WHITE);
        text2.setFont(new Font(20));
        /*playPane.getChildren().add(imageView2);
        imageView2.setX(65);
        imageView2.setY(160);*/

    }

    public void mouseReleased(MouseEvent event) {
        targetRow = getRow(event);
        targetColomn = getColumn(event);
        if (field.move(startColomn, startRow, targetColomn, targetRow)){
            InputStream inputStream3 = getClass().getClassLoader().getResourceAsStream("brumbrum.wav");
            Sound.sound(inputStream3);
            Sound.play();
        }else{
            InputStream inputStream4 = getClass().getClassLoader().getResourceAsStream("hupen.wav");
            Sound.sound(inputStream4);
            Sound.play();
        }
        if (field.isSolved()){
            won();
        }
    }
}






