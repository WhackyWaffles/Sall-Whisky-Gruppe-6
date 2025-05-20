package controller;

import models.Destillat;
import models.Korn;
import models.Malt;
import models.Ristning;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    // TODO: Lav JunitTests til alle metoder i kontrolleren
    // TODO: I GUI, lav sådan, at de fade der ses viser om de er placeret på et lager allerede,
    //      og implementer sådan, at hvis de rykkes fra en plads,
    //      at de så bliver removed fra den plads og sat ind på den nye.
    // TODO: GUI exception handlers

    @Test
    void getAllKornSorter() {
        // Arrange
        Korn korn1 = Controller.opretKorn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = Controller.opretKorn("Stadsgaard", "Brabrand", "Belagria");
        // Act
        List<Korn> result = Controller.getAllKornSorter();
        // Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(korn1));
        assertTrue(result.contains(korn2));
    }

    @Test
    void getAllMalts() {
        // Arrange
        // Opretter Korn
        Korn korn1 = Controller.opretKorn("Mosegaard", "Viborg", "Stouch");
        Korn korn2 = Controller.opretKorn("Stadsgaard", "Brabrand", "Chevallier");

        // Sætter Korn i ArrayLister
        ArrayList<Korn> korn2024B = new ArrayList<>();
        ArrayList<Korn> korn2024C = new ArrayList<>();
        korn2024B.add(korn1);
        korn2024C.add(korn2);

        // Opretter Malt
        Malt malt1 = Controller.opretMalt(korn2024B, Ristning.VIENNAMALT, true, "carlsbergensis");
        Malt malt2 = Controller.opretMalt(korn2024C, Ristning.PILSNERMALT, false, "BRY-97 American West Coast Ale Gær");

        // Opretter variabel for at kunne teste
        List<Malt> result2 = Controller.getAllMalts();

        // Act
        // Assert
        assertTrue(result2.contains(korn1));
        assertTrue(result2.contains(korn2));
    }

    @Test
    void getAllDestillater() {
        // Arrange
        Destillat destillat1 = Controller.opretDestillat("testNr1", 55.0, 20.0,
                LocalDate.of(2024, 1, 1), Ristning.VIENNAMALT);
        Destillat destillat2 = Controller.opretDestillat("testNr2", 55.0, 20.0,
                LocalDate.of(2024, 1, 1), Ristning.VIENNAMALT);

        // Act
        // Assert
        assertTrue(Controller.getAllDestillater().contains(destillat1));
        assertTrue(Controller.getAllDestillater().contains(destillat2));
    }
}