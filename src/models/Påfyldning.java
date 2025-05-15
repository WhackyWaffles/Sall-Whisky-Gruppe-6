package models;

import java.time.LocalDate;

public class Påfyldning {
    private String idNr;
    private Destillat destillat;
    private Fad fad;
    private double påfyldningLiter;
    private LocalDate påfyldningDato;

    public Påfyldning(String idNr, Destillat destillat, Fad fad, double påfyldningLiter, LocalDate påfyldningDato) {
        if (fad.getVolumenLedig() < påfyldningLiter) {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
        this.idNr = idNr;
        this.destillat = destillat;
        this.fad = fad;
        this.påfyldningLiter = påfyldningLiter;
        this.påfyldningDato = påfyldningDato;
    }

    public String getIdNr() {
        return idNr;
    }

    public Destillat getDestillat() {
        return destillat;
    }

    public Fad getFad() {
        return fad;
    }

    public double getPåfyldningLiter() {
        return påfyldningLiter;
    }

    public LocalDate getPåfyldningDato() {
        return påfyldningDato;
    }

    @Override
    public String toString() {
        return "Påfyldning " +
                idNr + ',' +
                " " + påfyldningLiter + ',' +
                " " + påfyldningDato +
                " " + destillat + ',' +
                " " + fad;
    }

    public void setLiter() {

    }
}
