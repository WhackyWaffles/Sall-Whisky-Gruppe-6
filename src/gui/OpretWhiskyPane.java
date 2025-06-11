package gui;


import application.controller.Controller;
import application.models.Fad;
import application.models.Ristning;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import application.models.Whisky;

import java.time.LocalDate;

public class OpretWhiskyPane extends GridPane {

    private final TextField txtWhiskyId = new TextField();
    private final TextField txtNavn = new TextField();
    private final TextField txtSlutAlkoholProcent = new TextField();
    private final TextField txtAntalFlasker = new TextField();
    private final DatePicker datePicker = new DatePicker();
    private final ListView<Whisky> lvWhisky = new ListView<>();
    private ObservableList<Whisky> whiskyListe = FXCollections.observableArrayList();
    private final ComboBox<Fad> comboFad = new ComboBox<>();
    private final TextField txtAntalÅr = new TextField();


    public OpretWhiskyPane() {

        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // Label og TextField
        Label lblWhiskyId = new Label("Whisky ID ");
        this.add(lblWhiskyId, 0, 1);
        this.add(this.txtWhiskyId, 1, 1, 3, 1);
        txtWhiskyId.setPromptText("fx. RW105");

        Label lblNavn = new Label("Navn ");
        this.add(lblNavn, 0, 2);
        this.add(this.txtNavn, 1, 2, 3, 1);
        txtNavn.setPromptText("fx. Glød 3.4");

        Label lblAlkoholPrct = new Label("Alkohol % ");
        this.add(lblAlkoholPrct, 0, 3);
        this.add(this.txtSlutAlkoholProcent, 1, 3, 3, 1);
        txtSlutAlkoholProcent.setPromptText("fx. 51");

        Label lblAntalFlasker = new Label("Antal flasker ");
        this.add(lblAntalFlasker, 0, 4);
        this.add(this.txtAntalFlasker, 1, 4, 3, 1);
        txtAntalFlasker.setPromptText("fx. 500");

        Label lblAftapDato = new Label("Aftapningsdato ");
        this.add(lblAftapDato, 0, 5);  //
        datePicker.setValue(LocalDate.now()); // default er i dag
        this.add(datePicker, 1, 5, 3, 1);

        Label lblWhiskyList = new Label("Whisky Lister");
        this.add(lblWhiskyList, 0, 6);
        this.add(this.lvWhisky, 1, 6, 3, 1);

        //Button til Opret og Annullér
        Button btnOpretWhisky = new Button("Opret");
        btnOpretWhisky.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        btnAnnuller.setOnAction(event -> this.annullerAction());

        Button btnRediger = new Button("Redigér");
        btnRediger.setOnAction(event -> this.redigerAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.opdaterLister());

        Button btnRemove = new Button("Fjern");
        btnRemove.setOnAction(event -> this.removeAction());

        Button btnTilknytFad = new Button("Tilknyt fad");
        btnTilknytFad.setOnAction(event -> this.tilføjAction());

        Label tilknytFadlabel = new Label("Tilknyt fad");
        this.add(tilknytFadlabel, 0, 7);
        this.add(comboFad, 1, 7, 1, 1);
        comboFad.getItems().addAll(Controller.getAlleFade());
        comboFad.setPrefWidth(200);
        comboFad.setPromptText("Vælg Fad");
        Label lblAntalÅr = new Label("Antal år:");
        this.add(lblAntalÅr, 2, 7);
        this.add(txtAntalÅr, 3, 7);
        txtAntalÅr.setPromptText("fx. 3");

        //Listview med fade fra Controller
        lvWhisky.setItems(whiskyListe);
        lvWhisky.getItems().addAll(Controller.getAllWhisky());
        lvWhisky.setPrefHeight(200);

        HBox buttonBox = new HBox(15);
        this.add(buttonBox, 0, 8, 4, 1);
        buttonBox.getChildren().addAll(btnOpretWhisky, btnAnnuller, btnOpdater, btnRediger, btnRemove, btnTilknytFad);
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
            Whisky whisky = Controller.opretWhisky(id, navn, antal, String.valueOf(alkohol), dato);
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

    private void redigerAction() {
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
        comboFad.getItems().setAll(Controller.getAlleFade());
    }

    private void opdaterLister(){
        comboFad.getItems().setAll(Controller.getAlleFade());
        System.out.println(("Fadene er opdateret"));
    }

    private void removeAction() {
        Whisky selected = lvWhisky.getSelectionModel().getSelectedItem();

        if (selected == null) {
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

    private void clearFields() {
        txtWhiskyId.clear();
        txtNavn.clear();
        txtSlutAlkoholProcent.clear();
        txtAntalFlasker.clear();
        datePicker.setValue(LocalDate.now());
    }

    private void tilføjAction() {
        Whisky valgtWhisky = lvWhisky.getSelectionModel().getSelectedItem();
        Fad valgtFad = comboFad.getSelectionModel().getSelectedItem();

        try {
            int antalÅr = Integer.parseInt(txtAntalÅr.getText().trim());

            if (valgtWhisky != null && valgtFad != null) {
                valgtWhisky.addFad(valgtFad, antalÅr);

                // Tving ListView til at genopfriske visningen
                int index = whiskyListe.indexOf(valgtWhisky);
                if (index >= 0) {
                    whiskyListe.set(index, valgtWhisky);
                }

                showAlert(Alert.AlertType.INFORMATION, "Tilknyttet!", "Fadet er blevet tilknyttet!");
            } else {
                showAlert(Alert.AlertType.WARNING, "Fejl", "Vælg både en whisky og et fad!");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Indtast et gyldigt antal år.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}