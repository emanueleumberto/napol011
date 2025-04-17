package com.example.IntroSpring.Esercizio.classes;

import java.util.List;

public class Drink extends Prodotto {

    private Integer gradi;

    public Drink() {}

    public Drink(String nome, double prezzo, Integer gradi) {
        super(nome, prezzo);
        this.gradi = gradi;
    }

    public Integer getGradi() {
        return gradi;
    }
    public void setGradi(Integer gradi) {
        this.gradi = gradi;
    }


    @Override
    public String toString() {
        return  " - " + super.toString() + " gradi: " + gradi;
    }
}
