package models;

import org.junit.jupiter.api.Test;
import controller.Controller;

import static org.junit.jupiter.api.Assertions.*;

class LagerHyldeTest {

    // ======================================================================
    // getAntalPladser
    // ======================================================================

    @Test
    void getAntalPladser() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        int actual = testLager.getReoler()[0].getHylder()[0].getAntalPladser();
        // Assert
        assertEquals(2, actual);
    }

    // ======================================================================
    // isEmpty
    // ======================================================================

    @Test
    void isNotEmpty() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 0, 0, 1);
        // Assert
        assertFalse(testLager.getReoler()[0].getHylder()[0].isEmpty());
    }

    @Test
    void isEmpty() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        // Assert
        assertTrue(testLager.getReoler()[0].getHylder()[0].isEmpty());
    }
}