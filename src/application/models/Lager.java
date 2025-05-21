package application.models;

import java.util.ArrayList;

public class Lager {
    private String navn;
    private String lokation;
    private final LagerReol[] reoler;

    // Constructor
    /**
     * Laver et nyt Lager.
     *
     * @param navn                 Lagerets navn.
     * @param lokation             Lagerets Lokation (som adresse).
     * @param antalReoler          Antal Reoler på lageret.
     * @param antalHylder          Antal Hylder per Reol.
     * @param antalPladserPerHylde Antal Pladser på hver Hylde.
     */
    public Lager(String navn, String lokation, int antalReoler, int antalHylder, int antalPladserPerHylde) {
        this.navn = navn;
        this.lokation = lokation;
        // opretter Array af Reoler.
        this.reoler = new LagerReol[antalReoler];
        // fylder Array
        for (int index = 0; index < reoler.length; index++) {
            reoler[index] = new LagerReol(antalHylder, antalPladserPerHylde);
        }
    }

    // getFad metoder
    /**
     * Returnerer indholdet af den valgte {@code LagerPlads}.
     * <p>
     * Kaster en exception hvis den valgte plads ikke findes.
     *
     * @param reol  int
     * @param hylde int
     * @param plads int
     * @return {@code Fad} der findes på den valgte {@code LagerPlads}
     * <p></p>
     * {@code null} hvis pladsen er tom.
     */
    public Fad getFad(int reol, int hylde, int plads) {
        // Tjekker om de givne koordinater findes
        if ((reol >= reoler.length || reol < 0) ||
                (hylde >= reoler[reol].getHylder().length || hylde < 0) ||
                (plads >= reoler[reol].getHylder()[hylde].getPladser().length || plads < 0)) {
            throw new IllegalArgumentException("Denne plads findes ikke.");
        }

        return reoler[reol].getHylder()[hylde].getPladser()[plads].getFad();
    }
    /**
     * Returnerer indholdet af den valgte {@code LagerPlads}.
     * <p>
     * Kaster en exception hvis den valgte plads ikke findes.
     *
     * @param koordinater {@code int[]} med størrelse 3
     * @return {@code Fad} der findes på den valgte {@code LagerPlads}
     * <p></p>
     * {@code null} hvis pladsen er tom.
     */
    public Fad getFad(int[] koordinater) {
        return getFad(koordinater[0], koordinater[1], koordinater[2]);
    }

    // setFad metoder
    /**
     * Fylder den valgte {@code LagerPlads} med det valgte {@code Fad}.
     * <p>
     * Kaster en exception hvis der er optaget, eller hvis den valgte plads ikke findes.
     *
     * @param fad   Fad
     * @param reol  int
     * @param hylde int
     * @param plads int
     * @return Det {@code Fad} der er blevet sat på den valgte plads.
     */
    public Fad setFad(Fad fad, int reol, int hylde, int plads) {
        // Tjekker om de givne koordinater findes
        if ((reol >= reoler.length || reol < 0) ||
                (hylde >= reoler[reol].getHylder().length || hylde < 0) ||
                (plads >= reoler[reol].getHylder()[hylde].getPladser().length || plads < 0)) {
            throw new IllegalArgumentException("Denne plads findes ikke.");
        }

        return reoler[reol].getHylder()[hylde].getPladser()[plads].setFad(fad);
    }
    /**
     * Fylder den valgte {@code LagerPlads} med det valgte {@code Fad}.
     * <p>
     * Kaster en exception hvis der er optaget, eller hvis den valgte plads ikke findes.
     *
     * @param fad         Fad
     * @param koordinater {@code int[]} med størrelsen 3
     * @return Det {@code Fad} der er blevet sat på den valgte plads.
     */
    public Fad setFad(Fad fad, int[] koordinater) {
        return setFad(fad, koordinater[0], koordinater[1], koordinater[2]);
    }

    // removeFad metoder
    /**
     * Tømmer den valgte {@code LagerPlads}.
     * <p>
     * Kaster en exception hvis den valgte plads ikke findes.
     *
     * @param reol  int
     * @param hylde int
     * @param plads int
     * @return Det {@code Fad} der er blevet tømt fra den valgte plads.
     * {@code null} hvis pladsen var tom.
     */
    public Fad removeFad(int reol, int hylde, int plads) {
        // Tjekker om de givne koordinater findes
        if ((reol >= reoler.length || reol < 0) ||
                (hylde >= reoler[reol].getHylder().length || hylde < 0) ||
                (plads >= reoler[reol].getHylder()[hylde].getPladser().length || plads < 0)) {
            throw new IllegalArgumentException("Denne plads findes ikke.");
        }

        return reoler[reol].getHylder()[hylde].getPladser()[plads].removeFad();
    }
    /**
     * Tømmer den valgte {@code LagerPlads}.
     * <p>
     * Kaster en exception hvis den valgte plads ikke findes.
     *
     * @param koordinater {@code int[]} med størrelsen 3
     * @return Det {@code Fad} der er blevet tømt fra den valgte plads.
     * {@code null} hvis pladsen var tom.
     */
    public Fad removeFad(int[] koordinater) {
        return removeFad(koordinater[0], koordinater[1], koordinater[2]);
    }

    // findFad metode, returnerer et int[]
    /**
     * Leder efter et bestemt Fad.
     *
     * @param fad Fadet der ledes efter.
     * @return {@code int[]} Koordinaterne på Fadet, hvis det bliver fundet:
     * <p>
     * {@code int[0]} = Reol
     * <p>
     * {@code int[1]} = Hylde
     * <p>
     * {@code int[2]} = Plads
     * <p>
     * Hvis ikke fundet, bliver alle værdierne i {@code int[]} sat til {@code -1}
     */
    public int[] findFad(Fad fad) {
        // Er lavet på denne måde for at kunne bryde loopet, når target er fundet.
        for (int i = 0; i < reoler.length; i++) { // For hver reol
            if (reoler[i].findFad(fad)[2] != -1) { // Hvis en af reolens hylder returnerer positivt resultat;
                int[] koordinater = reoler[i].findFad(fad);
                koordinater[0] = i;
                return koordinater; // returner koordinaterne
            }
        }
        // Ellers returner negativt resultat
        return new int[]{-1, -1, -1};
    }

    // getAntalPladser metoder
    /**
     * @return Det maksimale antal Pladser på dette Lager.
     */
    public int getPladserIAlt() {
        int pladserIAlt = 0;
        for (LagerReol lagerReol : reoler) { // Går alle reoler igennem.
            for (int j = 0; j < lagerReol.getHylder().length; j++) { // Går alle hylder igennem.
                for (int k = 0; k < lagerReol.getHylder()[j].getPladser().length; k++) { // For hver plads, +1 pladserIAlt
                    pladserIAlt++;
                }
            }
        }
        return pladserIAlt; // Returner pladserIAlt
    }
    /**
     * @return Antallet af ledige pladser på Lageret.
     */
    public int getLedigePladser() {
        int ledigePladser = 0;
        for (LagerReol lagerReol : reoler) { // Går alle reoler igennem.
            for (int j = 0; j < lagerReol.getHylder().length; j++) { // Går alle hylder igennem.
                for (int k = 0; k < lagerReol.getHylder()[j].getPladser().length; k++) { // Går all pladser igennem.
                    if (lagerReol.getHylder()[j].getPladser()[k].isEmpty()) { // For hver tom plads, +1 ledigePladser
                        ledigePladser++;
                    }
                }
            }
        }
        return ledigePladser; // Returner ledigePladser
    }

    /**
     * @return En {@code ArrayList<String>}, der indeholder alt, hvad der er lagret i dette Lager.
     */
    public ArrayList<Fad> indholdsOversigt() {
        ArrayList<Fad> indholdsOversigt = new ArrayList<>();
        for (int i = 0; i < reoler.length; i++) { // For alle Reoler
            for (int j = 0; j < reoler[i].getHylder().length; j++) { // For alle Hylder
                for (int k = 0; k < reoler[i].getHylder()[j].getPladser().length; k++) // For alle Pladser
                    if (!reoler[i].getHylder()[j].getPladser()[k].isEmpty()) { // Hvis der er et Fad på den.
                        indholdsOversigt.add(reoler[i].getHylder()[j].getPladser()[k].getFad());
//                                + " [" + i + ", " + j + ", " + k + "]"); // Tilføj til indholdsOversigt med koordinater
//                    }
                }
            }
        }
        return indholdsOversigt;
    }

    // Bruges til at vise fade på lager
    public ArrayList<Fad> hentFade() {
        ArrayList<Fad> fade = new ArrayList<>();
        for (LagerReol reol : reoler) { // Gå igennem alle reoler
            for (LagerHylde hylde : reol.getHylder()) { // Gå igennem alle hylder
                for (LagerPlads plads : hylde.getPladser()) { // Gå igennem alle pladser
                    if (!plads.isEmpty()) { // Hvis der er et fad på pladsen
                        fade.add(plads.getFad()); // Tilføj fadet til listen
                    }
                }
            }
        }
        return fade;
    }

    // Metode til at vise fade, med lagerkoordinater
    public ArrayList<String> hentFadeMedKoordinater() {
        ArrayList<String> fadeMedKoordinater = new ArrayList<>();

        for (int i = 0; i < reoler.length; i++) { // For alle reoler
            for (int j = 0; j < reoler[i].getHylder().length; j++) { // For alle hylder
                for (int k = 0; k < reoler[i].getHylder()[j].getPladser().length; k++) { // For alle pladser
                    if (!reoler[i].getHylder()[j].getPladser()[k].isEmpty()) { // Hvis der er et Fad på pladsen
                        fadeMedKoordinater.add(reoler[i].getHylder()[j].getPladser()[k].getFad().toString()
                                + " [Reol: " + i + ", Hylde: " + j + ", Plads: " + k + "]");
                    }
                }
            }
        }
        return fadeMedKoordinater; // Returner liste med fad + koordinater
    }

// ======================================================================================
    // Simple metoder (1 linjes metoder)
// ======================================================================================

    /**
     * @return Lagerets navn.
     */
    public String getNavn() {
        return navn;
    }

    /**
     * @param navn Lagerets nye navn.
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * @return Lagerets Lokation (som adresse)
     */
    public String getLokation() {
        return lokation;
    }

    /**
     * @param lokation Lagerets nye Lokation (som adresse)
     */
    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    /**
     * @return antallet af Reoler på Lageret.
     */
    public int getAntalReoler() {
        return reoler.length;
    }

    /**
     * @return {@code LagerReol[]} med de LagerReoler, Lageret har.
     */
    public LagerReol[] getReoler() {
        return reoler;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(navn + ", " + reoler.length + " reoler");
        return sb.toString();
    }
}
