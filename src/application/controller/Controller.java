package application.controller;

import application.models.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    // ======================================================================
    // KornSorter
    // ======================================================================

    // Constructor
    public static Korn opretKorn(String mark, String lokation, String kornSort) {
        Korn korn = new Korn(mark, lokation, kornSort);
        Storage.addKorn(korn);
        return korn;
    }

    // GetAll
    public static ArrayList<Korn> getAllKornSorter() {
        return Storage.getAllKornSorter();
    }

    // ======================================================================
    // Malt
    // ======================================================================

    // Constructor
    public static Malt opretMalt(ArrayList<Korn> kornsorter, Ristning ristning,
                                 boolean erRoeget, String gaer) {
        Malt malt = new Malt(kornsorter, ristning, erRoeget, gaer);
        Storage.addMalt(malt);
        return malt;
    }

    // GetAll
    public static ArrayList<Malt> getAllMalts() {
        return Storage.getAllMalts();
    }

    // ======================================================================
    // Fad
    // ======================================================================

    // Constructor
    /**
     * Constructor af et Fad, muligvis med indhold.
     * @param fadNr {@code String} Fadets unikke ID.
     * @param fadtype {@code String} Hvilken slags drik, der før har været i Fadet, eks. Ex-Oloroso
     * @param fadMateriale {@code String} Hvilken slags træ, Fadet er lavet af.
     * @param kapacitet {@code double} Hvor mange Liter, der kan være i Fadet.
     * @param charring {@code Charring} Hvilken behandling Fadet har.
     * @param fillNummer {@code FillNummer} Hvor mange gange fadet har været brugt.
     * @param påfyldninger {@code ArrayList<Påfyldning>} Hvilke påfyldninger, der er hældt i Fadet, dvs. Fadets indhold. Hvis {@code null} oprettes et tomt fad.
     */
    public static Fad opretFad(String fadNr, String fadtype, String fadMateriale,
                               double kapacitet, Charring charring, FillNummer fillNummer,
                               ArrayList<Påfyldning> påfyldninger) {
        if (kapacitet <= 0) {
            throw new IllegalArgumentException("Kapacitet kan ikke være negativ eller nul");
        }
        if (fadNr == null || fadNr.isBlank()) {
            throw new IllegalArgumentException("Fadnummer kan ikke være null eller tomt");
        }
        Fad fad = new Fad(fadNr, fadtype, fadMateriale, kapacitet, charring, fillNummer, påfyldninger);
        Storage.addFad(fad);
        return fad;
    }

    // GetAll
    /**
     * @return En komplet Liste af alle Fade i Storage
     */
    public static List<Fad> getAlleFade() {
        return Storage.getAlleFade();
    }

    /**
     * Leder i Storage efter et bestemt fad
     * @param fadNr Leder baseret på fadets unikke ID
     * @return fadet hvis det bliver fundet, ellers {@code null}
     */
    public static Fad findFad(String fadNr) {
        if (fadNr == null) {
            throw new NullPointerException("Fadnummer må ikke være null");
        }
        for (Fad fad : Storage.getAlleFade()) {
            if (fad.getFadNr().equals(fadNr)) {
                return fad;
            }
        }
        return null; // Returner null, hvis ingen match findes
    }

    // ======================================================================
    // Destillat
    // ======================================================================

    // Constructor
    public static Destillat opretDestillat(String batchNr, String alkoholProcent, double destillatLiter, LocalDate destilleringDato, Ristning ristning) {
        Destillat destillat = new Destillat(batchNr, alkoholProcent, destillatLiter, destilleringDato, ristning);
        Storage.addDestillat(destillat);
        return destillat;
    }

    // GetAll
    public static List<Destillat> getAllDestillater() {
        return Storage.getAlleDestillater();
    }

    public static Destillat findDestillat(String batchNr) {
        if (batchNr == null) {
            throw new NullPointerException("BatchNummer må ikke være null!");
        }
        for (Destillat destillat : Storage.getAlleDestillater()) {
            if (destillat.getBatchNr().equals(batchNr)) {
                return destillat;
            }
        }
        return null; // Returnér null, hvis ingen match findes
    }

    // ======================================================================
    // Påfyldning
    // ======================================================================

    // Constructor
    /**
     * Opretter en ny Påfyldning
     * @param idNr Påfyldningens unikke idNr
     * @param destillat Destillatet, der fyldes på Fadet
     * @param fad Fadet, der fyldes på.
     * @param påfyldningLiter mængden af Destillat, der fyldes på.
     * @param påfyldningDato Datoen, påfyldningen sker.
     * @return Den nyoprettede Påfyldning
     */
    public static Påfyldning opretPåfyldning(String idNr, Destillat destillat, Fad fad,
                                             double påfyldningLiter, LocalDate påfyldningDato) {
        Påfyldning påfyldning = new Påfyldning(idNr, destillat, fad, påfyldningLiter, påfyldningDato);
        Storage.addPåfyldning(påfyldning);
        return påfyldning;
    }

    // GetAll
    public static List<Påfyldning> getAllePåfyldninger() {
        return Storage.getAllePåfyldninger();
    }

    // ======================================================================
    // Whisky
    // ======================================================================

    // Constructor
    /**
     * Opretter en Whisky
     * @param whiskyId Den Whisky, der aftappes.
     * @param navn Whiskyens navn
     * @param flaskeNr Antallet af Whiskyflasker
     * @param slutAlkoholProcent Whiskyens alkoholprocent på aftapningstidspunktet.
     * @param aftapningsDato Datoen, whiskyen aftappes.
     * @param fad Fadet, whiskyen aftappes fra.
     * @return Den oprettede Whisky.
     */
    public static Whisky opretWhisky(String whiskyId, String navn, int flaskeNr,
                              String slutAlkoholProcent, LocalDate aftapningsDato, Fad fad) {
        Whisky whisky = new Whisky(whiskyId, navn, flaskeNr, slutAlkoholProcent, aftapningsDato, fad);
        Storage.addWhisky(whisky);
        return whisky;
    }

    // GetAll
    public static List<Whisky> getAllWhisky() {
        return Storage.getWhiskyList();
    }

    /**
     * Fjerner en Whisky fra Storage
     * @param id Whiskyens ID
     * @return {@code True} hvis Whiskyen er blevet fjernet.
     */
    public static boolean removeWhiskyById(String id) {
        return Storage.removeWhiskyById(id);
    }

    /**
     * Finder en Whisky i Storage
     * @param id Whiskyens ID
     * @return Whiskyen, hvis den er blevet fjernet.
     * <p>
     * Ellers null.
     */
    public static Whisky findWhiskyById(String id) {
        return Storage.findWhiskyById(id);
    }

    // ======================================================================
    // Lager
    // ======================================================================

    // Constructor
    public static Lager opretLager(String navn, String lokation,
                                   int antalReoler, int antalHylder, int antalPladserPerHylde) {
        Lager lager = new Lager(navn, lokation, antalReoler, antalHylder, antalPladserPerHylde);
        Storage.addLager(lager);
        return lager;
    }

    // GetAll
    public static List<Lager> getAllLagerhuse() {
        return Storage.getAllLagerhuse();
    }

    public static List<String> getFadePåLager(Lager lager) {
        if (lager != null) {
            return lager.hentFadeMedKoordinater(); // Returner liste af fade med koordinater
        } else {
            return new ArrayList<>(); // Returner tom liste, hvis intet lager er valgt
        }
    }
}

