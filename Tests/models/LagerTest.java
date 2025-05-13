package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {

    @Test
    void getLagerPlads() {
    }

    @Test
    void setLagerPlads() {
    }

    @Test
    void setFad() {
        // Arrange
        Lager lager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        // Act
        lager.setFad(fad, 17,2, 1);
        // Assert
        assertEquals(fad, lager.getReoler()[17].getHylder()[2].getPladser()[1].getFad());
    }

    @Test
    void findFad() {
        // Arrange
        Lager lager = new Lager("Test", "Test", 30, 4,2);
        Fad fad = new Fad("35", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        lager.setFad(fad, 17,2, 1);
        // Act
        int[] expected = new int[]{17,2,1};
        // Assert
        assertArrayEquals(expected, lager.findFad(fad));
    }

    // TODO -
    //  Test: findFad, hvor fad ikke kan findes
    //  Test: setFad -> OoB + catch exception
    //      (skal også laves for reol, hylde og plads)
    //  Test: setFad på occupied plads + catch exception
    //      (skal også laves for reol, hylde og plads)
    //  Test: removeFad når jeg har lavet metoden i LagerKlasserne.
    //      (skal også laves for reol og hylde)

}