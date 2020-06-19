package de.hskarlsruhe.vsmb4.gruppe8.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    private Field field = Field.levelOne();


    @Test
    public void getRedCar() {
        assertEquals(3 ,field.getRedCar().getColumn());
    }

    @Test
    public void getCars() {
        assertEquals(3, field.getCars().size());
    }

    @Test
    public void getCarAt() {
        Car redCar= field.getRedCar();
        assertEquals(redCar, field.getCarAt(3,1));
    }

    @Test
    public  void testMove(){
        //Plan wir holen ein existierendes Auto aus dem field
        Car movingCar = field.getCarAt(4,2);
        assertFalse(movingCar.isCovering(4,4));
        field.move(0,0, 5,5);
        assertEquals(movingCar, field.getCarAt(4,4));
    }

    @Test
    public void testFreeCell(){
        assertFalse(field.isFree(-1,2));//außerhalb des Feldes
        assertFalse(field.isFree(7,2));//außerhalb des Feldes
        assertFalse(field.isFree(1,-2));//außerhalb des Feldes
        assertFalse(field.isFree(4,20));//außerhalb des Feldes
        assertFalse(field.isFree(
                field.getRedCar().getColumn(),
                field.getRedCar().getRow()));
        assertTrue(field.isFree(3,0));
    }
}