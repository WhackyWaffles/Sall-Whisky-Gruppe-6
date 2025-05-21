package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import models.*;
import storage.Storage;

import java.util.Arrays;
import java.util.OptionalInt;


public class OpretLagerPane extends GridPane {

    private TextField txtLagerNavn = new TextField();
    private TextField txtLagerLokation = new TextField();
    private TextField txtAntalReoler = new TextField();
    private TextField txtReolHylder = new TextField();
    private TextField txtHyldePladser = new TextField();
    Button btnOpretLager = new Button("Opret lager");
    private ComboBox<Lager> comboLager = new ComboBox<>();
    private ListView<String> lvSeFadePåDetteLager = new ListView<>();
    private ListView<Fad> lvFadeIStorage = new ListView<>();
    private TextField txtReol = new TextField();
    private TextField txtHylde = new TextField();
    private TextField txtPlads = new TextField();
    private Button btnSætFadPåLager = new Button("Sæt fad på lager");
    private Button btnOpdaterFade = new Button("Opdater fade");
    private Label errorLabel = new Label();
    private Label infoLabel = new Label();

    public OpretLagerPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //Labels og textfields
        Label lblLagerNavn = new Label("Lager navn");
        this.add(lblLagerNavn, 0, 0);
        this.add(this.txtLagerNavn, 1, 0);

        Label lblLagerLokation = new Label("Lager lokation");
        this.add(lblLagerLokation, 0, 1);
        this.add(this.txtLagerLokation, 1, 1);

        Label lblLagerReoler = new Label("Lager reoler");
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

        // Skillelabel
        Label lblLager = new Label("Placeringer af fade på lagre");
        this.add(lblLager, 0, 3,3,1);

        comboLager.getItems().setAll(Storage.getAllLagerhuse()); // Fyld combobox med lagre
        comboLager.setPromptText("Vælg lager");
        this.add(comboLager, 0, 4,2,1);

        // Sørg for at opdatere listen af fade, når et lager vælges
        comboLager.setOnAction(event -> opdaterFadePåLager());

        Label lblSeFadePåLager = new Label("Fade på lager");
        this.add(lblSeFadePåLager, 0, 5,2,1);
        this.add(lvSeFadePåDetteLager, 0, 6,4,1);
        // Fyld ListView med fade på lager fra Controller
        lvSeFadePåDetteLager.getItems().setAll(Controller.getFadePåLager(comboLager.getValue())); //
        lvSeFadePåDetteLager.setPrefSize(250,100);

        // ListView til fade, der skal tilknyttes lager
        Label lblSeFadeTilLager = new Label("Fade til lagring");
        this.add(lblSeFadeTilLager, 0, 7,2,1);
        this.add(lvFadeIStorage, 0,8,4,1);
        // Fyld ListView med fade til lager fra Controller
        lvFadeIStorage.getItems().setAll(Controller.getAlleFade());
        lvFadeIStorage.setPrefSize(250,100);

        // TextFields til at pladsere fade i lagerets koordinatsystem
        Label lblVælgReol = new Label("Vælg reol");
        this.add(lblVælgReol,0,9);
        this.add(txtReol,0,10);
        Label lblVælgHylde = new Label("Vælg hylde");
        this.add(lblVælgHylde,1,9);
        this.add(txtHylde,1,10);
        Label lblVælgPlads = new Label("Vælg plads");
        this.add(lblVælgPlads,2,9);
        this.add(txtPlads,2,10);

        // Knap til at sætte fade på lager
        btnSætFadPåLager.setOnAction(event -> sætFadPåLagerAction());
        this.add(btnSætFadPåLager,0,11,2,1);

        // Knap til at opdatere fade på lager
        btnOpdaterFade.setOnAction(event -> btnOpdaterFadeAction());
        this.add(btnOpdaterFade,1,11,2,1);
        lvFadeIStorage.getItems().setAll(Controller.getAlleFade());

        // InfoLabel til at informere User, hvad der er sket.
        this.add(infoLabel,0,12,4,1);
        infoLabel.setTextFill(Color.DODGERBLUE);

        // ErrorLabel til at vise, hvad der er galt.
        this.add(errorLabel, 0,13, 4, 1);
        errorLabel.setTextFill(Color.RED);
    }

    private void opretAction() {
        // henter lager og lokation fra relevante felter
        String navn = txtLagerNavn.getText();
        String lokation = txtLagerLokation.getText();

        // Hvis der ikke er angivet hvor mange reoler, hylder og pladser, print besked og stop metoden.
        if (txtAntalReoler.getText().isEmpty() || txtReolHylder.getText().isEmpty() || txtHyldePladser.getText().isEmpty()) {
            errorLabel.setText("Udfyld venligst alle felter.");
            return;
        }

        // Læser felterne for antal reoler, hylder og pladser, og opretter derefter Lager via Controller
        // try/catch for at fange, om data er angivet som andet end tal
        try {
            int antalReoler = Integer.parseInt(txtAntalReoler.getText());
            int antalHylder = Integer.parseInt(txtReolHylder.getText());
            int antalPladserPerHylde = Integer.parseInt(txtHyldePladser.getText());

            if (antalReoler < 1 || antalHylder < 1  || antalPladserPerHylde < 1 ) {
                errorLabel.setText("Angiv venligst positive tal for antallet af reoler, hylder og pladser per hylde.");
                return;
            }

            // Opret lager i Controller
            Controller.opretLager(navn,lokation,antalReoler,antalHylder,antalPladserPerHylde);

            String reolAntal = "reoler";
            if (antalReoler < 2){
                reolAntal = "reol";
            }
            infoLabel.setText("Lager oprettet: \"" + navn + "\" med " + antalReoler + " " + reolAntal + ".");
            clearFields();

            comboLager.getItems().setAll(Storage.getAllLagerhuse()); // Opdater lagre efter oprettelse

        } catch (
                NumberFormatException e) {
            errorLabel.setText("Fejl: Antal reoler, hylder og pladser skal være være angivet som tal!");
        }
    }

    private void clearFields() {
        txtLagerNavn.clear();
        txtLagerLokation.clear();
        txtAntalReoler.clear();
        txtReolHylder.clear();
        txtHyldePladser.clear();
    }

    private void sætFadPåLagerAction() {

        Fad fad = lvFadeIStorage.getSelectionModel().getSelectedItem();
        if (fad == null) {
            errorLabel.setText("Fejl: Angiv fad");
            return;
        }

        Lager valgteLager = comboLager.getSelectionModel().getSelectedItem();
        if (valgteLager == null) {
            errorLabel.setText("Fejl: Angiv lager");
            return;
        }

        int reol = 0;
        int hylde = 0;
        int plads = 0;
        try {
            // Find koordinaterne til den valgte plads
            reol = Integer.parseInt(txtReol.getText());
            hylde = Integer.parseInt(txtHylde.getText());
            plads = Integer.parseInt(txtPlads.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("Fejl: Reol, hylde og plads skal være angivet som tal!");
            return;
        }

        // Tjek om koordinaterne er gyldige (hverken større end lagerets kapacitet eller under 0)
        if (reol >= valgteLager.getAntalReoler() || reol < 0 ||
                hylde >= valgteLager.getReoler()[reol].getHylder().length || hylde < 0 ||
                plads >= valgteLager.getReoler()[reol].getHylder()[hylde].getPladser().length || plads < 0) {
            errorLabel.setText("Fejl: De angivne koordinater er uden for lagerets grænser!");
            return;
        }

        // Tjekker for lager uden pladser
        if (valgteLager.getPladserIAlt() == 0) {
            errorLabel.setText("Fejl: Lageret har ingen pladser!");
            return;
        }

        // Tjekker, om dette Fad er registreret på en anden plads i et vilkårligt varehus
        // Hvis det er, fjerner det fra dets plads, og printer koordinaterne og Varehuset det blev fjernet fra.
        for (Lager lager : Controller.getAllLagerhuse()) {
            // Hvis en af værdierne i koordinaterne fra findFad metoden ikke er -1,
            // vil det sige at Fadet er fundet på en anden plads
            if (!Arrays.stream(lager.findFad(fad)).max().equals(OptionalInt.of(-1))) {
                // Gemmer koordinaterne
                int[] koordinater = lager.findFad(fad);
                try {
                    // Sætter Fadet på den nye plads.
                    valgteLager.setFad(fad, reol, hylde, plads);
                } catch (IllegalArgumentException e) {
                    errorLabel.setText("Denne plads er optaget.");
                    return;
                }
                // Fjerner Fadet fra den gamle plads.
                lager.removeFad(lager.findFad(fad));
                // Printer relevant besked.
                infoLabel.setText("Fad " + fad.getFadNr() + " er blevet fjernet fra en anden plads "
                        + "(på Lager: " + lager.getNavn()
                        + ", reol " + koordinater[0]
                        + ", hylde " + koordinater[1]
                        + ", plads " + koordinater[2] + ")");
                // Opdaterer gui og rydder brugte felter
                opdaterFadePåLager();
                errorLabel.setText("");

                txtReol.clear();
                txtHylde.clear();
                txtPlads.clear();

                // Hopper ud af loop og metode.
                return;
            }
        }

        try {
            // Sætter Fadet på den nye plads.
            valgteLager.setFad(fad, reol, hylde, plads);
        } catch (IllegalArgumentException e) {
            errorLabel.setText("Denne plads er optaget.");
            return;
        }
        infoLabel.setText("Fad placeret på valgte plads!");
        // Opdaterer gui
        opdaterFadePåLager();
        errorLabel.setText("");

        txtReol.clear();
        txtHylde.clear();
        txtPlads.clear();
    }

    private void opdaterFadePåLager() {
        Lager valgtLager = comboLager.getValue();
        if (valgtLager != null) {
            lvSeFadePåDetteLager.getItems().setAll(valgtLager.hentFadeMedKoordinater()); // Henter fade som tekst
        } else {
            lvSeFadePåDetteLager.getItems().clear(); // Rydder listen, hvis intet lager er valgt
        }
        lvFadeIStorage.getItems().setAll(Controller.getAlleFade());
    }

    // TADAAA! :P
    private void btnOpdaterFadeAction() {
        opdaterFadePåLager();
    }

    // TODO: TestCase Skema for LagerHyldeTest.java

}


