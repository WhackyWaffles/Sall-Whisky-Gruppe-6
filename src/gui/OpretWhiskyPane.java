package gui;


import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Whisky;

import java.time.LocalDate;

public class OpretWhiskyPane extends GridPane {

    private final TextField txtWhiskyId = new TextField();
    private final TextField txtNavn = new TextField();
    private final TextField txtSlutAlkoholProcent = new TextField();
    private final TextField txtAntalFlasker = new TextField();
    private final DatePicker datePicker = new DatePicker();
    private final ListView<Whisky> lvWhisky = new ListView<>();


    public OpretWhiskyPane() {

        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // Label og TextField
        Label lblWhiskyId = new Label("Whisky ID ");
        this.add(lblWhiskyId, 0, 1);
        this.add(this.txtWhiskyId, 1, 1);

        Label lblNavn = new Label("Navn ");
        this.add(lblNavn, 0, 2);
        this.add(this.txtNavn, 1, 2);

        Label lblAlkoholPrct = new Label("Alkohol % ");
        this.add(lblAlkoholPrct, 0, 3);
        this.add(this.txtSlutAlkoholProcent, 1, 3);

        Label lblAntalFlasker = new Label("Antal flasker ");
        this.add(lblAntalFlasker, 0, 4);
        this.add(this.txtAntalFlasker, 1, 4);

        Label lblAftapDato = new Label("Aftapningsdato ");
        this.add(lblAftapDato, 0, 5);  //
        datePicker.setValue(LocalDate.now()); // default er i dag
        this.add(datePicker, 1, 5);

        Label lblWhiskyList = new Label("Whisky Lister");
        this.add(lblWhiskyList,0,6);
        this.add(this.lvWhisky,1,6);

        //Button til Opret og Annullér
        Button btnOpretWhisky = new Button("Opret");
        this.add(btnOpretWhisky, 0, 15);
        btnOpretWhisky.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        this.add(btnAnnuller, 1, 15);
        btnAnnuller.setOnAction(event -> this.annullerAction());


        Button btnUpdate = new Button("Update");
        this.add(btnUpdate, 2, 15);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnRemove = new Button("Fjern");
        this.add(btnRemove, 3, 15);  // Position it appropriately
        btnRemove.setOnAction(event -> this.removeAction());

        //Listview med fade fra Controller
        lvWhisky.getItems().addAll(Controller.getAllWhisky());
        lvWhisky.setPrefHeight(200);

        HBox buttonBox = new HBox(30);
        this.add(buttonBox,0,7,2,1);
        buttonBox.getChildren().addAll(btnOpretWhisky, btnAnnuller, btnUpdate, btnRemove);
    }

    private void opretAction() {
        String id = txtWhiskyId.getText();
        String navn = txtNavn.getText();
        String antalStr = txtAntalFlasker.getText();
        String alkoholStr = txtSlutAlkoholProcent.getText();
        LocalDate dato = datePicker.getValue();

        if (id.isEmpty() || navn.isEmpty() || alkoholStr.isEmpty() || antalStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Alle felter skal udfyldes.");
            return;
        }
        try {
            double alkohol = Double.parseDouble(alkoholStr);
            int antal = Integer.parseInt(antalStr);

            Whisky existing = Controller.findWhiskyById(id);
            if (existing != null) {
                showAlert(Alert.AlertType.ERROR, "Fejl", "Whisky med ID " + id + " findes allerede.");
                return;
            }
            Whisky whisky = Controller.opretWhisky(id, navn, antal, String.valueOf(alkohol), dato, null);
            lvWhisky.getItems().add(whisky);
            showAlert(Alert.AlertType.INFORMATION, "Oprettet", "Whisky er oprettet.");
            clearFields();

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Antal flasker og alkoholprocent skal være gyldige tal.");
        }
    }

    private void annullerAction() {
        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");
    }

    private void updateAction() {

        String id = txtWhiskyId.getText().trim();
        Whisky whisky = Controller.findWhiskyById(id);
        if (whisky == null) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Whisky med ID " + id + " blev ikke fundet.");
            return;
        }

        String navn = txtNavn.getText().trim();
        String alkoholStr = txtSlutAlkoholProcent.getText().trim();
        String antalStr = txtAntalFlasker.getText().trim();
        LocalDate dato = datePicker.getValue();
        if (navn.isEmpty() || alkoholStr.isEmpty() || antalStr.isEmpty() || dato == null) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Alle felter skal udfyldes.");
            return;
        }
        try {
            double alkohol = Double.parseDouble(alkoholStr);
            int antal = Integer.parseInt(antalStr);

            whisky.setNavn(navn);
            whisky.setSlutAlkoholProcent(String.valueOf(alkohol));
            whisky.setFlaskeNr(antal);
            whisky.setAftapningsDato(dato);

            lvWhisky.refresh(); // Update view
            showAlert(Alert.AlertType.INFORMATION, "Opdateret", "Whisky er opdateret.");
            clearFields();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Antal flasker og alkoholprocent skal være gyldige tal.");
        }
    }

    private void removeAction(){
        Whisky selected = lvWhisky.getSelectionModel().getSelectedItem();

        if(selected == null) {
            showAlert(Alert.AlertType.WARNING, "Ingen valgt", "Vælg en whisky, der skal fjernes.");
            return;
        }
        boolean removed = Controller.removeWhiskyById(selected.getWhiskyId());
        if (removed) {
            lvWhisky.getItems().remove(selected);
            showAlert(Alert.AlertType.INFORMATION, "Fjernet", "Whisky er blevet fjernet.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Kunne ikke fjerne whisky.");
        }
    }

    private void clearFields () {
        txtWhiskyId.clear();
        txtNavn.clear();
        txtSlutAlkoholProcent.clear();
        txtAntalFlasker.clear();
        datePicker.setValue(LocalDate.now());
    }

    private void showAlert (Alert.AlertType type, String title, String message){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}