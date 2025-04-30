package models;

import java.util.ArrayList;

public class Malt {
    private ArrayList<Korn> kornsorter;
    private Charring charring;
    private boolean erRoeget;
    private String gaer;

    public Malt(ArrayList<Korn> kornsorter, Charring charring, boolean erRoeget, String gaer) {
        this.kornsorter = kornsorter;
        this.charring = charring;
        this.erRoeget = erRoeget;
        this.gaer = gaer;
    }
}
