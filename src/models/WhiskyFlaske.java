package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class WhiskyFlaske {
    private String navn;
    private int flaskeNr;
    private Fad fad;
    private double kapacitet;
    private String note;

    public WhiskyFlaske(String navn, int flaskeNr, Fad fad, double kapacitet) {
        this.navn = navn;
        this.flaskeNr = flaskeNr;
        this.fad = fad;
        this.kapacitet = kapacitet;
    }

    public String getNavn() {
        return navn;
    }

    public int getFlaskeNr() {
        return flaskeNr;
    }

    public Fad getFad() {
        return fad;
    }

    public double getKapacitet() {
        return kapacitet;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
