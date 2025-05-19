package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import models.*;
import storage.Storage;

import java.util.ArrayList;


public class OpretLagerPane extends GridPane {

    private TextField txtLagerNavn = new TextField();
    private TextField txtLagerLokation = new TextField();
    private TextField txtAntalReoler = new TextField();
    private TextField txtReolHylder = new TextField();
    private TextField txtHyldePladser = new TextField();
    Button btnOpretLager = new Button("Opret lager");
    private ComboBox<Lager> comboLager = new ComboBox<>();
    private ListView<Fad> lvSeFadePåLager = new ListView<>();
    private ListView<Fad> lvFadeTilLager = new ListView<>();

    public OpretLagerPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //Labels og textfields
        javafx.scene.control.Label lblLagerNavn = new javafx.scene.control.Label("Lager navn");
        this.add(lblLagerNavn, 0, 0);
        this.add(this.txtLagerNavn, 1, 0);

        javafx.scene.control.Label lblLagerLokation = new javafx.scene.control.Label("Lager lokation");
        this.add(lblLagerLokation, 0, 1);
        this.add(this.txtLagerLokation, 1, 1);

        javafx.scene.control.Label lblLagerReoler = new javafx.scene.control.Label("Lager reoler");
        this.add(lblLagerReoler, 2, 0);
        this.add(this.txtAntalReoler, 3, 0);

        Label lblReolHylder = new Label("Hylder per reol");
        this.add(lblReolHylder, 2, 1);
        this.add(txtReolHylder, 3, 1);

        Label lblHyldePladser = new Label("Pladser per hylde");
        this.add(lblHyldePladser, 2, 2);
        this.add(txtHyldePladser, 3, 2);

        // Opret Lager knap
        btnOpretLager.setOnAction(event -> opretAction());
        this.add(btnOpretLager, 0, 2,2,1);

        // ComboBox for lagre
//        Label lblLager = new Label("Vælg lager");
//        this.add(lblLager, 0, 3);

        comboLager.getItems().setAll(Storage.getAllLagerhuse()); // Fyld combobox med lagre
        comboLager.setPromptText("Vælg lager");
        this.add(comboLager, 0, 3,2,1);

        // Sørg for at opdatere listen af fade, når et lager vælges
        comboLager.setOnAction(event -> opdaterFadePåLager());

        Label lblSeFadePåLager = new Label("Fade på lager");
        this.add(lblSeFadePåLager, 0, 4,2,1);
        this.add(lvSeFadePåLager, 0, 5,4,1);
        // Fyld ListView med fade på lager fra Controller
        lvSeFadePåLager.getItems().setAll(Controller.getFadePåLager(comboLager.getValue())); //
        lvSeFadePåLager.setPrefSize(250,100);

        // ListView til fade, der skal tilknyttes lager
        Label lblSeFadeTilLager = new Label("Fade til lagring");
        this.add(lblSeFadeTilLager, 0, 6,2,1);
        this.add(lvFadeTilLager, 0,7,4,1);
        // Fyld ListView med fade til lager fra Controller
        lvFadeTilLager.getItems().setAll(Controller.getAlleFade()); //
        lvFadeTilLager.setPrefSize(250,100);



    }

    private void opretAction() {
        String navn = txtLagerNavn.getText();
        String lokation = txtLagerLokation.getText();

        if (txtAntalReoler.getText().isEmpty() || txtReolHylder.getText().isEmpty() || txtHyldePladser.getText().isEmpty()) {
            System.out.println("Udfyld venligst alle felter.");
            return;
        }

        try {
            int antalReoler = Integer.parseInt(txtAntalReoler.getText());
            int antalHylder = Integer.parseInt(txtReolHylder.getText());
            int antalPladserPerHylde = Integer.parseInt(txtHyldePladser.getText());

            // Opret lager i Controller
            Controller.opretLager(navn,lokation,antalReoler,antalHylder,antalPladserPerHylde);

            System.out.println("Lager oprettet: " + navn + " med " + antalReoler + " reoler.");
            clearFields();

            comboLager.getItems().setAll(Storage.getAllLagerhuse()); // Opdater lagre efter oprettelse

        } catch (
                NumberFormatException e) {
            System.out.println("Fejl: Antal reoler skal være et tal!");
        }
    }

    private void clearFields() {
        txtLagerNavn.clear();
        txtLagerLokation.clear();
        txtAntalReoler.clear();
        txtReolHylder.clear();
        txtHyldePladser.clear();
    }

    private void opdaterFadePåLager() {
        Lager valgtLager = comboLager.getValue();
        if (valgtLager != null) {
            lvSeFadePåLager.getItems().setAll(valgtLager.indholdsOversigt()); // Henter fade som tekst
        } else {
            lvSeFadePåLager.getItems().clear(); // Rydder listen, hvis intet lager er valgt
        }
    }
}


