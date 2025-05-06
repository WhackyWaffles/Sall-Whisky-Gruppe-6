package models;

import java.util.ArrayList;

public class Malt {
    private ArrayList<Korn> kornsorter;
    private Ristning ristning;
    private boolean erRoeget;
    private String gaer;

    public Malt(ArrayList<Korn> kornsorter, Ristning ristning, boolean erRoeget, String gaer) {
        this.kornsorter = kornsorter;
        this.ristning = ristning;
        this.erRoeget = erRoeget;
        this.gaer = gaer;
    }

    public ArrayList<Korn> getKornSorter() {
        return kornsorter;
    }

    public Ristning getRistning() {
        return ristning;
    }

    public boolean erRoeget() {
        return erRoeget;
    }

    public String getGaer() {
        return gaer;
    }

    public void addKorn() {

    }
}
