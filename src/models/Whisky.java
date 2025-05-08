package models;

public class Whisky {
    private String navn;
    private int flaskeNr;
    private Fad fad;

    public Whisky(String navn, int flaskeNr, Fad fad) {
        this.navn = navn;
        this.flaskeNr = flaskeNr;
        this.fad = fad;
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
}
