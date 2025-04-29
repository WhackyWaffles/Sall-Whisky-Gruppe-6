package models;

public enum FadType {
    EX_OLOROSO ("Ex-oloroso"),
    EX_BOURBON ("ex-bourbon");

    private final String navn;

    FadType(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

}
