package storage;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Korn> kornSorter;
    private List<Malt> malts;
    private List<Destillat> destilleringer;
    private List<Påfyldning> påfyldninger;
    private List<Whisky>whiskyList;
    private List<Fad>fade;

    public Storage() {
        kornSorter = new ArrayList<>();
        malts = new ArrayList<>();
        destilleringer = new ArrayList<>();
        påfyldninger = new ArrayList<>();
        whiskyList = new ArrayList<>();
    }

    /**
     * Returnerer en liste med alle gemte kornsorter
     */
    public List<Korn> getAllKornSorter() {
        return new ArrayList<>(kornSorter);
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
     * Returnerer en liste med alle gemte malts
     */
    public List<Malt> getAllMalts() {
        return new ArrayList<>(malts);
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
     * Returnerer en liste med alle gemte destilleringer
     */
    public List<Destillat> getAllDestillater() {
        return new ArrayList<>(destilleringer);
    }

    /**
     * Gemmer destillering
     */
    public void addDestillat(Destillat destillat) {
        if (!destilleringer.contains(destillat)) {
            destilleringer.add(destillat);
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

    /** Whisky */
    public List<Whisky> getWhiskyList() {
        return new ArrayList<>(whiskyList);
    }
    public void addWhisky(Whisky whisky) {
        if(!whiskyList.contains(whisky)) {
            whiskyList.add(whisky);
        }
    }

    public  void addFad(Fad fad) {
        if (!fade.contains(fad)) {
            fade.add(fad);}}

    public boolean removeWhiskyById(String id) {
        return whiskyList.removeIf(w -> w.getWhiskyId().equals(id));
    }
    public Whisky findWhiskyById(String id) {
        for (Whisky w : whiskyList) {
            if (w.getWhiskyId().equals(id)) return w;
        }
        return null;
    }
}
