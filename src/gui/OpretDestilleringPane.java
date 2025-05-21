package gui;

import application.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import application.models.Destillat;
import application.models.Ristning;

import java.time.LocalDate;

public class OpretDestilleringPane extends GridPane {

    private final TextField txtBatchNr = new TextField();
    private final TextField txtAlkoholProcent = new TextField();
    private final TextField txtAntalLiter = new TextField();
    private final ComboBox<Ristning> comboMalt = new ComboBox<>();
    private final DatePicker datePicker = new DatePicker();
    private final ListView<Destillat> lvDestillater = new ListView<>();

    public OpretDestilleringPane() {

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.datePicker.setValue(LocalDate.now());

        //Label og textfield
        Label lblBatchNr = new Label("Spirit batch");
        this.add(lblBatchNr, 0,1);
        this.add(this.txtBatchNr, 1,1);

        Label lblAlkoholProcent = new Label("Alkohol %");
        this.add(lblAlkoholProcent, 0,2);
        this.add(this.txtAlkoholProcent, 1,2);

        Label lblAntalLiter = new Label("Antal liter");
        this.add(lblAntalLiter, 0,3);
        this.add(this.txtAntalLiter, 1,3);

        Label lblDato = new Label("Dato ");
        this.add(lblDato, 0, 4);  //
        datePicker.setValue(LocalDate.now()); // default to today
        this.add(datePicker, 1, 4);

        // ComboBox for Malt
        Label lblmalt = new Label("Malt Type");
        this.add(lblmalt, 0,5);
        comboMalt.getItems().addAll(Ristning.PILSNERMALT, Ristning.PALEMALT,Ristning.VIENNAMALT,
                Ristning.PILSNERMALT_RØGET,Ristning.PALEMALT_RØGET, Ristning.VIENNAMALT_RØGET);
        comboMalt.setPromptText("Vælg Malt Type");
        this.add(comboMalt, 1, 5);

        Label lbldestillater = new Label("Destillater");
        this.add(lbldestillater,0,6);
        this.add(this.lvDestillater, 0,7,3,1);
        // Fyld ListView med destillater fra Controller
        lvDestillater.getItems().addAll(Controller.getAllDestillater());
        lvDestillater.setPrefSize(300,150); // Sætter en passende højde

        //Button til Opret, Annullér og Opdater
        Button btnOpretDestl = new Button("Opret");
        this.add(btnOpretDestl,0,15);
        btnOpretDestl.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        this.add(btnAnnuller,1,15);
        btnAnnuller.setOnAction(event -> this.annullerAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.updaterLister());

        HBox buttonBox = new HBox(30);
        this.add(buttonBox,0,8,2,1);
        buttonBox.getChildren().addAll(btnOpretDestl, btnAnnuller, btnOpdater);
    }

    private void opretAction() {
        String batchNr = txtBatchNr.getText();
        String alkoholProcentStr = txtAlkoholProcent.getText();
        double antalDestLiter = Double.parseDouble(txtAntalLiter.getText());
        LocalDate valgtDato = datePicker.getValue();
        Ristning selectedMalt = comboMalt.getValue();

        if (batchNr.isEmpty() || alkoholProcentStr.isEmpty() || txtAntalLiter.getText().isEmpty()
                || valgtDato == null || selectedMalt == null) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }

        try {
            double antalLiter = Double.parseDouble(txtAntalLiter.getText());

            // Gemmer al data i storage
            Controller.opretDestillat(batchNr, alkoholProcentStr, antalLiter, valgtDato, selectedMalt);

        } catch (NumberFormatException e) {
            System.out.println("Fejl:Indtast korrekt talformat i procent, antal og liter felterne.");
        }

        // Udskriver data
        System.out.println("Opretter destillat:");
        System.out.println("Batch: " + batchNr);
        System.out.println("Alkohol %: " + alkoholProcentStr);
        System.out.println("Antal liter: " + antalDestLiter);
        System.out.println("Dato: " + valgtDato);
        System.out.println("Malt: " + selectedMalt);
    }

    private void clearFields() {
        txtBatchNr.clear();
        txtAlkoholProcent.clear();
        txtAntalLiter.clear();
        datePicker.setValue(LocalDate.now());
        comboMalt.getSelectionModel().clearSelection();
    }

    private void annullerAction() {
        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");
    }

    private void updaterLister(){
        lvDestillater.getItems().setAll(Controller.getAllDestillater());
        System.out.println(("Destillaterne er opdateret"));
    }
}
