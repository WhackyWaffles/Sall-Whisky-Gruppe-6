package models;

import java.util.ArrayList;

public class Destillering {
    private String batchNr;
    private String alkoholProcent;
    private int evtAntalGange;
    private int tempLiter;
    private Ristning ristning;
    private ArrayList<Malt> malts;

    public Destillering(String batchNr, String alkoholProcent, Ristning ristning) {
        this.batchNr = batchNr;
        this.alkoholProcent = alkoholProcent;
        this.ristning = ristning;
    }

    public String getBatchNr() {
        return batchNr;
    }

    public String getAlkoholProcent() {
        return alkoholProcent;
    }

    public Ristning getMalt() { return ristning;}
}
