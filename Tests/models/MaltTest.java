package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaltTest {

    @Test
    void getKornSorter() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(new Korn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(new Korn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals(kornBlanding2024, malt.getKornSorter());
    }

    @Test
    void getRistning() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(new Korn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(new Korn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals(Ristning.VIENNAMALT, malt.getRistning());
    }

    @Test
    void erRoeget() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(new Korn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(new Korn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertTrue(malt.erRoeget());
    }

    @Test
    void getGaer() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(new Korn("Mosegaard", "Viborg", "Moonshine"));
        kornBlanding2024.add(new Korn("Stadsgaard", "Brabrand", "Belagria"));
        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals("carlsbergensis", malt.getGaer());
    }

    @Test
    void addKorn() {
        // Arrange
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(new Korn("Mosegaard", "Viborg", "Moonshine"));
        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        malt.addKorn(new Korn("Stadsgaard", "Brabrand", "Belagria"));
        ArrayList<Korn> expectedKornBlanding = new ArrayList<>();
        expectedKornBlanding.add(new Korn("Mosegaard", "Viborg", "Moonshine"));
        expectedKornBlanding.add(new Korn("Stadsgaard", "Brabrand", "Belagria"));
        // Assert
        assertEquals(expectedKornBlanding, malt.getKornSorter());
    }

}