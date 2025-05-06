package models;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Påfyldning {
    String navn;
    Fad fad;
    ArrayList<Destillering> destilleringer;
    int påfyldtAntalLiter;
    LocalDate påfyldningsDato;
    ArrayList<Double> aBV_Historie;
//    ArrayList<Object[]>
// TODO - Skal finde ud af, hvordan man gemmer data for flere forskellige påfyldtAntalLiter
}
