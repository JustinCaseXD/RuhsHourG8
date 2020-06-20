package de.hskarlsruhe.vsmb4.gruppe8.logic;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTest {
    @Test
    public void isCovering() {
        Car carH = new Car(3,1,true,3, Color.BLUE);
        Car carV= new Car(5,1,false,5, Color.BLUE);
        assertTrue(carH.isCovering(3,1));
        assertFalse(carV.isCovering(1,3));
        assertFalse(carV.isCovering(5,0));
        assertFalse(carV.isCovering(5,7));
        assertFalse(carV.isCovering(0,0));
        Car testcar = new Car(1,1,false,3,Color.ALICEBLUE);
        assertFalse(testcar.isCovering(1,4));
        }
}