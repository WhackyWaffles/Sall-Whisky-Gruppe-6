package controller;

import models.*;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    // TODO: GUI exception handlers

    @Test
    void getAllKornSorter() {
        // Arrange (Vi tester også opretKorn())
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

        // Opretter Malt (tester også opretMalt())
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
    void testFindFad_ValidFadNr() {
        // Arrange
        Fad fad1 = new Fad("F001", "Sherry", "Eg", 200.0, Charring.HEAVY_TOAST, FillNummer.FIRST_FILL, new ArrayList<>());
        Fad fad2 = new Fad("F002", "Bourbon", "Eg", 180.0, Charring.LIGHT_TOAST, FillNummer.SECOND_FILL, new ArrayList<>());

        // Act
        Storage.addFad(fad1);
        Storage.addFad(fad2);

        // Assert
        Fad fundetFad = Controller.findFad("F001");
        assertNotNull(fundetFad);
        assertEquals("F001", fundetFad.getFadNr());

        // Assert
        Fad fundetFad2 = Controller.findFad("F002");
        assertNotNull(fundetFad2);
        assertEquals("F002", fundetFad2.getFadNr());
    }

    @Test
    void testFindFad_UgyldigtFadNr() {
        // Arrange søgning efter et fad, der ikke eksisterer
        Fad fundetFad = Controller.findFad("F999");
        assertNull(fundetFad);
    }

    @Test
    void testFindFad_NullFadNr() {
        // Arrange håndtering af null-input
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Controller.findFad(null);
        });
        // Assert
        assertEquals("Fadnummer må ikke være null", exception.getMessage());
    }

    @Test
    void getAllDestillater() {
        // Arrange (tester også opretDestillat())
        Destillat destillat1 = Controller.opretDestillat("testNr1", "55.0", 20.0,
                LocalDate.of(2024, 1, 1), Ristning.VIENNAMALT);
        Destillat destillat2 = Controller.opretDestillat("testNr2", "55.0", 20.0,
                LocalDate.of(2024, 1, 1), Ristning.VIENNAMALT);

        // Act
        // Assert
        assertTrue(Controller.getAllDestillater().contains(destillat1));
        assertTrue(Controller.getAllDestillater().contains(destillat2));
    }

    @Test
    void testFindDestilat_NullBatchNummer() {
        // Arrange håndtering af null-input
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Controller.findDestillat(null);
        });
        // Assert
        assertEquals("BatchNummer må ikke være null!", exception.getMessage());
    }


    @Test
    void testOpretPåfyldning() {
        // Arrange - Opret testdata
        String idNr = "123";
        Destillat destillat = new Destillat("TestDestillat", "72.0", 35, LocalDate.of(2023, 1, 1), Ristning.VIENNAMALT);
        Fad fad = new Fad("456", "Ex-Sherry", "Egetræ", 200, Charring.MEDIUM_CHAR, FillNummer.FIRST_FILL, new ArrayList<>());
        double påfyldningLiter = 50.0;
        LocalDate påfyldningDato = LocalDate.now();

        // Act - Kald metoden
        Påfyldning påfyldning = Controller.opretPåfyldning(idNr, destillat, fad, påfyldningLiter, påfyldningDato);

        // Assert - Bekræft, at værdierne er korrekte
        assertNotNull(påfyldning);
        assertEquals(idNr, påfyldning.getIdNr());
        assertEquals(destillat, påfyldning.getDestillat());
        assertEquals(fad, påfyldning.getFad());
        assertEquals(påfyldningLiter, påfyldning.getPåfyldningLiter());
        assertEquals(påfyldningDato, påfyldning.getPåfyldningDato());
    }

    @Test
    void testOpretWhisky() {
        // Arrange
        String whiskyId = "wh102";
        String navn = "Muld";
        int flaskeNr = 500;
        String slutAlkoholProcent = "51";
        LocalDate aftapningsDato = LocalDate.now();
        Fad fad = new Fad("457", "Ex-Bourbon", "Egetræ", 200, Charring.MEDIUM_CHAR, FillNummer.FIRST_FILL, new ArrayList<>());;

        // Act
        Whisky whisky = Controller.opretWhisky(whiskyId, navn, flaskeNr, slutAlkoholProcent, aftapningsDato, fad);

        // Assert
        assertNotNull(whisky);
        assertEquals(whiskyId, whisky.getWhiskyId());
        assertEquals(navn, whisky.getNavn());
        assertEquals(flaskeNr, whisky.getFlaskeNr());
        assertEquals(slutAlkoholProcent, whisky.getSlutAlkoholProcent());
        assertEquals(aftapningsDato, whisky.getAftapningsDato());
    }

    @Test
    void testFindWhiskyById() {
        // Arrange - Opret en test-whisky og tilføj den til storage
        Whisky whisky1 = new Whisky("001", "Glød", 100, "51", LocalDate.now(),
                new Fad("F001", "Sherry", "Eg", 200.0, Charring.HEAVY_TOAST, FillNummer.FIRST_FILL, new ArrayList<>()));
        Storage.addWhisky(whisky1);


        // Act - Kald metoden
        Whisky foundWhisky = Storage.findWhiskyById("001");

        // Assert - Bekræft, at den rigtige whisky blev fundet
        assertNotNull(foundWhisky);
        assertEquals("001", foundWhisky.getWhiskyId());
        assertEquals("Glød", foundWhisky.getNavn());

        // Test at søgning efter en ikke-eksisterende whisky returnerer null
        Whisky nonExistingWhisky = Storage.findWhiskyById("999");
        assertNull(nonExistingWhisky);
    }

    @Test
    void testOpretLager() {
        // Arrange - Opret testdata
        String navn = "Test Lager";
        String lokation = "Test Lokation";
        int antalReoler = 15;
        int antalHylder = 3;
        int antalPladserPerHylde = 2;

        // Act - Kald metoden
        Lager lager = Controller.opretLager(navn, lokation, antalReoler, antalHylder, antalPladserPerHylde);

        // Assert - Bekræft, at lageret blev oprettet korrekt
        assertNotNull(lager);
        assertEquals(navn, lager.getNavn());
        assertEquals(lokation, lager.getLokation());
        assertEquals(antalReoler, lager.getAntalReoler());
        assertEquals(antalHylder, lager.getReoler()[0].getHylder().length);
        assertEquals(antalPladserPerHylde, lager.getReoler()[0].getHylder()[0].getPladser().length);
    }

    @Test
    void testGetFadePåLager() {
        // Arrange - Opret et testlager og tilføj fade
        Lager lager = new Lager("Test Lager", "Test Lokation", 2, 2, 2); // 2 reoler, 2 hylder, 2 pladser

        // Opret testfade
        Fad fad1 = new Fad("001", "Ex-Bourbon", "Egetræ", 200, Charring.LIGHT_CHAR, FillNummer.SECOND_FILL, new ArrayList<>());
        Fad fad2 = new Fad("002", "Ex-Sherry", "Egetræ", 250, Charring.MEDIUM_CHAR, FillNummer.FIRST_FILL, new ArrayList<>());

        // Placer fade på lager
        lager.setFad(fad1, 0, 0, 0);
        lager.setFad(fad2, 1, 1, 1);

        // Act - Kald metoden
        List<String> fadePåLager = Controller.getFadePåLager(lager);

        // Assert - Bekræft, at koordinater og fade vises korrekt
        assertNotNull(fadePåLager);
        assertEquals(2, fadePåLager.size());
        assertTrue(fadePåLager.contains(fad1.toString() + " [Reol: 0, Hylde: 0, Plads: 0]"));
        assertTrue(fadePåLager.contains(fad2.toString() + " [Reol: 1, Hylde: 1, Plads: 1]"));

        // Test at søgning på et tomt lager returnerer en tom liste
        Lager tomtLager = new Lager("Tomt Lager", "Ingen fade", 2, 2, 2);
        List<String> tomListe = Controller.getFadePåLager(tomtLager);
        assertTrue(tomListe.isEmpty());
    }
}