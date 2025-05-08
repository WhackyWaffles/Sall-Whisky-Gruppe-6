package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerPladsTest {

    // TODO - Gennemgå alle Lagerklasser for at se, om alle RELEVANTE(!) metoder er dækket

    @Test
    void getFad() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lagerPlads.setFad(fad);
        // Act
        // Assert
        assertEquals(fad, lagerPlads.getFad());
        assertNotNull(lagerPlads.getFad());
    }

    @Test
    void setFad() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lagerPlads.setFad(fad);
        // Act
        // Assert
        assertEquals(fad, lagerPlads.getFad());
    }

    @Test
    void removeFad() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lagerPlads.setFad(fad);
        // Act
        Fad expected = lagerPlads.removeFad(fad);
        // Assert
        assertNotEquals(expected, lagerPlads.getFad());
        assertNull(lagerPlads.getFad());
    }

    @Test
    void isNotEmpty() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lagerPlads.setFad(fad);
        // Act
        // Assert
        assertFalse(lagerPlads.isEmpty());
        assertNotNull(lagerPlads.getFad());
    }

    @Test
    void isEmpty() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        // Act
        // Assert
        assertTrue(lagerPlads.isEmpty());
        assertNull(lagerPlads.getFad());
    }
}