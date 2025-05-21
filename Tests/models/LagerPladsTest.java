package models;

import application.models.Charring;
import application.models.Fad;
import application.models.FillNummer;
import application.models.Lager;
import application.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerPladsTest {

    // ======================================================================
    // getFad
    // ======================================================================

    @Test
    void getFad() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = Controller.opretFad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        testLager.setFad(fad, 4, 2, 1);
        // Act
        // Assert
        assertEquals(fad, testLager.getFad(4,2,1));
        assertNotNull(testLager.getFad(4,2,1));
    }

    // ======================================================================
    // setFad
    // ======================================================================

    @Test
    void setFad() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = Controller.opretFad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        testLager.setFad(fad, 4, 2, 1);
        // Act
        // Assert
        assertEquals(fad, testLager.getFad(4,2,1));
    }

    @Test
    void setFad_Optaget() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = Controller.opretFad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad2 = Controller.opretFad("test2", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        testLager.setFad(fad, 4, 2, 1);
        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad2, 4, 2, 1),
                "Denne plads er optaget.");
    }

    // ======================================================================
    // Remove
    // ======================================================================

    @Test
    void removeFad() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = Controller.opretFad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        testLager.setFad(fad, 4, 2, 1);
        // Act
        Fad expected = testLager.removeFad(4,2,1);
        // Assert
        assertNotEquals(expected, testLager.getFad(4,2,1));
        assertNull(testLager.getFad(4,2,1));
    }

    @Test
    void removeIngenting() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        Fad expected = testLager.removeFad(4,2,1);
        // Assert
        assertEquals(expected, testLager.getFad(4,2,1));
        assertNull(expected);
    }

    // ======================================================================
    // isEmpty
    // ======================================================================

    @Test
    void isNotEmpty() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        Fad fad = Controller.opretFad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        testLager.setFad(fad, 4, 2, 1);
        // Act
        // Assert
        assertFalse(testLager.getReoler()[4].getHylder()[2].getPladser()[1].isEmpty());
        assertNotNull(testLager.getReoler()[4].getHylder()[2].getPladser()[1].getFad());
    }

    @Test
    void isEmpty() {
        // Arrange
        Lager testLager = Controller.opretLager("Test", "Test", 30, 4,2);
        // Act
        // Assert
        assertTrue(testLager.getReoler()[4].getHylder()[2].getPladser()[1].isEmpty());
        assertNull(testLager.getReoler()[4].getHylder()[2].getPladser()[1].getFad());
    }
}