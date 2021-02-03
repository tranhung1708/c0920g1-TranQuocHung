package vn.codegym.model;

public class Dictionary {
    String VI;
    String EN;

    public Dictionary() {
    }

    public Dictionary(String VI, String EN) {
        this.VI = VI;
        this.EN = EN;
    }

    public String getVI() {
        return VI;
    }

    public void setVI(String VI) {
        this.VI = VI;
    }

    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }
}
