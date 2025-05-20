package storage;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Korn> kornSorter = new ArrayList<>();
    private static final List<Malt> malts = new ArrayList<>();
    private static final List<Destillat> destillater = new ArrayList<>();
    private static final List<Fad> fade = new ArrayList<>();
    private static final List<Påfyldning> påfyldninger = new ArrayList<>();
    private static final List<Whisky> whiskyList = new ArrayList<>();
    private static final List<Lager> lagerhuse = new ArrayList<>();

    // ======================================================================
    // KornSort
    // ======================================================================

    /**
     * Gemmer kornsort
     */
    public static void addKorn(Korn korn) {
        if (!kornSorter.contains(korn)) {
            kornSorter.add(korn);
        }
    }

    /**
     * Returnerer en liste med alle gemte kornsorter
     */
    public static List<Korn> getAllKornSorter() {
        return new ArrayList<>(kornSorter);
    }

    // ======================================================================
    // Malt
    // ======================================================================

    /**
     * Gemmer malt
     */
    public static void addMalt(Malt malt) {
        if (!malts.contains(malt)) {
            malts.add(malt);
        }
    }

    /**
     * Returnerer en liste med alle gemte malts
     */
    public static List<Malt> getAllMalts() {
        return new ArrayList<>(malts);
    }

    // ======================================================================
    // Destillering
    // ======================================================================

    /**
     * Gemmer destillering
     */
    public static void addDestillat(Destillat destillat) {
        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
        }
    }

    /**
     * Returnerer en liste med alle gemte destilleringer
     */
    public static List<Destillat> getAlleDestillater() {
        return new ArrayList<>(destillater);
    }

    // ======================================================================
    // Fad
    // ======================================================================

    /**
     * Gemmer fad
     */
    public static void addFad(Fad fad) {
        if (!fade.contains(fad)) {
            fade.add(fad);
        }
    }

    /**
     * Returnerer en liste med alle gemte fade
     */
    public static List<Fad> getAlleFade() {
        return new ArrayList<>(fade);
    }


    // ======================================================================
    // Påfyldninger
    // ======================================================================

    /**
     * Returnerer en liste med alle gemte påfyldninger
     */
    public static List<Påfyldning> getAllPåfyldninger() {
        return new ArrayList<>(påfyldninger);
    }

    /**
     * Gemmer påfyldning
     */
    public static void addPåfyldning(Påfyldning påfyldning) {
        if (!påfyldninger.contains(påfyldning)) {
            påfyldninger.add(påfyldning);
        }
    }
    /**
     * Returnerer en liste med alle gemte påfyldninger
     */
    public static List<Påfyldning> getAllePåfyldninger() {
        return new ArrayList<>(påfyldninger);
    }

    // ======================================================================
    // Whisky
    // ======================================================================

    /**
     * Gemmer whisky
     */
    public static void addWhisky(Whisky whisky) {
        if (!whiskyList.contains(whisky)) {
            whiskyList.add(whisky);
        }
    }

    public static List<Whisky> getWhiskyList() {
        return new ArrayList<>(whiskyList);
    }

    public static boolean removeWhiskyById(String id) {
        return whiskyList.removeIf(w -> w.getWhiskyId().equals(id));
    }
    public static Whisky findWhiskyById(String id) {
        for (Whisky w : whiskyList) {
            if (w.getWhiskyId().equals(id)) return w;
        }
        return null;
    }

    // ======================================================================
    // Lager
    // ======================================================================

    /**
     * Gemmer Lager
     */
    public static void addLager(Lager lager) {
        if (!lagerhuse.contains(lager)) {
            lagerhuse.add(lager);
        }
    }

    /**
     * Returnerer en liste med alle gemte lagerhuse
     */
    public static List<Lager> getAllLagerhuse() {
        return new ArrayList<>(lagerhuse);
    }

    /**
     * Sletter alle objekter, der er gemt i Storage
     */
    public static void clearAll() {
        kornSorter.clear();
        malts.clear();
        destillater.clear();
        fade.clear();
        påfyldninger.clear();
        whiskyList.clear();
        lagerhuse.clear();
    }
}
