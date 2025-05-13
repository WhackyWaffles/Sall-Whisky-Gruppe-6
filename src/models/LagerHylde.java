package models;

public class LagerHylde {
    private final LagerPlads[] pladser;

    /**
     * Laver en ny LagerHylde.
     * @param antalPladser Antallet af pladser på den nye Hylde.
     */
    public LagerHylde(int antalPladser) {
        // opretter Array af Pladser.
        this.pladser = new LagerPlads[antalPladser];
        // fylder Array med pladser
        for (int index = 0; index < pladser.length; index++) {
            pladser[index] = new LagerPlads();
        }
    }

    /**
     * Leder efter et bestemt Fad.
     * @param fad Fadet der ledes efter
     * @return koordinaterne på Fadet, hvis det bliver fundet
     * <p></p>
     * {@code -1} hvis det ikke bliver fundet.
     */
    public int findFad(Fad fad) {
        for (int i = 0; i < pladser.length; i++) {
            if (pladser[i].getFad() == fad)
                return i;
        }
        return -1;
    }

    /**
     * @return {@code LagerPlads[]} med de pladser, Hylden har.
     */
    public LagerPlads[] getPladser() {
        return pladser;
    }

    /**
     * @return {@code true} hvis Hylden er tom.
     */
    public boolean isEmpty() {
        for (LagerPlads lagerPlads : pladser) {
            if (!lagerPlads.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Fad setFad(Fad fad, int plads) {
        if (plads >= pladser.length || plads < 0) {
            throw new IllegalArgumentException("Denne plads findes ikke.");
        }
        return pladser[plads].setFad(fad);
    }

    public int getAntalPladser() {
        return pladser.length;
    }
}
