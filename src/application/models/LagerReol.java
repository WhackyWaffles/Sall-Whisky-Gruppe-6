package application.models;

import java.util.Arrays;

public class LagerReol {
    private LagerHylde[] hylder;

    // Constructor
    /**
     * Laver en ny LagerReol.
     * @param antalHylder Antallet af Hylder i den nye Reol.
     * @param antalPladserPerHylde Antallet af pladser på hver Hylde i den nye Reol.
     */
    public LagerReol(int antalHylder, int antalPladserPerHylde) {
        // opretter Array af Hylder.
        this.hylder = new LagerHylde[antalHylder];
        // fylder Arrayet.
        for (int index = 0; index < hylder.length; index++) {
            hylder[index] = new LagerHylde(antalPladserPerHylde);
        }
    }

    /**
     * Leder efter et bestemt Fad.
     * @param fad Fadet der ledes efter
     * @return {@code int[]} Koordinaterne på Fadet, hvis det bliver fundet,
     * <p>
     * i format {@code int[1] = HyldeNr} & {@code int[0] = PladsNr}
     * <p></p>
     * {@code int[0] = -1} hvis det ikke bliver fundet.
     */
    public int[] findFad(Fad fad) {
        for (int i = 0; i < hylder.length; i++) {
            if (hylder[i].findFad(fad)[2] != -1) {
                int[] koordinater = hylder[i].findFad(fad);
                koordinater[1] = i; // koordinater[1] = hyldenummer
                return koordinater;
            }
        }
        return new int[]{-1, -1, -1};
    }

    /**
     * @return {@code int} Antallet af Hylder i denne Reol.
     */
    public int getAntalHylder() {
        return hylder.length;
    }

    /**
     * Tjekker, om denne reol er tom.
     * @return {@code false} hvis der er noget på reolens hylder, return {@code true} hvis reolen er tom.
     */
    public boolean isEmpty() {
        for (LagerHylde lagerHylde : hylder) {
            if (!lagerHylde.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return {@code LagerHylde[]} med de Hylder, Reolen har.
     */
    public LagerHylde[] getHylder() {
        return hylder;
    }

    /**
     * Hvis det nye antal hylder er mindre end det nuværende antal, tjekker de hylder, der er ved at blive slettet.
     * Hvis de ikke er tomme, kaldes en IllegalArgumentException.
     * Kopierer derefter indholdet af {@code hylder} over til
     * {@code temp}, der har den nye størrelse. Til sidst gøres {@code temp} til {@code hylder}.
     * <p>
     * DEVNOTE: Denne metode er hverken implementeret eller brugt i version 1.0,
     * men kan let implementeres hvis det bliver nødvendigt på et senere tidspunkt.
     */
    public void setAntalHylder(int antalHylder) {
        if (antalHylder < 0) {
            throw new IllegalArgumentException("DET MÅ DU SLET IKKE, DET DER!");
        }
        if (antalHylder < hylder.length && !this.isEmpty()) {
            for (int i = antalHylder; i < hylder.length; i++) {
                for (int j = 0; j < hylder[i].getPladser().length; j++) {
                    if (hylder[i].getPladser()[j].isEmpty()) {
                        throw new IllegalArgumentException("Du er ved at slette en hylde, " +
                                "hvorpå der stadig er et fad! Fjern venligst fadet først, og forsøg så igen.");
                    }
                }
            }
        }
        LagerHylde[] tempHyldeArray = new LagerHylde[antalHylder];
        System.arraycopy(hylder, 0, tempHyldeArray, 0, tempHyldeArray.length);
        hylder = tempHyldeArray;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(Arrays.toString(hylder));
        return sb.toString();
    }
}
