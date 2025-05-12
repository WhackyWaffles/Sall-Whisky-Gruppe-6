package controller;

import models.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static Påfyldning påfyldning;
    private static Storage storage;
    private static Controller controller;

    Controller() {
        storage = new Storage();
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void opretKorn(Korn korn) {
        storage.addKorn(korn);
    }
    public List getAllKornSorter() {
        return storage.getAllKornSorter();
    }

    public void opretMalt(Malt malt) {
        storage.addMalt(malt);
    }
    public List getAllMalts() {
        return storage.getAllMalts();
    }

    public static Fad opretFad(String nr, String fadtype, String fadMateriale, double kapacitet, Charring charring, FillNummer fillNummer, ArrayList<Påfyldning> påfyldninger) {
        Fad fad = new Fad(nr, fadtype, fadMateriale, kapacitet, charring, fillNummer, påfyldninger);
        Storage.addFad(fad);
        return fad;}
    public static List<Fad> getAlleFade() {return storage.getAlleFade();}

    public Fad findFad(String fadNr) {
        for (Fad fad : storage.getAlleFade()) {
            if (fad.getNr().equals(fadNr)) {
                return fad;
            }
        }
        return null; // Returner null, hvis ingen match findes
    }

    public static Destillat opretDestillat(String batchNr, double alkoholProcent, double destillatLiter, LocalDate destilleringDato, Ristning ristning) {
        Destillat destillat = new Destillat(batchNr, alkoholProcent, destillatLiter, destilleringDato, ristning);
        storage.addDestillat(destillat);
        return destillat;}
    public List<Destillat> getAllDestillater() {
        return storage.getAlleDestillater();
    }

    public Destillat findDestillat(String batchNr) {
        for (Destillat destillat : storage.getAlleDestillater()) {
            if (destillat.getBatchNr().equals(batchNr)) {
                return destillat;
            }
        }
        return null; // Returnér null, hvis ingen match findes
    }

    public void tilføjPåfyldning(String idNr, Destillat destillat, Fad fad, double påfyldningLiter, LocalDate påfyldningDato) {
        Påfyldning påfyldning = new Påfyldning(idNr, destillat, fad, påfyldningLiter, påfyldningDato);
        fad.tilføjPåfyldning(påfyldning);
        storage.addPåfyldning(påfyldning);
    }
}
