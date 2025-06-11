package application.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Whisky {

    private String whiskyId;
    private String navn;
    private int flaskeNr;
    private String slutAlkoholProcent;
    private LocalDate aftapningsDato;
    private ArrayList<WhiskyLagretPåFad> lagerFade = new ArrayList<>();

    public Whisky(String whiskyId, String navn, int flaskeNr, String slutAlkoholProcent, LocalDate aftapningsDato) {
        this.whiskyId = whiskyId;
        this.navn = navn;
        this.flaskeNr = flaskeNr;
        this.slutAlkoholProcent = slutAlkoholProcent;
        this.aftapningsDato = aftapningsDato;
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

    public ArrayList<WhiskyLagretPåFad> getLagerFade() {
        return lagerFade;
    }

    public void addFad(Fad fad, int antalÅr) {
        lagerFade.add(new WhiskyLagretPåFad(fad, antalÅr));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(whiskyId).append(", ").append(" '").append(navn).append("', ")
                .append(flaskeNr).append(" fl, ")
                .append(slutAlkoholProcent).append("%, ")
                .append(aftapningsDato);

        if (!lagerFade.isEmpty()) {
            sb.append(" | Fade:\n");
            for (WhiskyLagretPåFad wlf : lagerFade) {
                sb.append("  - ").append(wlf).append("\n");
            }
        } else {
            sb.append(" | Ingen tilknyttede fade.");
        }
        return sb.toString();
    }
}