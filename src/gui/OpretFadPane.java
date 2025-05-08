package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class OpretFadPane extends GridPane {

    private TextField txtFadNr = new TextField();
    private TextField txtFadType = new TextField();
    private TextField txtFadMateriale = new TextField();
    private TextField txtKapacitet = new TextField();
    private ComboBox<String> comboFillNr = new ComboBox<>();
    private ComboBox<String> comboCherring = new ComboBox<>();


    public OpretFadPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        //Label og textfield

        Label lblFadNr = new Label("Fad Nummer ");
        this.add(lblFadNr, 0, 1);
        this.add(this.txtFadNr, 1, 1);

        Label lblFadType = new Label("Fad Type ");
        this.add(lblFadType, 0, 2);
        this.add(this.txtFadType, 1, 2);

        Label lblFadMaterial = new Label("Fad Materiale ");
        this.add(lblFadMaterial, 0, 3);
        this.add(this.txtFadMateriale, 1, 3);

        Label lblKapacitet = new Label("Kapacitet ");
        this.add(lblKapacitet, 0, 4);
        this.add(this.txtKapacitet, 1, 4);

        //Combobox for Fill Nummer
        Label lblFillNr = new Label("Fill Nummer");
        this.add(lblFillNr, 0, 5);
        comboFillNr.getItems().addAll("First fill ", "Second fill ", "Third fill");
        comboFillNr.setPromptText("Vælg Fill nummer");
        this.add(comboFillNr, 1, 5);

        // ComboBox for Cherring
        Label lblCherring = new Label("Cherring ");
        this.add(lblCherring, 0, 6);
        comboCherring.getItems().addAll("Light Toast ", "Medium Toast ", "Heavy Toast ", "No Char ",
                "Light Char ", "Medium Char ", "Heavy Char ");
        comboCherring.setPromptText("Vælg Cherring  ");
        this.add(comboCherring, 1, 6);

        //Button til Opret og Annuler
        Button btnOpretFad = new Button("Opret");
        this.add(btnOpretFad, 0, 18);
        btnOpretFad.setOnAction(event -> this.opretAction());

        Button btnAnnuller = new Button("Annuller");
        this.add(btnAnnuller, 2, 18);
        btnAnnuller.setOnAction(event -> this.aflystAction());

    }

    private void opretAction() {

        String fadNr = txtFadNr.getText();
        String fadType = txtFadType.getText();
        String fadMateriale = txtFadMateriale.getText();
        String kapacitet = txtKapacitet.getText();
        String selectedFillNr = comboFillNr.getValue();
        String selectedCherring = comboCherring.getValue();

        if (fadNr.isEmpty() || fadType.isEmpty() || fadMateriale.isEmpty() ||
                kapacitet.isEmpty() || selectedCherring == null || selectedFillNr == null) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }
        try {
            double kapacitetVal = Double.parseDouble(kapacitet);


            //Gemmer alle dataoen
            System.out.println("Opretter fad:");
            System.out.println("Fad Nummer: " + fadNr);
            System.out.println("Fad Type: " + fadType);
            System.out.println("Fad materiale: " + fadMateriale);
            System.out.println("Kapacitet: " + kapacitet);
            System.out.println("Fill Nummer: " + selectedFillNr);
            System.out.println("Cherring: " + selectedCherring);

            clearFields();
        } catch (NumberFormatException e) {

        }
    }

    private void aflystAction() {

        clearFields();
        System.out.println("Handling annulleret. Felter nulstillet.");

    }

    private void clearFields() {
        txtFadNr.clear();
        txtFadType.clear();
        txtFadMateriale.clear();
        txtKapacitet.clear();
        comboFillNr.getSelectionModel().clearSelection();
        comboCherring.getSelectionModel().clearSelection();

    }

}
