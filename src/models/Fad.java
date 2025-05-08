package models;

import java.util.ArrayList;

public class Fad {
    private String fadNr;
    private String fadtype;
    private String fadMateriale;
    private double kapacitet;
    private ArrayList<Påfyldning> påfyldninger;

    /**
     * Constructor af et fyldt Fad.
     * @param fadNr Fadets unikke nummer.
     * @param fadtype Hvilken slags drik, der før har været i Fadet, eks. Ex-Oloroso
     * @param fadMateriale Hvilken slags træ, Fadet er lavet af.
     * @param kapacitet Hvor mange Liter, der kan være i Fadet.
     * @param påfyldninger Hvilke påfyldninger, der er hældt i Fadet, dvs. Fadets indhold
     */
    public Fad(String fadNr, String fadtype, String fadMateriale, double kapacitet, ArrayList<Påfyldning> påfyldninger) {
        this.fadNr = fadNr;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.kapacitet = kapacitet;
        if (påfyldninger != null) {
            this.påfyldninger  = new ArrayList<>(påfyldninger);
        } else
            this.påfyldninger = new ArrayList<>();
    }

    /**
     * Constructor af et tomt Fad.
     */
    public Fad(int størrelse, FadType fadtype, FadMateriale fadMateriale, LagerPlads lagerPlads) {
        this.størrelse = størrelse;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.lagerPlads = lagerPlads;
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
