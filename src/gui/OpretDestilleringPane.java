package gui;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class OpretDestilleringPane extends GridPane {

    private TextField txtBatchNr = new TextField();
    private TextField txtAlkoholProcent = new TextField();
    private LocalDate destilleringDato; // skal måske bruges i anden iteration
    private TextField txtAntalLiter = new TextField();
    private TextField txtRistning = new TextField();
    private Button btnOpretDestl;
    private Button btnAflyst;

    public OpretDestilleringPane() {

        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.txtBatchNr = new TextField();
        this.txtAlkoholProcent = new TextField();
//        this.date = LocalDate.now();
        this.txtAntalLiter = new TextField();
        this.txtRistning = new TextField();


        //Label og textfield
        Label lblBatchNr = new Label("Batch Nummer");
        this.add(lblBatchNr, 0,1);
        this.add(this.txtBatchNr, 1,1);

        Label lblAlkoholProcent = new Label("Alkohol procent");
        this.add(lblAlkoholProcent, 0,2);
        this.add(this.txtAlkoholProcent, 1,2);

        Label lblAntalDest = new Label("Antal liter");
        this.add(lblAntalDest, 0,3);
        this.add(this.txtAntalLiter, 1,3);

        Label lblAntalLt = new Label("Malt");
        this.add(lblAntalLt, 0,4);
        this.add(this.txtRistning, 1,4);

        //Button til Opret og Aflyst
        Button btnOpret = new Button("Opret destillat");
        this.add(btnOpret,0,5);

        Button btnAnnuler = new Button("Annulér");
        this.add(btnAnnuler,1,5);








    }

}
