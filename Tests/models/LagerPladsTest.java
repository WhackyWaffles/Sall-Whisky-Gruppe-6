package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerPladsTest {

    // ======================================================================
    // getFad
    // ======================================================================

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

    // ======================================================================
    // setFad
    // ======================================================================

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
    void setFad_Optaget() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad2 = new Fad("test2", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lagerPlads.setFad(fad);
        // Act
            // lagerPlads.setFad(fad2);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> lagerPlads.setFad(fad2),
                "Denne plads er optaget.");
    }

    // ======================================================================
    // Remove
    // ======================================================================

    @Test
    void removeFad() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        Fad fad = new Fad("test", "test", "test", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lagerPlads.setFad(fad);
        // Act
        Fad expected = lagerPlads.removeFad();
        // Assert
        assertNotEquals(expected, lagerPlads.getFad());
        assertNull(lagerPlads.getFad());
    }

    @Test
    void removeIngenting() {
        // Arrange
        LagerPlads lagerPlads = new LagerPlads();
        // Act
        Fad expected = lagerPlads.removeFad();
        // Assert
        assertEquals(expected, lagerPlads.getFad());
        assertNull(expected);
    }

    // ======================================================================
    // isEmpty
    // ======================================================================

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