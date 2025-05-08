package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KornTest {

    @Test
    void getMark() {
        // Arrange
        Korn korn = new Korn("Stadsgaard", "Brabrand", "Belgravia");
        // Act
        // Assert
        assertEquals("Stadsgaard", korn.getMark());
    }

    @Test
    void getLokation() {
        // Arrange
        Korn korn = new Korn("Mosegaard", "Brabrand", "Shuffle");
        // Act
        // Assert
        assertEquals("Brabrand", korn.getLokation());
    }

    @Test
    void getKornSort() {
        // Arrange
        Korn korn = new Korn("Stadsgaard", "Brabrand", "Moonshine");
        // Act
        // Assert
        assertEquals("Moonshine", korn.getKornSort());
    }
}