package application.models;

import java.time.LocalDate;

public class Whisky {

    private String whiskyId;
    private String navn;
    private int flaskeNr;
    private String slutAlkoholProcent;
    private LocalDate aftapningsDato;
    private Fad fad;

    public Whisky(String whiskyId, String navn, int flaskeNr, String slutAlkoholProcent, LocalDate aftapningsDato, Fad fad) {
        this.whiskyId = whiskyId;
        this.navn = navn;
        this.flaskeNr = flaskeNr;
        this.slutAlkoholProcent = slutAlkoholProcent;
        this.aftapningsDato = aftapningsDato;
        this.fad = fad;
    }

    public String getWhiskyId() {
        return whiskyId;
    }

    public void setWhiskyId(String whiskyId) {
        this.whiskyId = whiskyId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getFlaskeNr() {
        return flaskeNr;
    }

    public void setFlaskeNr(int flaskeNr) {
        this.flaskeNr = flaskeNr;
    }

    public String getSlutAlkoholProcent() {
        return slutAlkoholProcent;
    }

    public void setSlutAlkoholProcent(String slutAlkoholProcent) {
        this.slutAlkoholProcent = slutAlkoholProcent;
    }

    public LocalDate getAftapningsDato() {
        return aftapningsDato;
    }

    public void setAftapningsDato(LocalDate aftapningsDato) {
        this.aftapningsDato = aftapningsDato;
    }

    public Fad getFad() {
        return fad;
    }

    public void setFad(Fad fad) {
        this.fad = fad;
    }

    @Override
    public String toString() {
        return
                whiskyId + '\'' +
                        '\''+ navn + '\'' +
                        '\''+ flaskeNr +
                        '\''+ slutAlkoholProcent +
                        '\'' + aftapningsDato +
                        "fad "+ '\'' + fad ;
    }

}