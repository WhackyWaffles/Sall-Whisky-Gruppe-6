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
    private List<Whisky> whiskyList;
    private static List<Lager> lagerListe;

    public Storage() {
        kornSorter = new ArrayList<>();
        malts = new ArrayList<>();
        destillater = new ArrayList<>();
        fade = new ArrayList<>();
        påfyldninger = new ArrayList<>();
        whiskyList = new ArrayList<>();
        lagerListe = new ArrayList<>();
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
     * Opdaterer storage med fade, der har modtaget en påfyldning
     */
    public static void opdaterFad(Fad opdateretFad) {
        for (int i = 0; i < fade.size(); i++) {
            if (fade.get(i).getFadNr().equals(opdateretFad.getFadNr())) {
                fade.set(i, opdateretFad); // opdaterer fadet i listen
                return;
            }
        }
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
    /**
     * Returnerer en liste med alle gemte påfyldninger
     */
    public List<Påfyldning> getAllePåfyldninger() {
        return new ArrayList<>(påfyldninger);
    }

    /**
     * Gemmer whisky
     */
    public void addWhisky(Whisky whisky) {
        if (!whiskyList.contains(whisky)) {
            whiskyList.add(whisky);
        }
    }

    public List getWhiskyList() {
        return new ArrayList(whiskyList);
    }

    public boolean removeWhiskyById(String id) {
        return whiskyList.removeIf(w -> w.getWhiskyId().equals(id));
    }
    public Whisky findWhiskyById(String id) {
        for (Whisky w : whiskyList) {
            if (w.getWhiskyId().equals(id)) return w;
        }
        return null;
    }

    public void addLager(Lager lager) {
        if (!lagerListe.contains(lager)) {
            lagerListe.add(lager);
        }
    }

    public static List<Lager> getAlleLagre() { return new ArrayList<>(lagerListe);
    }
}
