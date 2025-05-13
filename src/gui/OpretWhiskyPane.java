package gui;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class OpretWhiskyPane extends GridPane {

    private TextField txtWhiskyId = new TextField();
    private TextField txtNavn = new TextField();
    private TextField  txtAlkoholPrct = new TextField();
    private TextField txtAntalFlasker = new TextField();
    private DatePicker datePicker = new DatePicker();


    public OpretWhiskyPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //Label og Textfield
        Label lblWhiskyId = new Label("Whisky ID ");
        this.add(lblWhiskyId, 0, 1);
        this.add(this.txtWhiskyId, 1, 1);

        Label lblNavn = new Label("Navn ");
        this.add(lblNavn, 0, 2);
        this.add(this.txtNavn, 1, 2);

        Label lblAlkoholPrct = new Label("Alkohol % ");
        this.add(lblAlkoholPrct, 0, 3);
        this.add(this.txtAlkoholPrct, 1, 3);

        Label lblAntalFlasker = new Label("Antal flasker ");
        this.add(lblAntalFlasker, 0, 4);
        this.add(this.txtAntalFlasker, 1, 4);

        Label lblAftapDato = new Label("Aftapningsdato ");
        this.add(lblAftapDato, 0, 5);  //
        datePicker.setValue(LocalDate.now());// default idag
        this.add(datePicker, 1, 5);

        //Button til Opret og Annullér
        Button btnOpretDestl = new Button("Opret");
        this.add(btnOpretDestl, 0, 15);
        btnOpretDestl.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        this.add(btnAnnuller, 1, 15);
        btnAnnuller.setOnAction(event -> this.annullerAction());

    }


    private void opretAction() {

        String whiskyId = txtWhiskyId.getText();
        String navn = txtNavn.getText();
        String alkoholPrctStr = txtAlkoholPrct.getText();
        String antalFlaskerStr = txtAntalFlasker.getText();
        LocalDate aftapningsdato = datePicker.getValue();

        if (whiskyId.isEmpty() || navn.isEmpty() || alkoholPrctStr.isEmpty() || antalFlaskerStr.isEmpty() || aftapningsdato == null) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Udfyld venligst alle felter.");
            return;
        }
        double alkoholPrct;
        int antalFlasker;


        try {
            alkoholPrct = Double.parseDouble(alkoholPrctStr);
            antalFlasker = Integer.parseInt(antalFlaskerStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Alkohol % og antal flasker skal være tal.");
            return;
        }
        showAlert(Alert.AlertType.INFORMATION, "Whisky oprettet", "Whisky '" + navn + "' er oprettet.");
        clearFields();

    }
    private void annullerAction() {
        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");
    }

    private void sletAction() {

        String whiskyId = txtWhiskyId.getText();
        if (whiskyId.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Indtast venligst Whisky ID for at slette.");
            return;
        }


    }
    private void opdateAction() {
        String whiskyId = txtWhiskyId.getText();
        String navn = txtNavn.getText();
        String alkoholPrct = txtAlkoholPrct.getText();
        String antalFlaskerStr = txtAntalFlasker.getText();
        LocalDate aftapningsdato = datePicker.getValue();


    }

    private void clearFields() {

        txtWhiskyId.clear();
        txtNavn.clear();
        txtAlkoholPrct.clear();
        txtAntalFlasker.clear();

    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
