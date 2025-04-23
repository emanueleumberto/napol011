package com.example.GestionePIzzeriaJDBC.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Drink extends Prodotto{

    private Integer gradi;

    public Drink(String nome, Double prezzo, Integer gradi, Menu menu) {
        super(nome, prezzo, menu);
        this.gradi = gradi;
    }

    @Override
    public String toString() {
        return super.toString() + " gradi: " + gradi;
    }
}
