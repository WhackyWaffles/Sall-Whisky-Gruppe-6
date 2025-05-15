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
     * @param nr {@code String} Fadets unikke ID.
     * @param fadtype {@code String} Hvilken slags drik, der før har været i Fadet, eks. Ex-Oloroso
     * @param fadMateriale {@code String} Hvilken slags træ, Fadet er lavet af.
     * @param kapacitet {@code double} Hvor mange Liter, der kan være i Fadet.
     * @param charring {@code Charring} Hvilken behandling Fadet har.
     * @param fillNummer {@code FillNummer} Hvor mange gange fadet har været brugt.
     * @param påfyldninger {@code ArrayList<Påfyldning>} Hvilke påfyldninger, der er hældt i Fadet, dvs. Fadets indhold. Hvis {@code null} oprettes et tomt fad.
     */
    public Fad(String nr, String fadtype, String fadMateriale, double kapacitet, Charring charring, FillNummer fillNummer, ArrayList<Påfyldning> påfyldninger) {
        this.nr = nr;
        this.fadtype = fadtype; // eks. EX-OLOROSO
        this.fadMateriale = fadMateriale; // eks. EGETRÆ
        this.kapacitet = kapacitet;
        this.charring = charring;
        this.fillNummer = fillNummer;
        if (påfyldninger != null) {
            this.påfyldninger  = new ArrayList<>(påfyldninger);
        } else
            this.påfyldninger = new ArrayList<>();
    }

    public void tilføjPåfyldning(Påfyldning påfyldning) {
        if (getVolumenLedig() >= påfyldning.getPåfyldningLiter()) {
            påfyldninger.add(påfyldning);
        } else {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
    }

    public double getVolumenLedig() {
        double totalFyldt = påfyldninger.stream().mapToDouble(Påfyldning::getPåfyldningLiter).sum();
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
