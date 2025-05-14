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

    //Her er metode opretFad() i controller:
//    public static Fad opretFad(String nr, String fadtype, String fadMateriale, double kapacitet, Charring charring, FillNummer fillNummer, ArrayList<Påfyldning> påfyldninger) {
//        Fad fad = new Fad(nr, fadtype, fadMateriale, kapacitet, charring, fillNummer, påfyldninger);
//        Storage.addFad(fad);
//        return fad;
//    }

    //Create a Whisky
    public  Whisky opretWhisky(String whiskyId, String navn, int flaskeNr, String slutAlkoholProcent, LocalDate aftapningsDato, Fad fad) {
        Whisky whisky = new Whisky(whiskyId, navn, flaskeNr, slutAlkoholProcent, aftapningsDato, fad);
        storage.addWhisky(whisky);
        return whisky;
    }
    public List getAllWhisky() {
        return storage.getWhiskyList();
    }
    public boolean removeWhiskyById(String id) {
        return storage.removeWhiskyById(id);
    }
    public Whisky findWhiskyById(String id) {
        return storage.findWhiskyById(id);
    }



}
