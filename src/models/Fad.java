package models;

import java.util.ArrayList;

public class Fad {
    private String nr;
    private FadType fadtype;
    private FadMateriale fadMateriale;;
    private double kapacitet;
    private LagerPlads lagerPlads;
    private ArrayList<Påfyldning> påfyldninger = new ArrayList<>();
    // TODO - Finde ud af, hvordan et fads historie gemmes


    public Fad(String nr, FadType fadtype, FadMateriale fadMateriale, double kapacitet, LagerPlads lagerPlads, ArrayList<Påfyldning> påfyldninger) {
        this.nr = nr;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.kapacitet = kapacitet;
        this.lagerPlads = lagerPlads;
        this.påfyldninger = påfyldninger;
    }

    public void tilføjPåfyldning(Påfyldning påfyldning) {
        if (getVolumenLedig() >= påfyldning.getVolumenLiter()) {
            påfyldninger.add(påfyldning);
        } else {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
    }

    public int getVolumenLedig() {
        int totalFyldt = påfyldninger.stream().mapToInt(Påfyldning::getVolumenLiter).sum();
        return kapacitet - totalFyldt;
    }

    public String getNr() {
        return nr;
    }

    public FadType getFadtype() {
        return fadtype;
    }

    public FadMateriale getFadMateriale() {
        return fadMateriale;
    }
}
