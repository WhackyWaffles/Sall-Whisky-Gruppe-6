package application.models;

import java.time.LocalDate;

public class Destillat {
    private String batchNr;
    private String alkoholProcent;
    private double destillatLiter;
    private LocalDate destilleringDato;

    // Ristning bruges i stedet for malt
    private Ristning ristning;
    // private ArrayList<Malt> malts;

    public Destillat(String batchNr, String alkoholProcent, double destillatLiter, LocalDate destilleringDato, Ristning ristning) {
        this.batchNr = batchNr;
        this.alkoholProcent = alkoholProcent;
        this.destillatLiter = destillatLiter;
        this.destilleringDato = destilleringDato;
        this.ristning = ristning;
    }

    public String getBatchNr() {
        return batchNr;
    }

    public String getAlkoholProcent() {
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
