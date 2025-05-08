package models;

import java.time.LocalDate;

public class Påfyldning {
    private String idNr;
    private Destillat destillat;
    private Fad fad;
    private double påfyldningLiter;
    private LocalDate dato;

    public Påfyldning(Destillat destillat, Fad fad, double volumenLiter, LocalDate dato) {
        if (fad.getVolumenLedig() < volumenLiter) {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
        this.idNr = idNr;
        this.destillat = destillat;
        this.fad = fad;
        this.påfyldningLiter = volumenLiter;
        this.dato = dato;
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

    public LocalDate getDato() {
        return dato;
    }
}
