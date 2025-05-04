package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {


    @Test
    void getBatchNr() {
        // Arrange
        Destillering destillering = new Destillering("NM100","72");
        // Act
        // Assert
        assertEquals("NM100","NM100");
    }

    @Test
    void getAlkoholProcent() {
        // Arrange
        Destillering destillering = new Destillering("NM101","65");
        // Act
        // Assert
        assertEquals("65","65");
    }
}