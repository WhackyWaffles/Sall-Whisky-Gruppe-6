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

    /**
     * Constructor af et fyldt Fad.
     * @param nr Fadets unikke nummer.
     * @param fadtype Hvilken slags drik, der før har været i Fadet, eks. Ex-Oloroso
     * @param fadMateriale Hvilken slags træ, Fadet er lavet af.
     * @param kapacitet Hvor mange Liter, der kan være i Fadet.
     * @param påfyldninger Hvilke påfyldninger, der er hældt i Fadet, dvs. Fadets indhold
     */
    public Fad(String nr, String fadtype, String fadMateriale, double kapacitet, Charring charring, FillNummer fillNummer, ArrayList<Påfyldning> påfyldninger) {
        this.nr = nr;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.kapacitet = kapacitet;
        this.charring = charring;
        this.fillNummer = fillNummer;
        if (påfyldninger != null) {
            this.påfyldninger  = new ArrayList<>(påfyldninger);
        } else
            this.påfyldninger = new ArrayList<>();
    }

    /**
     * Constructor af et tomt Fad.
     */
    public Fad(double kapacitet, String fadtype, String fadMateriale) {
        this.kapacitet = kapacitet;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
    }

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
