package storage;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Korn> kornSorter;
    private List<Malt> malts;
    private List<Destillat> destillater;
    private static List<Fad> fade;
    private List<Påfyldning> påfyldninger;

    public Storage() {
        kornSorter = new ArrayList<>();
        malts = new ArrayList<>();
        destillater = new ArrayList<>();
        fade = new ArrayList<>();
        påfyldninger = new ArrayList<>();
    }

    /**
     * Gemmer kornsort
     */
    public void addKorn(Korn korn) {
        if (!kornSorter.contains(korn)) {
            kornSorter.add(korn);
        }
    }

    /**
     * Returnerer en liste med alle gemte kornsorter
     */
    public List<Korn> getAllKornSorter() {
        return new ArrayList<>(kornSorter);
    }

    /**
     * Gemmer malt
     */
    public void addMalt(Malt malt) {
        if (!malts.contains(malt)) {
            malts.add(malt);
        }
    }

    /**
     * Returnerer en liste med alle gemte malts
     */
    public List<Malt> getAllMalts() {
        return new ArrayList<>(malts);
    }

    /**
     * Gemmer destillering
     */
    public void addDestillat(Destillat destillat) {
        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
        }
    }

    /**
     * Returnerer en liste med alle gemte destilleringer
     */
    public List<Destillat> getAlleDestillater() {
        return new ArrayList<>(destillater);
    }

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
    public List<Fad> getAlleFade() {
        return new ArrayList<>(fade);
    }

    /**
     * Returnerer en liste med alle gemte påfyldninger
     */
    public List<Påfyldning> getAllPåfyldninger() {
        return new ArrayList<>(påfyldninger);
    }

    /**
     * Gemmer påfyldning
     */
    public void addPåfyldning(Påfyldning påfyldning) {
        if (!påfyldninger.contains(påfyldning)) {
            påfyldninger.add(påfyldning);
        }
    }
}
