package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Charring;
import models.Fad;
import models.FillNummer;
import models.Påfyldning;

import java.util.ArrayList;


public class OpretFadPane extends GridPane {

    private TextField txtFadNr = new TextField();
    private TextField txtFadType = new TextField();
    private TextField txtFadMateriale = new TextField();
    private TextField txtKapacitet = new TextField();
    private ComboBox<FillNummer> comboFillNr = new ComboBox<>();
    private ComboBox<Charring> comboCharring = new ComboBox<>();
    private ListView<Fad> lvFade = new ListView<>();


    public OpretFadPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        //Labels og textfields
        Label lblFadNr = new Label("Fad nummer");
        this.add(lblFadNr, 0, 1);
        this.add(this.txtFadNr, 1, 1);

        Label lblFadType = new Label("Fad type");
        this.add(lblFadType, 0, 2);
        this.add(this.txtFadType, 1, 2);

        Label lblFadMaterial = new Label("Fad materiale");
        this.add(lblFadMaterial, 0, 3);
        this.add(this.txtFadMateriale, 1, 3);

        Label lblKapacitet = new Label("Kapacitet");
        this.add(lblKapacitet, 0, 4);
        this.add(this.txtKapacitet, 1, 4);

        //Combobox for Fill Nummer
        Label lblFillNr = new Label("Fill nummer");
        this.add(lblFillNr, 0, 5);
        comboFillNr.getItems().addAll(FillNummer.FIRST_FILL, FillNummer.SECOND_FILL, FillNummer.THIRD_FILL);
        comboFillNr.setPromptText("Vælg Fill nummer");
        this.add(comboFillNr, 1, 5);

        // ComboBox for Charring
        Label lblCharring = new Label("Charring");
        this.add(lblCharring, 0, 6);
        comboCharring.getItems().addAll(Charring.LIGHT_TOAST, Charring.MEDIUM_CHAR, Charring.HEAVY_TOAST,
                Charring.NO_CHAR, Charring.LIGHT_CHAR, Charring.MEDIUM_CHAR, Charring.HEAVY_CHAR);
        comboCharring.setPromptText("Vælg Charring");
        this.add(comboCharring, 1, 6);

        // ListView til fade
        Label lblFade = new Label("Oprettede fade");
        this.add(lblFade,0,7);
        this.add(lvFade,0,8,3,1);
        // Fyld ListView med fade fra Controller
        lvFade.getItems().addAll(Controller.getController().getAlleFade());
        lvFade.setPrefSize(450,150); // Sætter en passende højde

        //Button til Opret, Annullér og Opdatér
        Button btnOpretFad = new Button("Opret");
        btnOpretFad.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        btnAnnuller.setOnAction(event -> this.annullerAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.opdaterLister());

        HBox buttonBox = new HBox(30);
        this.add(buttonBox,0,9,3,1);
        buttonBox.getChildren().addAll(btnOpretFad, btnAnnuller, btnOpdater);
    }

    private void opretAction() {
        String fadNr = txtFadNr.getText();
        String fadType = txtFadType.getText();
        String fadMateriale = txtFadMateriale.getText();
        String kapacitet = txtKapacitet.getText();
        FillNummer selectedFillNr = comboFillNr.getValue();
        Charring selectedCharring = comboCharring.getValue();

        if (fadNr.isEmpty() || fadType.isEmpty() || fadMateriale.isEmpty() ||
                kapacitet.isEmpty() || selectedCharring == null || selectedFillNr == null) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }
        try {
            double kapacitetVol = Double.parseDouble(kapacitet);

            // Send en tom ArrayList, hvis der ikke er påfyldninger
            ArrayList<Påfyldning> påfyldninger = new ArrayList<>();

            Controller.getController().opretFad(fadNr,fadType,fadMateriale,kapacitetVol,selectedCharring,selectedFillNr,påfyldninger);

            // Udskriver data om opretning
            System.out.println("Opretter fad:");
            System.out.println("Fad nummer: " + fadNr);
            System.out.println("Fad type: " + fadType);
            System.out.println("Fad materiale: " + fadMateriale);
            System.out.println("Kapacitet: " + kapacitetVol);
            System.out.println("Fill nummer: " + selectedFillNr);
            System.out.println("Charring: " + selectedCharring);

            clearFields();
        } catch (NumberFormatException e) {

        }
    }

    private void annullerAction() {
        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");
    }

    private void clearFields() {
        txtFadNr.clear();
        txtFadType.clear();
        txtFadMateriale.clear();
        txtKapacitet.clear();
        comboFillNr.getSelectionModel().clearSelection();
        comboCharring.getSelectionModel().clearSelection();
    }

    private void opdaterLister(){
        lvFade.getItems().setAll(Controller.getController().getAlleFade());
        System.out.println(("Fadene er opdateret"));
    }
}
