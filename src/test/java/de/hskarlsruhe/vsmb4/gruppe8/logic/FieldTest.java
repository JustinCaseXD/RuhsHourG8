package de.hskarlsruhe.vsmb4.gruppe8.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    private Field field = Field.levelThree();


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
        assertEquals(redCar, field.getCarAt(2,2));
        assertNull(field.getCarAt(1,4));
    }

    @Test
    public  void testMove(){
        Car movingCar = field.getCarAt(1,1);
        assertFalse(movingCar.isCovering(4,4));
        field.move(1,1, 4,1);
        assertNotEquals(movingCar, field.getCarAt(5,1));
        assertEquals(4, movingCar.getEndColumn());
        assertEquals(1 ,movingCar.getEndRow());
    }

    @Test
    public void testisFree(){
        assertFalse(field.isFree(-1,2));//außerhalb des Feldes
        assertFalse(field.isFree(7,2));//außerhalb des Feldes
        assertFalse(field.isFree(1,-2));//außerhalb des Feldes
        assertFalse(field.isFree(4,20));//außerhalb des Feldes
        assertFalse(field.isFree(
                field.getRedCar().getColumn(),
                field.getRedCar().getRow()));
        assertTrue(field.isFree(3,0));
        assertTrue(field.isFree(1,4));
    }
}