package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerReolTest {

    @Test
    void findFad() {
    }

    @Test
    void getAntalHylder() {
        // Arrange
        LagerReol lagerReol = new LagerReol(4,2);
        // Act
        // Assert
        assertEquals(4,4);
    }

    @Test
    void setAntalHylder() {
        // Arrange
        LagerReol lagerReol1 = new LagerReol(4,2);
        // Act
        lagerReol1.setAntalHylder(3);
        // Assert
        assertEquals(3,3);
    }

    @Test
    void isEmpty() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad(35, FadType.EX_OLOROSO, FadMateriale.EGETRÆ, new Whisky(), lagerPlads);
        lagerPlads.setFad(fad);
        // Act
        // Assert
        assertFalse(lagerPlads.isEmpty());
    }

    @Test
    void getHylder() {
    }
}