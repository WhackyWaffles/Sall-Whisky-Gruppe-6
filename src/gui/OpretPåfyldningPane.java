package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Destillat;
import models.Fad;

import java.time.LocalDate;

public class OpretPåfyldningPane extends GridPane {

    private TextField txtIdNr = new TextField();
    private ListView<Destillat> lvDestillater = new ListView<>();
    private ListView<Fad> lvFade = new ListView<>();
    private TextField txtLiter = new TextField();
    private DatePicker datePicker = new DatePicker();

    public OpretPåfyldningPane() {

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.setMinSize(700,400);


        //Label og textfield
        Label lblIdNr = new Label("IdNr");
        this.add(lblIdNr, 0, 1);
        this.add(this.txtIdNr, 1, 1);

        Label lblDestillat = new Label("Spirit batch");
        this.add(lblDestillat, 0, 2);
        this.add(this.lvDestillater, 1, 2);

        Label lblFad = new Label("Fad");
        this.add(lblFad, 0, 3);
        this.add(this.lvFade, 1, 3);

        Label lblLiter = new Label("Liter");
        this.add(lblLiter, 0, 4);
        this.add(this.txtLiter, 1, 4);

        Label lblDato = new Label("Dato");
        this.add(lblDato, 0, 5);  //
        datePicker.setValue(LocalDate.now()); // default to today
        this.add(datePicker, 1, 5);

        // Fyld ListView med fade fra Controller
        lvFade.getItems().addAll(Controller.getController().getAlleFade());
        lvFade.setPrefHeight(200); // Sætter en passende højde

        // Fyld ListView med destillater fra Controller
        lvDestillater.getItems().addAll(Controller.getController().getAllDestillater());
        lvDestillater.setPrefHeight(200); // Sætter en passende højde

        //Button til Opret og Annuller

        Button btnOpretPåfyld = new Button("Opret");
        btnOpretPåfyld.setOnAction(event -> this.opretPåfyldAction());

        Button btnAnnuller = new Button("Annullér");
        btnAnnuller.setOnAction(event -> this.aflystPåfyldAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.updaterLister());

        HBox buttonBox = new HBox(30);
        this.add(buttonBox,0,7,2,1);
        buttonBox.getChildren().addAll(btnOpretPåfyld, btnAnnuller, btnOpdater);
    }

    private void opretPåfyldAction() {
        String idNr = txtIdNr.getText();
        Destillat destillat = lvDestillater.getSelectionModel().getSelectedItem();
        Fad fad = lvFade.getSelectionModel().getSelectedItem();
        String påfyldningLiter = txtLiter.getText();
        LocalDate valgtDato = datePicker.getValue();

        if (idNr.isEmpty() || destillat == null || fad == null ||
                påfyldningLiter.isEmpty()) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }
        try {
            if (!påfyldningLiter.matches("\\d+\\.\\d+")) {
                System.out.println("Fejl: 'Liter' skal være et decimaltal (f.eks. 12.5).");
                return;
            }
            double påfyldningLiterStr = Double.parseDouble(påfyldningLiter);
            if (påfyldningLiterStr <= 0) {
                System.out.println("Fejl: Liter skal være større end 0.");
                return;
            }

            // Gemmer al data i storage
            Controller.getController().tilføjPåfyldning(idNr, destillat, fad, påfyldningLiterStr, valgtDato);

            // Udskriv data
            System.out.println("Opretter påfyldning:");
            System.out.println("IDnr: " + idNr);
            System.out.println("Destillat: " + destillat.getBatchNr());
            System.out.println("Fad: " + fad.getNr());
            System.out.println("Antal liter: " + påfyldningLiter);
            System.out.println("Dato: " + valgtDato);

            clearFields();
        } catch (NumberFormatException e) {
            System.out.println("Fejl: 'Liter' skal være et korrekt decimaltal.");
        }
    }

    private void aflystPåfyldAction() {
        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");
    }

    private void clearFields() {
        txtIdNr.clear();
        txtLiter.clear();
        datePicker.setValue(LocalDate.now());
    }

    private void updaterLister(){
        lvFade.getItems().setAll(Controller.getController().getAlleFade());
        lvDestillater.getItems().setAll(Controller.getController().getAllDestillater());
        System.out.println(("Listerne er opdateret"));
    }
}

