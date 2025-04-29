package models;

public class Lager {
    private String navn;
    private String lokation;
    // TODO - Finde en konkret løsning til lagring og indeksering heraf.
    private int antalReoler;
    private int antalHylder;
    private int antalPladser;
    private int ledigePladser;
    private int pladserIAlt;

    private LagerPlads[][][] lagerPladser = new LagerPlads[getAntalReoler()][getAntalHylder()][getAntalPladser()];

    public Fad getIndholdAfLagerPlads(int reol, int hylde, int plads) {
        return lagerPladser[reol][hylde][plads].getFad();
    }

    public Fad setLagerPlads(int reol, int hylde, int plads, Fad fad) {
        // Throws exception hvis hylden er optaget.
        if (!lagerPladser[reol][hylde][plads].isEmpty()) {
            throw new IllegalArgumentException("This place is not empty!");
        } else { // Ellers fylder hylden med fadet, man vil sætte ind.
            return lagerPladser[reol][hylde][plads].setFad(fad);
        }
    }

    public String getNavn() {
        return navn;
    }

    public String getLokation() {
        return lokation;
    }

    public int getAntalReoler() {
        return antalReoler;
    }

    public int getAntalHylder() {
        return antalHylder;
    }

    public int getAntalPladser() {
        return antalPladser;
    }

    public int getLedigePladser() {
        return ledigePladser;
    }

    public int getPladserIAlt() {
        return pladserIAlt;
    }
}