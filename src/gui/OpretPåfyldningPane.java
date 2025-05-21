package gui;

import application.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import application.models.Destillat;
import application.models.Fad;
import application.models.Påfyldning;

import java.time.LocalDate;

public class OpretPåfyldningPane extends GridPane {

    private final TextField txtIdNr = new TextField();
    private final ListView<Destillat> lvDestillater = new ListView<>();
    private final ListView<Fad> lvFade = new ListView<>();
    private final TextField txtLiter = new TextField();
    private final DatePicker datePicker = new DatePicker();
    private final ListView<Påfyldning> lvPåfyldning = new ListView<>();

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
        lvFade.getItems().addAll(Controller.getAlleFade());
        lvFade.setPrefSize(300,150);

        // Fyld ListView med destillater fra Controller
        lvDestillater.getItems().addAll(Controller.getAllDestillater());
        lvDestillater.setPrefSize(300,150);

        // Label og listview til oprettede påfyldninger
        Label lblPåfyldninger = new Label("Påfyldninger");
        this.add(lblPåfyldninger,0,7);
        this.add(lvPåfyldning,0,8,2,1);

        // Fyld ListView med påfyldninger fra Controller
        lvPåfyldning.getItems().addAll(Controller.getAllePåfyldninger());
        lvPåfyldning.setPrefSize(300,150);

        //Button til Opret, Annullér og Opdatér
        Button btnOpretPåfyld = new Button("Opret");
        btnOpretPåfyld.setOnAction(event -> this.opretPåfyldAction());

        Button btnAnnuller = new Button("Annullér");
        btnAnnuller.setOnAction(event -> this.aflystPåfyldAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.updaterLister());

        HBox buttonBox = new HBox(30);
        this.add(buttonBox,0,9,3,1);
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
            Controller.opretPåfyldning(idNr, destillat, fad, påfyldningLiterStr, valgtDato);

            // Udskriv data
            System.out.println("Opretter påfyldning:");
            System.out.println("IDnr: " + idNr);
            System.out.println("Destillat: " + destillat.getBatchNr());
            System.out.println("Fad: " + fad.getFadNr());
            System.out.println("Antal liter: " + påfyldningLiter);
            System.out.println("Dato: " + valgtDato);

            updaterLister();
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
        lvFade.getItems().setAll(Controller.getAlleFade());
        lvDestillater.getItems().setAll(Controller.getAllDestillater());
        lvPåfyldning.getItems().setAll(Controller.getAllePåfyldninger());
        System.out.println(("Listerne er opdateret"));
    }
}

