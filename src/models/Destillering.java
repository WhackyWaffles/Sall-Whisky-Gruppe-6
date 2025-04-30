package models;

import java.util.ArrayList;

public class Destillering {
    private String batchNr;
    private int alkoholProcent;
    private ArrayList<Malt> malts;

    public Destillering(String batchNr, int alkoholProcent) {
        this.batchNr = batchNr;
        this.alkoholProcent = alkoholProcent;
    }

    public String getBatchNr() {
        return batchNr;
    }

    public int getAlkoholProcent() {
        return alkoholProcent;
    }
}
