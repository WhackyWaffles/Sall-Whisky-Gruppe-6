package application.models;

// Dette er en hjælpeklasse for at vise alder og fad til whiskylagringen
public class WhiskyLagretPåFad {
    private Fad fad;
    private int antalÅr;

    public WhiskyLagretPåFad(Fad fad, int antalÅr) {
        this.fad = fad;
        this.antalÅr = antalÅr;
    }

    public Fad getLagerFad() {
        return fad;
    }

    public int getAntalÅr() {
        return antalÅr;
    }

    @Override
    public String toString() {
        return fad.toString() + " | Lagret i " + antalÅr + " år";
    }
}
