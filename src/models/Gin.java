package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gin extends Påfyldning {

    public Gin(String navn, Fad fad,
               ArrayList<Destillering> destilleringer, int påfyldtAntalLiter,
               LocalDate påfyldningsDato, ArrayList<Double> aBV_Historie) {
        super.navn = navn;
        super.fad = fad;
        super.destilleringer = destilleringer;
        super.påfyldtAntalLiter = påfyldtAntalLiter;
        super.påfyldningsDato = påfyldningsDato;
        super.aBV_Historie = aBV_Historie;
    }
}
