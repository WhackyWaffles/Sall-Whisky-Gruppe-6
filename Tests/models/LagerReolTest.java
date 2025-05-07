package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        Destillering nm101 = new Destillering("NM101", "51%", Ristning.PILSNER);
        Fad fad1 = new Fad("35", "Oloroso", "Egetræ", 35, Charring.HEAVY_CHAR, FillNummer.SECOND_FILL);
        Påfyldning påfyldning = new Påfyldning(nm101, fad1,32, LocalDate.of(2024,12,06));
        lagerPlads.setFad(fad1);
        // Act
        // Assert
        assertFalse(lagerPlads.isEmpty());
    }

    @Test
    void getHylder() {
    }
}