package com.example.IntroSpring.Esercizio.classes;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Prodotto {

    private List<String> ingredienti;

    public Pizza() {}

    public Pizza(String nome, double prezzo, List<String> ingredienti) {
        super(nome, prezzo);
        this.ingredienti = ingredienti;
    }

    public Pizza(String nome, double prezzo) {
        super(nome, prezzo);
        this.ingredienti = new ArrayList<String>();
    }

    public List<String> getIngredienti() {
        return ingredienti;
    }
    public void setIngredienti(List<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return  " - " + super.toString() + " ingredienti=" + ingredienti;
    }
}
