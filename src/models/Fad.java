package models;

import java.util.ArrayList;

public class Fad {
    private int fadNr;
    private int størrelse;
    private FadType fadtype;
    private FadMateriale fadMateriale;
    private Påfyldning indhold;
    private LagerPlads lagerPlads;
    private ArrayList<Påfyldning> påfyldninger = new ArrayList<>();
    // TODO - Finde ud af, hvordan et fads historie gemmes

    /**
     * Constructor af et fyldt Fad.
     * @param størrelse Hvor mange Liter, der kan være i Fadet.
     * @param fadtype Hvilken slags drik, der før har været i Fadet, eks. Ex-Oloroso
     * @param fadMateriale Hvilken slags træ, Fadet er lavet af.
     * @param indhold Hvad Fadet er fyldt med.
     * @param lagerPlads Hvor Fadet er lagret.
     */
    public Fad(int størrelse, FadType fadtype, FadMateriale fadMateriale, Påfyldning indhold, LagerPlads lagerPlads) {
        this.størrelse = størrelse;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.indhold = indhold;
        // Tilføjer nuværende indhold til Fadets indholds-historie.
        påfyldninger.add(indhold);
        this.lagerPlads = lagerPlads;
    }

    /**
     * Constructor af et tomt Fad.
     */
    public Fad(int størrelse, FadType fadtype, FadMateriale fadMateriale, LagerPlads lagerPlads) {
        this.størrelse = størrelse;
        this.fadtype = fadtype;
        this.fadMateriale = fadMateriale;
        this.lagerPlads = lagerPlads;
    }

}
