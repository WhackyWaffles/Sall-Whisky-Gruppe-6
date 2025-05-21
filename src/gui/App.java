package gui;

import application.models.*;
import javafx.application.Application;
import application.controller.Controller;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        initStorage();

        Application.launch(StartVindue.class);
    }

    /**
     * Initialiserer storage med nogle objekter
     */
    // De udkommenterede FadPlaceringer er til intern Gui testning.
    public static void initStorage() {

        //    ==================================================================================
        //    Opretter Fade
        //    ==================================================================================
        Fad fad68 = Controller.opretFad("68", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad69 = Controller.opretFad("69", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad70 = Controller.opretFad("70", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad71 = Controller.opretFad("71", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);

        //    ==================================================================================
        //    Opretter Destillater
        //    ==================================================================================
        Destillat nm100 = Controller.opretDestillat("NM100", "72.0", 35, LocalDate.of(2023, 1, 1), Ristning.VIENNAMALT);
        Destillat nm101 = Controller.opretDestillat("NM101", "65.0", 25, LocalDate.of(2023, 6, 1), Ristning.VIENNAMALT);
        Destillat nm102 = Controller.opretDestillat("NM102", "70.0", 27, LocalDate.of(2024, 4, 1), Ristning.VIENNAMALT);
        Destillat nm103 = Controller.opretDestillat("NM103", "68.0", 15, LocalDate.of(2025, 1, 1), Ristning.VIENNAMALT);

        //    ==================================================================================
        //    Opretter Påfyldninger
        //    ==================================================================================
        Påfyldning påfyldning100 = Controller.opretPåfyldning("100", nm100, fad68, 35, LocalDate.of(2025,1,2));
        Påfyldning påfyldning101 = Controller.opretPåfyldning("101", nm101, fad68, 25, LocalDate.of(2025,1,2));
        Påfyldning påfyldning102 = Controller.opretPåfyldning("102", nm102, fad70, 15, LocalDate.of(2025,1,2));
        Påfyldning påfyldning103 = Controller.opretPåfyldning("103", nm103, fad70, 15, LocalDate.of(2025,1,2));

        //    ==================================================================================
        //    Opretter Lagre
        //    ==================================================================================
        Lager lagerSall = Controller.opretLager("Sall lager", "Sall", 32, 3, 2);
        Lager lagerViborg = Controller.opretLager("Viborg lager", "Viborg", 14, 3, 2);

        //    ==================================================================================
        //    Placerer Fade på lager
        //    ==================================================================================
//        lagerSall.setFad(fad68,1,2,1);
//        lagerSall.setFad(fad69,2,2,0);
//        lagerViborg.setFad(fad70,1,1,1);
//        lagerViborg.setFad(fad71,2,1,0);
    }
}
