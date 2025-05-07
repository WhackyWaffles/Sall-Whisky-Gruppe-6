package models;

import java.util.ArrayList;

public class Fad {
    private String nr;
    private String fadtype;
    private String fadMateriale;
    private double kapacitet;
    private Charring charring;
    private FillNummer fillNummer;
    private ArrayList<Påfyldning> påfyldninger;


    public Fad(String nr, String fadtype, String fadMateriale, double kapacitet, Charring charring, FillNummer fillNummer) {
        this.nr = nr;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.kapacitet = kapacitet;
        this.charring = charring;
        this.fillNummer = fillNummer;
        this.påfyldninger = new ArrayList<>(); // Initialiseres uden for constructor
    }

    // TODO - Finde ud af, hvordan et fads historie gemmes

    public void tilføjPåfyldning(Påfyldning påfyldning) {
        if (getVolumenLedig() >= påfyldning.getVolumenLiter()) {
            påfyldninger.add(påfyldning);
        } else {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
    }

    public double getVolumenLedig() {
        double totalFyldt = påfyldninger.stream().mapToDouble(Påfyldning::getVolumenLiter).sum();
        return kapacitet - totalFyldt;
    }


    public String getNr() {
        return nr;
    }

    public String getFadtype() {
        return fadtype;
    }

    public String getFadMateriale() {
        return fadMateriale;
    }

    public double getKapacitet() {
        return kapacitet;
    }

    public Charring getCharring() {
        return charring;
    }

    public FillNummer getFillNummer() {
        return fillNummer;
    }

    public ArrayList<Påfyldning> getPåfyldninger() {
        return påfyldninger;
    }
}
