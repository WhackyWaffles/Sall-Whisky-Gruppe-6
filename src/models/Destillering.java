package models;

import java.util.ArrayList;

public class Destillering {
    private String batchNr;
    private String alkoholProcent;
    private int evtAntalGange;
    private int tempLiter;
    private ArrayList<Malt> malts;

    public Destillering(String batchNr, String alkoholProcent) {
        this.batchNr = batchNr;
        this.alkoholProcent = alkoholProcent;
    }

    public String getBatchNr() {
        return batchNr;
    }

    public String getAlkoholProcent() {
        return alkoholProcent;
    }
}
