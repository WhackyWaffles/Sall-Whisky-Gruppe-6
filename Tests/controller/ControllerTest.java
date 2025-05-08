package controller;

import models.Korn;
import models.Malt;
import models.Ristning;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getAllKornSorter() {
        // Arrange
        Korn korn1 = new Korn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = new Korn("Stadsgaard", "Brabrand", "Belagria");
        Controller controller = new Controller();
//        controller.tilføjKorn(korn1);
//        controller.tilføjKorn(korn2);
        // Act
        List<Korn> result = controller.getAllKornSorter();
        // Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(korn1));
        assertTrue(result.contains(korn2));
    }


    @Test
    void getAllMalts() {
        // Arrange
        Controller controller = new Controller();
        Korn korn1 = new Korn("Mosegaard", "Viborg", "Moonshine");
        Korn korn2 = new Korn("Stadsgaard", "Brabrand", "Belagria");
        ArrayList<Korn> kornBlanding2024 = new ArrayList<>();
        kornBlanding2024.add(korn1);
        kornBlanding2024.add(korn2);

        Korn korn3 = new Korn("Mosegaard", "Viborg", "Stouch");
        Korn korn4 = new Korn("Stadsgaard", "Brabrand", "Chevallier");
        ArrayList<Korn> korn2024B = new ArrayList<>();
        ArrayList<Korn> korn2024C = new ArrayList<>();
        korn2024B.add(korn3);
        korn2024C.add(korn4);

        Malt malt1 = new Malt(korn2024B, Ristning.VIENNAMALT, true, "carlsbergensis");
        Malt malt2 = new Malt(korn2024C, Ristning.PILSNER, false, "BRY-97 American West Coast Ale Gær");

        List<Malt> result2 = Controller.getController().getAllMalts();

        // Act

        // Assert
        assertTrue(result2.contains(korn3));
        assertTrue(result2.contains(korn4));
    }

    @Test
    void getAllDestilleringer() {
    }
}