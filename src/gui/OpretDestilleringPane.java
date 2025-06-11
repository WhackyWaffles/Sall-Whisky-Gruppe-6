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
import javafx.scene.paint.Color;

import java.time.LocalDate;

public class OpretDestilleringPane extends GridPane {

    private final TextField txtBatchNr = new TextField();
    private final TextField txtAlkoholProcent = new TextField();
    private final TextField txtAntalLiter = new TextField();
    private final ComboBox<Ristning> comboMalt = new ComboBox<>();
    private final DatePicker datePicker = new DatePicker();
    private final ListView<Destillat> lvDestillater = new ListView<>();
    private final Label errorLabel = new Label();
    private final Label infoLabel = new Label();

    public OpretDestilleringPane() {

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.datePicker.setValue(LocalDate.now());

        //Label og textfield
        Label lblBatchNr = new Label("Spirit batch");
        this.add(lblBatchNr, 0, 1);
        this.add(this.txtBatchNr, 1, 1);
        txtBatchNr.setPromptText("fx. NM105");

        Label lblAlkoholProcent = new Label("Alkohol %");
        this.add(lblAlkoholProcent, 0, 2);
        this.add(this.txtAlkoholProcent, 1, 2);
        txtAlkoholProcent.setPromptText("fx. 73.0");

        Label lblAntalLiter = new Label("Antal liter");
        this.add(lblAntalLiter, 0, 3);
        this.add(this.txtAntalLiter, 1, 3);
        txtAntalLiter.setPromptText("fx. 400");

        Label lblDato = new Label("Dato ");
        this.add(lblDato, 0, 4);  //
        datePicker.setValue(LocalDate.now()); // default to today
        this.add(datePicker, 1, 4);

        // ComboBox for Malt
        Label lblmalt = new Label("Malt Type");
        this.add(lblmalt, 0, 5);
        comboMalt.getItems().addAll(Ristning.PILSNERMALT, Ristning.PALEMALT, Ristning.VIENNAMALT,
                Ristning.PILSNERMALT_RØGET, Ristning.PALEMALT_RØGET, Ristning.VIENNAMALT_RØGET);
        comboMalt.setPromptText("Vælg Malt Type");
        this.add(comboMalt, 1, 5);

        Label lbldestillater = new Label("Destillater");
        this.add(lbldestillater, 0, 6);
        this.add(this.lvDestillater, 0, 7, 3, 1);
        // Fyld ListView med destillater fra Controller
        lvDestillater.getItems().addAll(Controller.getAllDestillater());
        lvDestillater.setPrefSize(300, 150); // Sætter en passende højde

        //Button til Opret, Annullér og Opdater
        Button btnOpretDestl = new Button("Opret");
        this.add(btnOpretDestl, 0, 15);
        btnOpretDestl.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        this.add(btnAnnuller, 1, 15);
        btnAnnuller.setOnAction(event -> this.annullerAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.updaterLister());

        HBox buttonBox = new HBox(45);
        this.add(buttonBox, 0, 8, 3, 1);
        buttonBox.getChildren().addAll(btnOpretDestl, btnAnnuller, btnOpdater);

        // InfoLabel til at informere User, hvad der er sket.
        this.add(infoLabel, 0, 9, 4, 1);
        infoLabel.setTextFill(Color.DODGERBLUE);

        // ErrorLabel til at vise, hvad der er galt.
        this.add(errorLabel, 0, 10, 4, 1);
        errorLabel.setTextFill(Color.RED);
    }

    private void opretAction() {
        String batchNr = txtBatchNr.getText();
        String alkoholProcent = txtAlkoholProcent.getText();
        LocalDate valgtDato = datePicker.getValue();
        Ristning selectedMalt = comboMalt.getValue();

        if (batchNr.isEmpty() || alkoholProcent == null || txtAntalLiter.getText().isEmpty()
                || valgtDato == null || selectedMalt == null) {
            errorLabel.setText("Udfyld venligst alle felter.");
            System.out.println("Udfyld venligst alle felter.");
            return;
        }

        try {
            double antalLiter = Double.parseDouble(txtAntalLiter.getText());
            double alkoholProcentVol = Double.parseDouble(alkoholProcent);

            // Gemmer al data i storage
            Controller.opretDestillat(batchNr, alkoholProcentVol, antalLiter, valgtDato, selectedMalt);
            lvDestillater.getItems().setAll(Controller.getAllDestillater());

            // Udskriver data
            clearFields();
            errorLabel.setText("");
            infoLabel.setText("Destillat oprettet!");
            System.out.println("Opretter destillat:");
            System.out.println("Batch: " + batchNr);
            System.out.println("Alkohol %: " + alkoholProcent);
            System.out.println("Antal liter: " + antalLiter);
            System.out.println("Dato: " + valgtDato);
            System.out.println("Malt: " + selectedMalt);

        } catch (NumberFormatException e) {
            System.out.println("Fejl:Indtast korrekt talformat i procent, antal og liter felterne.");
            showAlert(Alert.AlertType.ERROR, "Fejl", "Fejl: Indtast korrekt talformat!");
        }
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

    private void updaterLister() {
        lvDestillater.getItems().setAll(Controller.getAllDestillater());
        System.out.println(("Destillaterne er opdateret"));
    }

    private void showAlert (Alert.AlertType type, String title, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
