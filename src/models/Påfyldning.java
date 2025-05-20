package models;

import java.time.LocalDate;

public class Påfyldning {
    private String idNr;
    private Destillat destillat;
    private Fad fad;
    private double påfyldningLiter;
    private LocalDate påfyldningDato;

    // TODO: Måske implementere sådan, at idNr automatisk tæller op
    //   - så der ikke kommer duplicate numre, og så man ikke selv skal huske hvilket nummer man er kommet til
    //     - og derved fjerne String idNr fra Constructor
    //       - Kan muligvis bruges til oprettelse af Fad, Destillat, Whisky og WhiskyFlaske.
    public Påfyldning(String idNr, Destillat destillat, Fad fad, double påfyldningLiter, LocalDate påfyldningDato) {
        if (fad.getVolumenLedig() < påfyldningLiter) {
            throw new IllegalArgumentException("Ikke nok plads i fadet!");
        }
        this.idNr = idNr;
        this.destillat = destillat;
        this.fad = fad;
        this.påfyldningLiter = påfyldningLiter;
        this.påfyldningDato = påfyldningDato;
        if (!fad.getPåfyldninger().contains(this)) {
            fad.tilføjPåfyldning(this);
        }
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

    public void setFad(Fad fad) {
        this.fad = fad;
    }

    public double getPåfyldningLiter() {
        return påfyldningLiter;
    }

    public double setPåfyldningLiter(double Liter) {
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
