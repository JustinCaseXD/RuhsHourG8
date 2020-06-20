package de.hskarlsruhe.vsmb4.gruppe8.logic;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {
    private final static int SIZE = 70;
    private int column;
    private int row;
    private final int size;
    private final boolean horizontal;

    public Car(int column, int row, boolean horizontal, int size, Color color){
        super();
        if (horizontal) {
            super.setWidth(size * SIZE);
        }else{
            super.setWidth(SIZE);
        }
        super.setHeight(horizontal ? SIZE : size * SIZE);
        super.setFill(color);
        super.setLayoutX(column * SIZE);
        super.setLayoutY(row * SIZE);
        this.column = column;
        this.row = row;
        this.horizontal = horizontal;
        this.size = size;
    }

    public int getColumn() {
        return column;
    }

    public int getSize() {
        return size;
    }

    public int getRow() {
        return row;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setColumn(int column) {
        if (horizontal) {
            super.setLayoutX(column * SIZE);
            this.column = column;
        }
    }

    public void setRow(int row) {
        if (!horizontal){
            super.setLayoutY(row * SIZE);
            this.row = row;
        }
    }

    public boolean isCovering(int column, int row) {
        if (horizontal){
            return this.row == row && this.column <= column && this.column + size -1 >= column;
        }else{
            return this.column == column && this.row <= row && this.row + size -1 >= row;
        }
    }

    public void move(int targetColumn, int targetRow) {
        setColumn(targetColumn);
        setRow(targetRow);
    }
}
