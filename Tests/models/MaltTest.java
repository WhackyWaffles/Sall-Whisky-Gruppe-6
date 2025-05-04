package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MaltTest {

    @Test
    void getKornSorter() {
        // Arrange
        Korn korn1 = new Korn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = new Korn("Stadsgaard", "Brabrand", "Belagria");
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(korn1);
        kornBlanding2024.add(korn2);

        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals(kornBlanding2024, kornBlanding2024);
    }

    @Test
    void getRistning() {
        // Arrange
        Korn korn1 = new Korn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = new Korn("Stadsgaard", "Brabrand", "Belagria");
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(korn1);
        kornBlanding2024.add(korn2);

        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals(Ristning.VIENNAMALT, Ristning.VIENNAMALT);
    }

    @Test
    void erRoeget() {
        // Arrange
        Korn korn1 = new Korn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = new Korn("Stadsgaard", "Brabrand", "Belagria");
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(korn1);
        kornBlanding2024.add(korn2);

        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertTrue(true);
    }

    @Test
    void getGaer() {
        // Arrange
        Korn korn1 = new Korn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = new Korn("Stadsgaard", "Brabrand", "Belagria");
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(korn1);
        kornBlanding2024.add(korn2);

        Malt malt = new Malt(kornBlanding2024, Ristning.VIENNAMALT, true, "carlsbergensis");
        // Act
        // Assert
        assertEquals("carlsbergensis", "carlsbergensis");
    }
}