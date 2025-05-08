package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import models.Ristning;

import java.time.LocalDate;

public class OpretDestilleringPane extends GridPane {

    private TextField txtBatchNr = new TextField();
    private TextField txtAlkoholProcent = new TextField();
    private TextField txtAntalDestl = new TextField();
    private LocalDate destilleringDato; // skal måske bruges i anden iteration
    private TextField txtAntalLiter = new TextField();
    private TextField txtRistning = new TextField();
    private Button btnOpretDestl;
    private Button btnAflyst;
    private ComboBox<String> comboMalt = new ComboBox<>();
    private TextField txtAntalLiter = new TextField();
    private ComboBox<Ristning> comboMalt = new ComboBox<>();
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
        this.txtRistning = new TextField(),


        //Label og textfield
        Label lblBatchNr = new Label("Batch Nummer");
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

        // ComboBox for Malt
        Label lblmalt = new Label("Malt Type");
        this.add(lblmalt, 0,5);
        comboMalt.getItems().addAll(Ristning.PILSNER, Ristning.PALE, Ristning.VIENNAMALT);
        comboMalt.setPromptText("Vælg Malt Type");
        this.add(comboMalt, 1, 5);

        Label lblAntalLt = new Label("Malt");
        this.add(lblAntalLt, 0,4);
        this.add(this.txtRistning, 1,4);

        //Button til Opret og Aflyst
        Button btnOpretDestl = new Button("Opret");
        this.add(btnOpretDestl,0,15);
        btnOpretDestl.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        this.add(btnAnnuller,1,15);
        btnAnnuller.setOnAction(event -> this.annullerAction());


    }
    private void opretAction() {

        String batchNr = txtBatchNr.getText();
        String alkoholProcentStr = txtAlkoholProcent.getText();
        Double antalDestLiter = Double.parseDouble(txtAntalLiter.getText());
        LocalDate valgtDato = datePicker.getValue();
        Ristning selectedMalt = comboMalt.getValue();

        if (batchNr.isEmpty() || alkoholProcentStr.isEmpty() || txtAntalLiter.getText().isEmpty()
                || valgtDato == null || selectedMalt == null) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }
        try {
            double alkoholProcent = Double.parseDouble(alkoholProcentStr);
            double antalLiter = antalDestLiter;


            // Gemmer al data i storage
            Controller.getController().opretDestillat(new Destillat(batchNr, alkoholProcentStr
            , antalLiter, valgtDato, selectedMalt));

            // Udskriver data
            System.out.println("Opretter destillering:");
            System.out.println("Batch: " + batchNr);
            System.out.println("Alkohol %: " + alkoholProcent);
            System.out.println("Antal liter: " + antalLiter);
            System.out.println("Dato: " + valgtDato);
            System.out.println("Malt: " + selectedMalt);

            clearFields();
        } catch (NumberFormatException e) {
            System.out.println("Fejl:Indtast korrekt talformat i procent, antal og liter felterne.");
        }

    }
    private void annullerAction() {

        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");

    }

    private void clearFields() {
        txtBatchNr.clear();
        txtAlkoholProcent.clear();
        txtAntalLiter.clear();
        datePicker.setValue(LocalDate.now());
        txtAntalLt.clear();
        comboMalt.getSelectionModel().clearSelection();
    }






}
