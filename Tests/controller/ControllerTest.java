package controller;

import models.*;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    // TODO: Lav JunitTests til alle metoder i kontrolleren
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
    void testOpretFad() {
        // Arrange
        String fadNr = "F001";
        String fadtype = "Sherry";
        String fadMateriale = "Eg";
        double kapacitet = 200.0;
        Charring charring = Charring.MEDIUM_CHAR;
        FillNummer fillNummer = FillNummer.SECOND_FILL;
        ArrayList<Påfyldning> påfyldninger = new ArrayList<>();

        // Act
        Fad fad = Controller.opretFad(fadNr, fadtype, fadMateriale, kapacitet, charring, fillNummer, påfyldninger);

        // Assert
        assertNotNull(fad);
        assertEquals(fadNr, fad.getFadNr());
        assertEquals(fadtype, fad.getFadtype());
        assertEquals(fadMateriale, fad.getFadMateriale());
        assertEquals(kapacitet, fad.getKapacitet());
        assertEquals(charring, fad.getCharring());
        assertEquals(fillNummer, fad.getFillNummer());
        assertEquals(påfyldninger, fad.getPåfyldninger());

        // Verificér at fadet er tilføjet til Storage
        assertTrue(Storage.getAlleFade().contains(fad));
    }

    @Test
    void testOpretFad_UgyldigtKapacitet() {
        // Skal kaste en exception, hvis kapacitet er negativ
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.opretFad("F002", "Bourbon", "Eg", -50, Charring.HEAVY_TOAST, FillNummer.FIRST_FILL, new ArrayList<>());
        });
        assertEquals("Kapacitet kan ikke være negativ eller nul", exception.getMessage());
    }

    @Test
    void testOpretFad_NullFadNr() {
        // Skal kaste en exception, hvis fadNr er null
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Controller.opretFad(null, "Sherry", "Eg", 150, Charring.HEAVY_CHAR, FillNummer.SECOND_FILL, new ArrayList<>());
        });
        assertEquals("Fadnummer kan ikke være null eller tomt", exception.getMessage());
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