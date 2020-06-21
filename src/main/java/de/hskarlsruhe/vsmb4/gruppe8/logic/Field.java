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

    public static Field getLevel(int l){
        if (l == 1 ){
            return  levelOne();
        }
        if (l == 2){
            return levelTwo();
        }
        if (l == 3){
            return  levelThree();
        }
        if (l == 4){
           return levelFour();
        }else{
            return levelOne();
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
        List<Car> newcars = new ArrayList<>();
        newcars.add(new Car(0,0,false,2,WHITE));
        newcars.add(new Car(0,5,true,2,PINK));
        newcars.add(new Car(2,1,true,3,LAVENDER));
        newcars.add(new Car(5,0,false,2,GREY));
        newcars.add(new Car(2,2,false,2,DARKBLUE));
        newcars.add(new Car(4,2,false,2,DARKGREEN));
        newcars.add(new Car(5,2,false,3,LIGHTBLUE));
        newcars.add(new Car(1,4,true,2,ORANGE));
        newcars.add(new Car(3,4,true,2,LIGHTGRAY));
        newcars.add(new Car(3,5,true,3,YELLOW));
        return new Field(new Car(0,2,true,2,RED),newcars);
        }

    public static Field levelThree(){
        List<Car> newcars = new ArrayList<>();
        return  new Field(new Car(1,1,true,3, RED), newcars);
    }

    public static Field levelFour(){
        List<Car> newcars = new ArrayList<>();
        newcars.add(new Car(0,1,false,3, YELLOW));
        newcars.add(new Car(1,0,true,2,LIGHTGREEN));
        newcars.add(new Car(3,0,false,3,LIGHTCORAL));
        newcars.add(new Car(2,4,false,2,ORANGE));
        newcars.add(new Car(3,3,true,3,DARKBLUE));
        newcars.add(new Car(5,1,false,2,DARKVIOLET));
        newcars.add(new Car(3,5,true,3,LIGHTBLUE));
        return new Field(new Car(1,2,true,2,RED),newcars);
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
    public boolean isSolved(){
        return getRedCar().isCovering(5,2);
    }

    public boolean move(int startColumn, int startRow, int targetColumn, int targetRow) {

        boolean move = false;
        boolean verticalpositiv = false;
        boolean horizontalpositiv = false;
        int stepsX ;
        int stepsY;
        int checkColumn;
        int checkRow;
        int finalTagetColumn;
        int finalTargetRow;
        Car movingCar = getCarAt(startColumn, startRow);
        int step;

        if (movingCar != null) {

            if (startColumn - targetColumn < 0) {
                horizontalpositiv = true;
            }
            if (startColumn - targetColumn == 0 && movingCar.isHorizontal()) {
                return move;
            } else {
            }

            if (startRow - targetRow < 0) {
                verticalpositiv = true;
            }
            if (startRow - targetRow == 0 && !movingCar.isHorizontal()) {
                return move;
            } else {
            }

            if (movingCar.isHorizontal()) {

                finalTargetRow = startRow;

                if (horizontalpositiv) {
                    stepsX = targetColumn - movingCar.getEndColumn();
                } else {
                    stepsX = targetColumn - movingCar.getColumn();
                }
                if (stepsX == 0) {
                    return move;
                }
                step = stepsX / Math.abs(stepsX);


                for (int i = 1; i <= Math.abs(stepsX); i++) {
                    if (step < 0) {
                        checkColumn = movingCar.getColumn() + step;
                    } else {
                        checkColumn = movingCar.getColumn() + movingCar.getSize() - 1 + step;
                    }
                    if (isFree(checkColumn, finalTargetRow)) {
                        movingCar.move(movingCar.getColumn() + step, finalTargetRow);
                        move = true;
                    } else {
                        return move;
                    }
                }
            } else {
                if (verticalpositiv) {
                    stepsY = targetRow - movingCar.getEndRow();
                } else {
                    stepsY = targetRow - movingCar.getRow();
                }
                finalTagetColumn = startColumn;
                if (stepsY == 0) {
                    return move;
                }
                step = stepsY / Math.abs(stepsY);

                for (int i = 1; i <= Math.abs(stepsY); i++) {
                    if (step < 0) {
                        checkRow = movingCar.getRow() + step;
                    } else {
                        checkRow = movingCar.getRow() + movingCar.getSize() - 1 + step;
                    }
                    if (isFree(finalTagetColumn, checkRow)) {
                        movingCar.move(finalTagetColumn, movingCar.getRow() + step);
                        move = true;
                    } else {
                        return move;
                    }
                }
            }

        }
        return move;
    }

    public boolean isFree(int column, int row) {
        return (getCarAt(column, row)== null && column >=0 && column <= MAX_COLUMN && row >= 0 && row <= MAX_ROW );
    }
}
