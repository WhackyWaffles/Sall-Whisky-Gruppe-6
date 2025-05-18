package models;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.ArrayList;

// TODO: Alkohol skal være en string
public class Destillat {
    private String batchNr;
    private double alkoholProcent;
    // TODO: Gøre noget ved evtAntalGange
    private int evtAntalGange; // skal ikke bruges til whisky-produktion
    private double destillatLiter;
    private LocalDate destilleringDato;
    private Ristning ristning; // bruges i stedet for malt
    private ArrayList<Malt> malts;

    public Destillat(String batchNr, double alkoholProcent, double destillatLiter, LocalDate destilleringDato, Ristning ristning) {
        this.batchNr = batchNr;
        this.alkoholProcent = alkoholProcent;
        this.destillatLiter = destillatLiter;
        this.destilleringDato = destilleringDato;
        this.ristning = ristning;
    }

    public String getBatchNr() {
        return batchNr;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public double getDestillatLiter() {return destillatLiter;}

    public LocalDate getDestilleringDato() {return destilleringDato;}

    public Ristning getRistning() {return ristning;}

    @Override
    public String toString() {
        return "Destillat " +
                batchNr + ',' +
                alkoholProcent + ',' +
                destilleringDato + ',' +
                ristning;
    }
}
