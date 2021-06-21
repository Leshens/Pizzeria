package Projekt;

import javafx.beans.property.*;

public class Zamowienie {
    private StringProperty Rodzaj = new SimpleStringProperty();
    private StringProperty Wielkosc = new SimpleStringProperty();
    private DoubleProperty Cena =new SimpleDoubleProperty();

    public Zamowienie() {
        Cena.set(0);
    }

    public Zamowienie(String rodzaj, String wielkosc, double cena) {
        Rodzaj.set(rodzaj);
        Wielkosc.set(wielkosc);
        Cena.set(cena);
    }

    public String getRodzaj() {
        return Rodzaj.get();
    }

    public void setRodzaj(String rodzaj) {
        this.Rodzaj.set(rodzaj);
    }

    public String getWielkosc() {
        return Wielkosc.get();
    }

    public void setWielkosc(String wielkosc) {
        this.Wielkosc.set(wielkosc);
    }

    public double getCena() {
        return Cena.get();
    }

    public void setCena(double cena) {
        this.Cena.set(cena);
    }

}