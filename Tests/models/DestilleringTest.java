package models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {


    @Test
    void getBatchNr() {
        // Arrange
        Destillat destillering = new Destillat("NM100","72", LocalDate.of(2025, 01,01),35, Ristning.VIENNAMALT);
        // Act
        // Assert
        assertEquals("NM100","NM100");
    }

    @Test
    void getAlkoholProcent() {
        // Arrange
        Destillat destillering = new Destillat("NM101","65", LocalDate.of(2025,01,02),25, Ristning.PALE);
        // Act
        // Assert
        assertEquals("65","65");
    }
}