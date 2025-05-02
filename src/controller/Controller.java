package controller;

import models.Destillering;
import models.Korn;
import models.Malt;
import storage.Storage;

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

    public List getAllKornMalts() {
        return storage.getAllMalts();
    }

    public void opretDestillering(Destillering destillering) {
        storage.addDestillering(destillering);
    }

    public List getAllDestilleringer() {
        return storage.getAllDestilleringer();
    }
}
