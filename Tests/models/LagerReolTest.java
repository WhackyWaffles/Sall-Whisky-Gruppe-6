package models;

import controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerReolTest {

    // ======================================================================
    // AntalHylder
    // ======================================================================

    @Test
    void getAntalHylder() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4, 2);
        // Act
        int actual = testLager.getReoler()[0].getAntalHylder();
        // Assert
        assertEquals(4, actual);
    }

    @Test
    void setAntalHylder() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        testLager.getReoler()[0].setAntalHylder(3);
        int actual = testLager.getReoler()[0].getAntalHylder();
        // Assert
        assertEquals(3, actual);
    }

    @Test
    void setAntalHylderTilUnderNul() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.getReoler()[0].setAntalHylder(-1),
                "DET MÅ DU SLET IKKE, DET DER!");
    }

    // ======================================================================
    // isEmpty
    // ======================================================================

    @Test
    void isNotEmpty() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = Controller.opretFad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 0, 2, 1);
        // Assert
        assertFalse(testLager.getReoler()[0].isEmpty());
    }

    @Test
    void isEmpty() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        // Assert
        assertTrue(testLager.getReoler()[0].isEmpty());
    }
}