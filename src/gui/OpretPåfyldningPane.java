package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class OpretPåfyldningPane extends GridPane {

    private TextField txtNavn = new TextField();
    private TextField txtDestillering = new TextField();
    private TextField txtFad = new TextField();
    private TextField txtLiter = new TextField();
    private DatePicker datePicker = new DatePicker();

    public OpretPåfyldningPane() {

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);


        //Label og textfield
        Label lblNavn = new Label("Navn ");
        this.add(lblNavn, 0, 1);
        this.add(this.txtNavn, 1, 1);

        Label lblDestillering = new Label("Destillering");
        this.add(lblDestillering, 0, 2);
        this.add(this.txtDestillering, 1, 2);

        Label lblFad = new Label("Fad ");
        this.add(lblFad, 0, 3);
        this.add(this.txtFad, 1, 3);

        Label lblLiter = new Label("Liter ");
        this.add(lblLiter, 0, 4);
        this.add(this.txtLiter, 1, 4);

        Label lblDato = new Label("Dato ");
        this.add(lblDato, 0, 5);  //
        datePicker.setValue(LocalDate.now()); // default to today
        this.add(datePicker, 1, 5);

        //Button til Opret og Annuller
        Button btnOpretPåfyld = new Button("Opret");
        this.add(btnOpretPåfyld, 0, 18);
        btnOpretPåfyld.setOnAction(event -> this.opretPåfyldAction());

        Button btnAnnuller = new Button("Annuller");
        this.add(btnAnnuller, 2, 18);
        btnAnnuller.setOnAction(event -> this.aflystPåfyldAction());

    }

    private void opretPåfyldAction() {
        String navn = txtNavn.getText();
        String destillering = txtDestillering.getText();
        String fad = txtFad.getText();
        String liter = txtLiter.getText();
        LocalDate valgtDato = datePicker.getValue();

        if (navn.isEmpty() || destillering.isEmpty() || fad.isEmpty() ||
                liter.isEmpty()) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }
        try {
            if (!liter.matches("\\d+\\.\\d+")) {
                System.out.println("Fejl: 'Liter' skal være et decimaltal (f.eks. 12.5).");
                return;
            }
            double påfyldningliter = Double.parseDouble(liter);
            if (påfyldningliter <= 0) {
                System.out.println("Fejl: Liter skal være større end 0.");
                return;
            }


            //Gemmer alle dataoen
            System.out.println("Opretter påfyldning:");
            System.out.println("Navn: " + navn);
            System.out.println("Destillering: " + destillering);
            System.out.println("fad: " + fad);
            System.out.println("Antal liter: " + liter);
            System.out.println("Dato: " + valgtDato);

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
        txtNavn.clear();
        txtDestillering.clear();
        txtFad.clear();
        txtLiter.clear();
        datePicker.setValue(LocalDate.now());

    }
}

