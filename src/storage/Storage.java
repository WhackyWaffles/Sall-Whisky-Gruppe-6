package storage;

import models.Destillat;
import models.Korn;
import models.Malt;
import models.Påfyldning;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Korn> kornSorter;
    private List<Malt> malts;
    private List<Destillat> destilleringer;
    private List<Påfyldning> påfyldninger;

    public Storage() {
        kornSorter = new ArrayList<>();
        malts = new ArrayList<>();
        destilleringer = new ArrayList<>();
        påfyldninger = new ArrayList<>();
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
    public List<Destillat> getAllDestilleringer() {
        return new ArrayList<>(destilleringer);
    }

    /**
     * Gemmer destillering
     */
    public void addDestillering(Destillat destillering) {
        if (!destilleringer.contains(destillering)) {
            destilleringer.add(destillering);
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
}
