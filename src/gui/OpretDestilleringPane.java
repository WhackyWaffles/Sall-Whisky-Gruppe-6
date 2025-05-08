package gui;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class OpretDestilleringPane extends GridPane {

    private TextField txtBatchNr = new TextField();
    private TextField txtAlkoholProcent = new TextField();
    private TextField txtAntalLt = new TextField();
    private TextField txtAntalDestl = new TextField();
    private ComboBox<String> comboMalt = new ComboBox<>();
    private DatePicker datePicker = new DatePicker();

    public OpretDestilleringPane() {

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.txtBatchNr = new TextField();
        this.txtAlkoholProcent = new TextField();
        this.txtAntalDestl = new TextField();
        this.datePicker.setValue(LocalDate.now());
        this.txtAntalLt = new TextField();


        //Label og textfield
        Label lblBatchNr = new Label("Batch Nummer ");
        this.add(lblBatchNr, 0,1);
        this.add(this.txtBatchNr, 1,1);

        Label lblAlkoholProcent = new Label("Alkohol %");
        this.add(lblAlkoholProcent, 0,2);
        this.add(this.txtAlkoholProcent, 1,2);

        Label lblAntalDest = new Label("Antal ");
        this.add(lblAntalDest, 0,3);
        this.add(this.txtAntalDestl, 1,3);

        Label lblDato = new Label("Dato ");
        this.add(lblDato, 0, 4);  //
        datePicker.setValue(LocalDate.now()); // default to today
        this.add(datePicker, 1, 4);

        Label lblAntalLt = new Label("Antal Liter ");
        this.add(lblAntalLt, 0,5);
        this.add(this.txtAntalLt, 1,5);

        // ComboBox for Malt
        Label lblmalt = new Label("Malt Type");
        this.add(lblmalt, 0,6);
        comboMalt.getItems().addAll("Pilsner ", "Pale ", "Viennamalt ");
        comboMalt.setPromptText("Vælg Malt Type");
        this.add(comboMalt, 1, 6);


        //Button til Opret og Aflyst
        Button btnOpretDestl = new Button("Opret");
        this.add(btnOpretDestl,0,18);
        btnOpretDestl.setOnAction(event -> this.opretAction());

        Button btnAflyst = new Button("Annuller");
        this.add(btnAflyst,2,18);
        btnAflyst.setOnAction(event -> this.aflystAction());


    }
    private void opretAction() {

        String batchNr = txtBatchNr.getText();
        String alkoholProcentStr = txtAlkoholProcent.getText();
        String antalDestStr = txtAntalDestl.getText();
        LocalDate valgtDato = datePicker.getValue();
        String antalLtStr = txtAntalLt.getText();
        String selectedCherring = comboMalt.getValue();

        if (batchNr.isEmpty() || alkoholProcentStr.isEmpty() || antalDestStr.isEmpty() ||
                antalLtStr.isEmpty() || selectedCherring == null) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }
        try {
            double alkoholProcent = Double.parseDouble(alkoholProcentStr);
            int antalDest = Integer.parseInt(antalDestStr);
            double antalLt = Double.parseDouble(antalLtStr);

            //Gemmer alle dataoen
            System.out.println("Opretter destillering:");
            System.out.println("Batch: " + batchNr);
            System.out.println("Alkohol %: " + alkoholProcent);
            System.out.println("Antal destillering: " + antalDest);
            System.out.println("Dato: " + valgtDato);
            System.out.println("Antal liter: " + antalLt);
            System.out.println("Cherring: " + selectedCherring);

            clearFields();
        } catch (NumberFormatException e) {
            System.out.println("Fejl:Indtast korrekt talformat i procent, antal og liter felterne.");
        }

    }
    private void aflystAction() {

        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");

    }

    private void clearFields() {
        txtBatchNr.clear();
        txtAlkoholProcent.clear();
        txtAntalDestl.clear();
        datePicker.setValue(LocalDate.now());
        txtAntalLt.clear();
        comboMalt.getSelectionModel().clearSelection();
    }


}
