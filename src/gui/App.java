package gui;

import javafx.application.Application;
import controller.Controller;
import models.*;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        initStorage();

        Application.launch(StartVindue.class);
    }

    /**
     * initialiserer storage med nogle objekter
     */
    public static void initStorage() {
        //    ==================================================================================
        //    Opretter Fade
        //    ==================================================================================
        Fad fad68 = Controller.getController().opretFad("68", "EX_OLOROSO", "EGETRÆ", 100.0, Charring.HEAVY_CHAR, FillNummer.FIRST_FILL, null);
        Fad fad69 = Controller.getController().opretFad("69", "EX_OLOROSO", "EGETRÆ", 120.0, Charring.MEDIUM_TOAST, FillNummer.SECOND_FILL, null);
        Fad fad70 = Controller.getController().opretFad("70", "EX_BOURBON", "EGETRÆ", 60.0, Charring.LIGHT_TOAST, FillNummer.FIRST_FILL, null);
        Fad fad71 = Controller.getController().opretFad("71", "EX_OLOROSO", "EGETRÆ", 95.0, Charring.MEDIUM_CHAR, FillNummer.THIRD_FILL, null);

        //    ==================================================================================
        //    Opretter Destillater
        //    ==================================================================================
        Destillat nm100 = Controller.opretDestillat("NM100", 72.0, 35, LocalDate.of(2023, 1, 1), Ristning.VIENNAMALT);
        Destillat nm101 = Controller.opretDestillat("NM101", 65.0, 25, LocalDate.of(2023, 6, 1), Ristning.VIENNAMALT);
        Destillat nm102 = Controller.opretDestillat("NM102", 70.0, 27, LocalDate.of(2024, 4, 1), Ristning.VIENNAMALT);
        Destillat nm103 = Controller.opretDestillat("NM103", 68.0, 15, LocalDate.of(2025, 1, 1), Ristning.VIENNAMALT);

        //    ==================================================================================
        //    Opretter Påfyldninger
        //    ==================================================================================
//        Påfyldning påfyldning100 = Controller.opretPåfyldning("100", nm100, fad68, 35, LocalDate.of(2025,1,2));
//        Påfyldning påfyldning101 = Controller.opretPåfyldning("101", nm101, fad68, 25, LocalDate.of(2025,1,2));
//        Påfyldning påfyldning102 = Controller.opretPåfyldning("102", nm102, fad70, 15, LocalDate.of(2025,1,2));
//        Påfyldning påfyldning103 = Controller.opretPåfyldning("103", nm103, fad70, 15, LocalDate.of(2025,1,2));

        //    ==================================================================================
        //    Opretter Lagre
        //    ==================================================================================
        Lager lagerSall = Controller.getController().opretLager("Sall lager", "Sall", 32, 3, 2);
        Lager lagerViborg = Controller.getController().opretLager("Viborg lager", "Viborg", 14, 3, 2);
    }
}
