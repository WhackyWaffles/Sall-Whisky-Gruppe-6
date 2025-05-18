package models;

import controller.Controller;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {

    @Test
    void getBatchNr() {
        // Arrange
        Destillat destillering = Controller.opretDestillat("NM100",72.0, 35, LocalDate.of(2025, 1,1),Ristning.VIENNAMALT);
        // Act
        // Assert
        assertEquals("NM100",destillering.getBatchNr());
    }

    @Test
    void getAlkoholProcent() {
        // Arrange
        Destillat destillering = Controller.opretDestillat("NM100", 72.0, 35, LocalDate.of(2025, 1, 1), Ristning.VIENNAMALT);
        // Act
        // Assert
        assertEquals(72.0, destillering.getAlkoholProcent());
    }
}