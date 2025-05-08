package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerReolTest {

    // TODO - Gennemgå alle Lagerklasser for at se, om alle RELEVANTE(!) metoder er dækket

    @Test
    void setFad() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4, 2);
        Fad fad = new Fad("test", "test", "test", 100.0, null);
        // Act
        lagerReol.setFad(fad, 2, 1);
        // Assert
        assertEquals(fad, lagerReol.getHylder()[2].getPladser()[1].getFad());
    }

    @Test
    void findFad() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4,2);
        Fad fad = new Fad("test", "test", "test", 100.0, null);
        lagerReol.setFad(fad, 2, 1);
        // Act
        int[] expected = new int[]{2,1};
        // Assert
        assertArrayEquals(expected, lagerReol.findFad(fad));
    }

    @Test
    void getAntalHylder() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4,2);
        // Act
        int actual = lagerReol.getAntalHylder();
        // Assert
        assertEquals(4, actual);
    }

    @Test
    void setAntalHylder() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4,2);
        // Act
        lagerReol.setAntalHylder(3);
        int actual = lagerReol.getAntalHylder();
        // Assert
        assertEquals(3, actual);
    }

    @Test
    void isNotEmpty() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4, 2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, null);
        lagerReol.setFad(fad, 2, 1);
        // Act
        // Assert
        assertFalse(lagerReol.isEmpty());
    }

    @Test
    void isEmpty() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4, 2);
        // Act
        // Assert
        assertTrue(lagerReol.isEmpty());
    }
}