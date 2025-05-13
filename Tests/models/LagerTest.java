package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {

    // ======================================================================
    // setFad
    // ======================================================================

    @Test
    void setFad() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        Fad expected = testLager.setFad(fad, 17,2, 1);
        Fad actual = testLager.getReoler()[17].getHylder()[2].getPladser()[1].getFad();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setFadOoB_Reol() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 47,2, 1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad, 47,2, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void setFadOoB_Hylde() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 17,8, 1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad, 17,8, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void setFadOoB_Plads() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 17,2, 4);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad, 17,2, 4),
                "Denne plads findes ikke.");
    }

    @Test
    void setFadPaaOptagetPlads() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad2 = new Fad("36", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 17,2, 1);
        testLager.setFad(fad2, 17,2, 1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad,17,2,1),
                "Denne plads er optaget.");
    }

    @Test
    void setFadOoB_ReolUnderNul() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, -1,2, 1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad, -1,2, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void setFadOoB_HyldeUnderNul() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 17,-1, 1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad, 17,-1, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void setFadOoB_PladsUnderNul() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 17,2, -1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.setFad(fad, 17,2, -1),
                "Denne plads findes ikke.");
    }

    // ======================================================================
    // findFad
    // ======================================================================

    // NOTE:
    // findFad metoden kalder ned i klassehierarkiet til metode med samme navn i LagerReol,
    // der kalder videre til metode med samme navn i LagerHylde, der kalder til LagerPlads.
    // Jeg tester derfor kun metoden findFad der findes i Lager klassen.

    @Test
    void findFad() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        testLager.setFad(fad, 17,2, 1);
        // Act
        int[] expected = new int[]{17,2,1};
        int[] actual = testLager.findFad(fad);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    void findIkkeFad() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        int[] expected = new int[]{-1,-1,-1};
        int[] actual = testLager.findFad(fad);
        // Assert
        assertArrayEquals(expected, actual);
    }

    // ======================================================================
    // Remove
    // ======================================================================

    @Test
    void removeFad() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        testLager.setFad(fad, 17,2, 1);
        testLager.removeFad(17,2,1);

        Fad expected = null;
        Fad actual = testLager.getFad(17,2,1);
        // Assert
        assertEquals(expected, actual);
        assertNull(actual);
    }

    @Test
    void removeIngenting() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        Fad actual = testLager.removeFad(17,2,1);
        // Assert
        assertNull(actual);
    }

    @Test
    void removeFadOoB_Reol() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        testLager.removeFad(47,2,1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.removeFad(47,2, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void removeFadOoB_Hylde() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        testLager.removeFad(17,8,1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.removeFad(17,8, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void removeFadOoB_Plads() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        testLager.removeFad(17,2,4);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.removeFad(17,2, 4),
                "Denne plads findes ikke.");
    }

    @Test
    void removeFadOoB_ReolUnderNul() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        testLager.removeFad(-1,2,1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.removeFad(-1,2, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void removeFadOoB_HyldeUnderNul() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        testLager.removeFad(17,-1,1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.removeFad(17,-1, 1),
                "Denne plads findes ikke.");
    }

    @Test
    void removeFadOoB_PladsUnderNul() {
        // Arrange
        Lager testLager = new Lager("Test", "Test", 30, 4,2);
        // Act
        testLager.removeFad(17,2,-1);
        // Assert
        assertThrows(IllegalArgumentException.class, () -> testLager.removeFad(17,2, -1),
                "Denne plads findes ikke.");
    }

}