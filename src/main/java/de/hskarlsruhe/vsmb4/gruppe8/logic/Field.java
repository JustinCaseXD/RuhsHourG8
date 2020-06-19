package de.hskarlsruhe.vsmb4.gruppe8.logic;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;

public class Field {
    public static  final int MAX_COLUMN = 5;
    private static final int MAX_ROW = 5;
    private List<Car> cars;
    private Car redCar;
    private List<Car> allCars;

    public Field(Car redCar, List<Car> cars) {
        this.redCar = redCar;
        this.cars = cars;
        this.allCars = new ArrayList<>();
        this.allCars.add(redCar);
        this.allCars.addAll(cars);
    }
    public static int getFour(){
        return 4;
    }
    public static Field getLevel(int l){
        if (l == 1 ){
            return  levelOne();
        }else{
            return  levelTwo();
        }
    }

    public static Field levelOne(){
        List<Car> newcars = new ArrayList<>();
        newcars.add(new Car(1,1,false, 3, LIGHTBLUE));
        newcars.add(new Car(2,1,true, 3, WHITE));
        newcars.add(new Car(5,0,false, 2, GREEN));
        newcars.add(new Car(4,2,false, 2, DARKBLUE));
        newcars.add(new Car( 0, 5,true, 2, ORANGE));
        newcars.add(new Car(2,4,false, 2, LIGHTGREEN));
        newcars.add(new Car(3,4,true, 3, YELLOW));
        return  new Field(new Car(2,2,true,2, RED), newcars);
    }
    public static Field levelTwo(){
        return null;
    }

    public Car getRedCar(){
        return redCar;
    }
    public List<Car> getCars(){
        return cars;
    }

    public Car getCarAt(int column, int row){
        for (Car car : allCars) {
            if (car.isCovering(column, row)){
                return car;
            }
        }
        return null;
    }


    public void move(int startColomn, int startRow, int targetColumn, int targetRow) {

        Car movingCar = getCarAt(startColomn, startRow);

        if(movingCar != null) { //teste ob das geht Kolision etc.)
            // ist da ein auto
            //welche Ausrichtung hat es
            // aus dem Mouse Vector start -> Target den reinen x bzw y vector bilden
            // in einzelschritten in dieser richtung jedes Feld hinter /bzw vor dem Auto testen field.isFree()
            // in diese richtung ein schritt fahren
            // bis Target errreicht oder Kolision oder Spielfeldrand
            int finalTagetColumn = 4; //TODO das ist nicht wirklich 4
            int finalTargetRow = 2;
            movingCar.move(finalTagetColumn, finalTargetRow);
        }
    }

    public boolean isFree(int column, int row) {
        return (getCarAt(column, row)== null && column >=0 && column <= MAX_COLUMN && row >= 0 && row <= MAX_ROW );
    }
}
