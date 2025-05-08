package controller;

import models.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.List;

public class Controller {
    private Storage storage;
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

    public void opretDestillat(Destillat destillat) {
        storage.addDestillat(destillat);
    }

    public List getAllDestillater() {
        return storage.getAllDestillater();
    }

    public void tilføjPåfyldning(Destillat destillat, Fad fad, double liter, LocalDate dato) {
        Påfyldning påfyldning = new Påfyldning(destillat, fad, liter, dato);
        fad.tilføjPåfyldning(påfyldning);
        storage.addPåfyldning(påfyldning);
    }
}
