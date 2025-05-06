package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky extends Påfyldning {

    public Whisky(String navn, Fad fad,
                  ArrayList<Destillering> destilleringer, int påfyldtAntalLiter,
                  LocalDate påfyldningsDato, ArrayList<Double> aBV_Historie) {
        super.navn = navn;
        super.fad = fad;
        super.destilleringer = destilleringer;
        super.påfyldtAntalLiter = påfyldtAntalLiter;
        super.påfyldningsDato = påfyldningsDato;
        // super.aBV_Historie.getLast() er den "nuværende" eller "endelige" AlkoholProcent.
        super.aBV_Historie = aBV_Historie;
    }


}
