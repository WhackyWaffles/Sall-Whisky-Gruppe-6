package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerHyldeTest {

    // TODO - Gennemgå alle Lagerklasser for at se, om alle RELEVANTE(!) metoder er dækket

    @Test
    void setFad() {
        // Arrange
        LagerHylde lagerHylde = new LagerHylde(2);
        Fad fad = new Fad("test", "test", "test", 100.0, null);
        // Act
        lagerHylde.setFad(fad, 1);
        // Assert
        assertEquals(fad, lagerHylde.getPladser()[1].getFad());
    }

    @Test
    void findFad() {
        // Arrange
        LagerHylde lagerHylde = new LagerHylde(2);
        Fad fad = new Fad("test", "test", "test", 100.0, null);
        lagerHylde.setFad(fad, 1);
        // Act
        int actual = lagerHylde.findFad(fad);
        // Assert
        assertEquals(1, actual);
    }

    @Test
    void getAntalPladser() {
        // Arrange
        LagerHylde lagerHylde = new LagerHylde(2);
        // Act
        int actual = lagerHylde.getAntalPladser();
        // Assert
        assertEquals(2, actual);
    }

    @Test
    void isNotEmpty() {
        // Arrange
        LagerHylde lagerHylde = new LagerHylde(2);
        Fad fad = new Fad("test", "test", "test", 100.0, null);
        lagerHylde.setFad(fad, 1);
        // Act
        // Assert
        assertFalse(lagerHylde.isEmpty());
    }

    @Test
    void isEmpty() {
        // Arrange
        LagerHylde lagerHylde = new LagerHylde(2);
        // Act
        // Assert
        assertTrue(lagerHylde.isEmpty());
    }
}