package models;

import java.time.LocalDate;

public class Påfyldning {
    private String navn;
    private Destillering destillering;
    private Fad fad;
    private double volumenLiter;
    private LocalDate dato;

    public Påfyldning(Destillering destillering, Fad fad, double volumenLiter, LocalDate dato) {
        if (fad.getVolumenLedig() < volumenLiter) {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
        this.navn = navn;
        this.destillering = destillering;
        this.fad = fad;
        this.volumenLiter = volumenLiter;
        this.dato = dato;
    }

    public String getNavn() {
        return navn;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public Fad getFad() {
        return fad;
    }

    public double getVolumenLiter() {
        return volumenLiter;
    }

    public LocalDate getDato() {
        return dato;
    }
}
