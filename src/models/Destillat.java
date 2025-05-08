package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillat {
    private String batchNr;
    private String alkoholProcent;
    private LocalDate destilleringDato;
    private int evtAntalGange; // Kan bruges til andre destilleringer
    private double destillatLiter;
    private Ristning ristning;
    private ArrayList<Malt> malts; // Skal måske bruges senere

    public Destillat(String batchNr, String alkoholProcent, LocalDate destilleringDato, double mængdeLiter, Ristning ristning) {
        this.batchNr = batchNr;
        this.alkoholProcent = alkoholProcent;
        this.destilleringDato = destilleringDato;
        this.destillatLiter = mængdeLiter;
        this.ristning = ristning;
    }

    public String getBatchNr() {
        return batchNr;
    }

    public String getAlkoholProcent() {
        return alkoholProcent;
    }

    public LocalDate getDestilleringDato() {return destilleringDato;}

    public double getDestillatLiter() { return destillatLiter;}

    public Ristning getMalt() { return ristning;}
}
