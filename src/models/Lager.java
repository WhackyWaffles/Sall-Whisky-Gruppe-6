package models;

public class Lager {
    private String navn;
    private String lokation;
    private LagerReol[] reoler;


    // TODO - Find ud af, hvilke associationstyper der er mellem LagerKlasserne (dobbeltrettet, multiplicitet osv.)
    // TODO - Find ud af, hvilken klasse i dette associeringshierarki, der gemmes i Storage (tror bare det er Lager)

    /**
     * Laver et nyt Lager.
     * @param navn Lagerets navn.
     * @param lokation Lagerets Lokation (som adresse).
     * @param antalReoler Antal Reoler på lageret.
     * @param antalHylder Antal Hylder per Reol.
     * @param antalPladserPerHylde Antal Pladser på hver Hylde.
     */
    public Lager(String navn, String lokation, int antalReoler, int antalHylder, int antalPladserPerHylde) {
        this.navn = navn;
        this.lokation = lokation;
        // opretter Array af Reoler.
        this.reoler = new LagerReol[antalReoler];
        // fylder Arrayet.
        for (int index = 0; index < reoler.length; index++) {
            reoler[index] = new LagerReol(antalHylder, antalPladserPerHylde);
        }
    }

    /**
     * @param reol  int
     * @param hylde int
     * @param plads int
     * @return {@code Fad} der findes på den valgte {@code LagerPlads}
     * <p></p>
     * {@code null} hvis pladsen er tom.
     */
    public Fad getLagerPlads(int reol, int hylde, int plads) {
        return reoler[reol].getHylder()[hylde].getPladser()[plads].getFad();
    }

    /**
     * Fylder den valgte {@code LagerPlads} med det valgte {@code Fad}.
     * <p>
     * Kaster en exception hvis der er optaget.
     *
     * @param reol  int
     * @param hylde int
     * @param plads int
     * @param fad   Fad
     * @return Det {@code Fad} der er blevet sat på den valgte plads.
     */
    public Fad setLagerPlads(int reol, int hylde, int plads, Fad fad) {
        return reoler[reol].getHylder()[hylde].getPladser()[plads].setFad(fad);
    }

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
     * @return Det maksimale antal Pladser på dette Lager.
     */
    public int getPladserIAlt() {
        int pladserIAlt = 0;
        for (LagerReol lagerReol : reoler) {
            for (int j = 0; j < lagerReol.getHylder().length; j++) {
                for (int k = 0; k < lagerReol.getHylder()[j].getPladser().length; k++) {
                    pladserIAlt++;
                }
            }
        }
        return pladserIAlt;
    }

    /**
     * @return Antallet af ledige pladser på Lageret.
     */
    public int getLedigePladser() {
        int ledigePladser = 0;
        for (LagerReol lagerReol : reoler) {
            for (int j = 0; j < lagerReol.getHylder().length; j++) {
                for (int k = 0; k < lagerReol.getHylder()[j].getPladser().length; k++) {
                    if (lagerReol.getHylder()[j].getPladser()[k].isEmpty()) {
                        ledigePladser++;
                    }
                }
            }
        }
        return ledigePladser;
    }

    /**
     * Leder efter et bestemt Fad.
     *
     * @param fad Fadet der ledes efter.
     * @return {@code int[]} Koordinaterne på Fadet, hvis det bliver fundet,
     * <p>
     * i format {@code int[2] = ReolNr} & {@code int[1] = HyldeNr} & {@code int[0] = PladsNr}
     * <p></p>
     * {@code int[0] = -1} hvis det ikke bliver fundet.
     */
    public int[] findFad(Fad fad) {
        int[] koords = new int[3];
        for (int i = 0; i < reoler.length; i++) {
            if (reoler[i].findFad(fad)[0] != -1) {
                koords[0] = reoler[i].findFad(fad)[0];
                koords[1] = reoler[i].findFad(fad)[1];
                koords[2] = i;
                return koords;
            }
        }
        koords[0] = -1; // PladsNr på Hylden
        koords[1] = -1; // HyldeNr på Reolen.
        koords[2] = -1; // ReolNr i Lageret.
        return koords;
    }
}
