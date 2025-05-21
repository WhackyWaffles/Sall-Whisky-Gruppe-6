package models;

import application.models.Korn;
import application.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KornTest {

    @Test
    void getMark() {
        // Arrange
        Korn korn = Controller.opretKorn("Stadsgaard", "Brabrand", "Belgravia");
        // Act
        // Assert
        assertEquals("Stadsgaard", korn.getMark());
    }

    @Test
    void getLokation() {
        // Arrange
        Korn korn = Controller.opretKorn("Mosegaard", "Brabrand", "Shuffle");
        // Act
        // Assert
        assertEquals("Brabrand", korn.getLokation());
    }

    @Test
    void getKornSort() {
        // Arrange
        Korn korn = Controller.opretKorn("Stadsgaard", "Brabrand", "Moonshine");
        // Act
        // Assert
        assertEquals("Moonshine", korn.getKornSort());
    }
}