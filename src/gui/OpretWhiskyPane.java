package gui;


import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Whisky;
import storage.Storage;


import java.time.LocalDate;

public class OpretWhiskyPane extends GridPane {

    private final Controller controller =Controller.getController();;
    private TextField txtWhiskyId = new TextField();
    private TextField txtNavn = new TextField();
    private TextField txtslutAlkoholProcent = new TextField();
    private TextField txtAntalFlasker = new TextField();
    private DatePicker datePicker = new DatePicker();
    private ListView<Whisky> lvWhisky = new ListView<>();


    public OpretWhiskyPane() {

        this.setPadding(new Insets(20));
        this.setHgap(10);
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
        this.add(this.txtslutAlkoholProcent, 1, 3);

        Label lblAntalFlasker = new Label("Antal flasker ");
        this.add(lblAntalFlasker, 0, 4);
        this.add(this.txtAntalFlasker, 1, 4);

        Label lblAftapDato = new Label("Aftapningsdato ");
        this.add(lblAftapDato, 0, 5);  //
        datePicker.setValue(LocalDate.now());// default idag
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


        Button btnOpdate = new Button("Opdate");
        this.add(btnOpdate, 2, 15);
        btnOpdate.setOnAction(event -> this.opdateAction());

        Button btnRemove = new Button("Fjern");
        this.add(btnRemove, 3, 15);  // Position it appropriately
        btnRemove.setOnAction(event -> this.removeAction());

        //Listview med fade fra Controller
        lvWhisky.getItems().addAll(Controller.getController().getAllWhisky());
        lvWhisky.setPrefHeight(200);

        HBox buttonBox = new HBox(30);
        this.add(buttonBox,0,7,2,1);
        buttonBox.getChildren().addAll(btnOpretWhisky, btnAnnuller, btnOpdate, btnRemove);
    }

    private void opretAction() {
        String id = txtWhiskyId.getText();
        String navn = txtNavn.getText();
        String antalStr = txtAntalFlasker.getText();
        String alkoholStr = txtslutAlkoholProcent.getText();
        LocalDate dato = datePicker.getValue();

        if (id.isEmpty() || navn.isEmpty() || alkoholStr.isEmpty() || antalStr.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Alle felter skal udfyldes.");
            return;
        }
        try {
            double alkohol = Double.parseDouble(alkoholStr);
            int antal = Integer.parseInt(antalStr);

            Whisky existing = controller.findWhiskyById(id);
            if (existing != null) {
                showAlert(Alert.AlertType.ERROR, "Fejl", "Whisky med ID " + id + " findes allerede.");
                return;
            }
            Whisky whisky = controller.opretWhisky(id, navn, antal, String.valueOf(alkohol), dato, null);
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

    private void opdateAction() {

        String id = txtWhiskyId.getText().trim();
        Whisky whisky = controller.findWhiskyById(id);
        if (whisky == null) {
            showAlert(Alert.AlertType.ERROR, "Fejl", "Whisky med ID " + id + " blev ikke fundet.");
            return;
        }

        String navn = txtNavn.getText().trim();
        String alkoholStr = txtslutAlkoholProcent.getText().trim();
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
        boolean removed = controller.removeWhiskyById(selected.getWhiskyId());
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
        txtslutAlkoholProcent.clear();
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