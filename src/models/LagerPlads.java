package models;

public class LagerPlads {
    private Fad fad = null;

    // Constructor
    /**
     * Laver en tom LagerPlads.
     */
    public LagerPlads() {
    }

    /**
     * @return {@code Fad} fadet der er på denne plads.
     * <p></p>
     * {@code null} hvis pladsen er tom.
     */
    public Fad getFad() {
        return fad;
    }

    /**
     * Placerer et Fad på denne plads, hvis der er plads.
     * <p>
     * Kaster en Exception hvis der er optaget.
     * @param fad Fadet der skal sætte på pladsen.
     * @return {@code Fad} Fadet, der er blevet sat på plads.
     */
    public Fad setFad(Fad fad) {
        if (!this.isEmpty() ) {
            throw new IllegalArgumentException("Denne plads er optaget.");
        }
        this.fad = fad;
        return fad;
    }

    /**
     * @return {@code Fad} hvis der er et Fad på denne plads.
     * <p></p>
     * {@code null} hvis pladsen er tom.
     */
    public Fad removeFad() {
        Fad removedFad = fad;
        this.fad = null;
        return removedFad;
    }

    /**
     * @return {@code true} hvis denne plads er tom.
     */
    public boolean isEmpty() {
            return this.fad == null;
    }

}
