package models;

public class LagerPlads {
    boolean erLovlig = true;
    private Fad fad = null;

    // TODO - Finde ud af, hvilken associationstype dette er med Lager (om det er dobbeltrettet, antal)
    // TODO - Find ud af, hvilken type objekter i dette associeringshierarki, der skal gemmes i Storage.

    public Fad getFad() {
        return fad;
    }

    public Fad setFad(Fad fad) {
        this.fad = fad;
        return fad;
    }

    public Fad removeFad() {
        Fad removedFad = fad;
        fad = null;
        return removedFad;
    }


    public boolean isEmpty() {
        // Returns true hvis der ikke er et fad på denne plads.
            return fad == null;
    }

    public boolean isThere() {
        return erLovlig;
    }

    /**
     * Sætter
     * @param erLovlig
     */
    public void setIsThere(boolean erLovlig) {
        this.erLovlig = erLovlig;
    }
}
