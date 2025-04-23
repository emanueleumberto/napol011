package com.example.GestionePIzzeriaJDBC.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Pizza extends Prodotto {

    List<String> ingredienti;

    public Pizza(String nome, Double prezzo, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = new ArrayList<String>();
    }

    public Pizza(String nome, Double prezzo, List<String> ingredienti, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return super.toString() + " ingredienti: " + ingredienti;
    }
}
