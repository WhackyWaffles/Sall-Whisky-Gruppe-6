package application.models;

public class Korn {
    private String mark;
    private String lokation;
    private String kornSort;

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

}
