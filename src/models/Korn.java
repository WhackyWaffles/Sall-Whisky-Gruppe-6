package models;

public class Korn {
    private String mark;
    private String lokation;
    private String kornSort;
    // TODO: finde ud af hvad vi gør med maengde for korn (hvis noget)
    private int maengde;

    public Korn(String mark, String lokation, String kornSort) {
        this.mark = mark;
        this.lokation = lokation;
        this.kornSort = kornSort;
    }

    public String getMark() {
        return mark;
    }

    public String getLokation() {
        return lokation;
    }

    public String getKornSort() {
        return kornSort;
    }

    public int getMaengde() {
        return maengde;
    }
}
