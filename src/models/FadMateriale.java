package models;

public enum FadMateriale {
    EGETRÆ ("Egetræ");

    private final String navn;
    
    FadMateriale(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }
    
}