package models;

import java.util.ArrayList;

public class Fad {
    private int størrelse;
    private FadType fadtype;
    private FadMateriale fadMateriale;
    private Væske indhold;
    private LagerPlads lagerPlads;
    private ArrayList<Destillering> destilleringer;
    // TODO - Finde ud af, hvordan et fads historie gemmes


    public Fad(int størrelse, FadType fadtype, FadMateriale fadMateriale, Væske indhold, LagerPlads lagerPlads) {
        this.størrelse = størrelse;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.indhold = indhold;
        this.lagerPlads = lagerPlads;
    }
}
