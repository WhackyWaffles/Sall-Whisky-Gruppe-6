package gui;

import application.controller.Controller;
import application.models.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class OpretFadPane extends GridPane {

    private final TextField txtFadNr = new TextField();
    private final ComboBox<FadType> comboFadType = new ComboBox<>();
    private final TextField txtFadMateriale = new TextField();
    private final TextField txtKapacitet = new TextField();
    private final ComboBox<FillNummer> comboFillNr = new ComboBox<>();
    private final ComboBox<Charring> comboCharring = new ComboBox<>();
    private final ListView<Fad> lvFade = new ListView<>();
    private final Label errorLabel = new Label();
    private final Label infoLabel = new Label();


    public OpretFadPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //Labels og textfields
        Label lblFadNr = new Label("Fad nummer");
        this.add(lblFadNr, 0, 1);
        this.add(this.txtFadNr, 1, 1);
        txtFadNr.setPromptText("fx. 73");

        // ComboBox for Fadtype
        Label lblFadType = new Label("Fad type");
        this.add(lblFadType, 0, 2);
        comboFadType.getItems().addAll(FadType.EX_OLOROSO, FadType.EX_BOURBON, FadType.EX_CRUZAN, FadType.EX_ISLAY);
        comboFadType.setPromptText("Vælg Fadtype");
        this.add(comboFadType, 1, 2);

        Label lblFadMaterial = new Label("Fad materiale");
        this.add(lblFadMaterial, 0, 3);
        this.add(this.txtFadMateriale, 1, 3);
        txtFadMateriale.setPromptText("fx. Egetræ");

        Label lblKapacitet = new Label("Kapacitet");
        this.add(lblKapacitet, 0, 4);
        this.add(this.txtKapacitet, 1, 4);
        txtKapacitet.setPromptText("fx. 100");

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
        lvFade.getItems().addAll(Controller.getAlleFade());
        lvFade.setPrefSize(450,150); // Sætter en passende højde

        //Button til Opret, Annullér og Opdatér
        Button btnOpretFad = new Button("Opret");
        btnOpretFad.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annullér");
        btnAnnuller.setOnAction(event -> this.annullerAction());

        Button btnOpdater = new Button("Opdatér");
        btnOpdater.setOnAction(event -> this.opdaterLister());

        HBox buttonBox = new HBox(45);
        this.add(buttonBox,0,9,3,1);
        buttonBox.getChildren().addAll(btnOpretFad, btnAnnuller, btnOpdater);

        // InfoLabel til at informere User, hvad der er sket.
        this.add(infoLabel, 0, 10, 4, 1);
        infoLabel.setTextFill(Color.DODGERBLUE);

        // ErrorLabel til at vise, hvad der er galt.
        this.add(errorLabel, 0, 11, 4, 1);
        errorLabel.setTextFill(Color.RED);
    }

    private void opretAction() {
        String fadNr = txtFadNr.getText();
        FadType selectedFadType = comboFadType.getValue();
        String fadMateriale = txtFadMateriale.getText();
        String kapacitet = txtKapacitet.getText();
        FillNummer selectedFillNr = comboFillNr.getValue();
        Charring selectedCharring = comboCharring.getValue();

        if (fadNr.isEmpty() || selectedFadType == null || fadMateriale.isEmpty() ||
                kapacitet.isEmpty() || selectedCharring == null || selectedFillNr == null) {
            System.out.println("Udfyld venligst alle felter.");
            errorLabel.setText("Udfyld venligst alle felter.");
            return;
        }

        try {
            double kapacitetVol = Double.parseDouble(kapacitet);

            // Send en tom ArrayList, hvis der ikke er påfyldninger
            ArrayList<Påfyldning> påfyldninger = new ArrayList<>();

            Controller.opretFad(fadNr,selectedFadType,fadMateriale,kapacitetVol,selectedCharring,selectedFillNr,påfyldninger);
            lvFade.getItems().setAll(Controller.getAlleFade());

            // Udskriver data om opretning
            infoLabel.setText("Fad oprettet!");
            System.out.println("Opretter fad:");
            System.out.println("Fad nummer: " + fadNr);
            System.out.println("Fad type: " + selectedFadType);
            System.out.println("Fad materiale: " + fadMateriale);
            System.out.println("Kapacitet: " + kapacitetVol);
            System.out.println("Fill nummer: " + selectedFillNr);
            System.out.println("Charring: " + selectedCharring);

            errorLabel.setText("");
            clearFields();
        } catch (NumberFormatException e) {
            System.out.println("Fejl: Kapacitet skal være et tal.");
        }
    }

    private void annullerAction() {
        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");
    }

    private void clearFields() {
        txtFadNr.clear();
        comboFadType.getSelectionModel().getSelectedItem();
        txtFadMateriale.clear();
        txtKapacitet.clear();
        comboFillNr.getSelectionModel().clearSelection();
        comboCharring.getSelectionModel().clearSelection();
    }

    private void opdaterLister(){
        lvFade.getItems().setAll(Controller.getAlleFade());
        System.out.println(("Fadene er opdateret"));
    }
}
