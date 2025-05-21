package models;

import application.models.Korn;
import application.models.Malt;
import application.models.Ristning;
import application.controller.Controller;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaltTest {

    @Test
    void getKornSorter() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(Controller.opretKorn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(Controller.opretKorn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = Controller.opretMalt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals(kornBlanding2024, malt.getKornSorter());
    }

    @Test
    void getRistning() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(Controller.opretKorn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(Controller.opretKorn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = Controller.opretMalt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals(Ristning.VIENNAMALT, malt.getRistning());
    }

    @Test
    void erRoeget() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(Controller.opretKorn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(Controller.opretKorn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = Controller.opretMalt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertTrue(malt.erRoeget());
    }

    @Test
    void getGaer() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(Controller.opretKorn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(Controller.opretKorn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = Controller.opretMalt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals("carlsbergensis", malt.getGaer());
    }

    @Test
    void addKorn() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        Korn korn1 = Controller.opretKorn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = Controller.opretKorn("Stadsgaard", "Brabrand", "Belagria");

        kornBlanding2024.add(korn1);
        Malt malt = Controller.opretMalt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");

        // Act
        malt.addKorn(korn2);
        kornBlanding2024.add(korn2);
        // Assert
        assertEquals(kornBlanding2024, malt.getKornSorter());
    }

}