package com.example.GestionePizzeria.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Pizza extends Prodotto {

    List<String> ingredienti;

    public Pizza(String nome, Double prezzo) {
        super(nome, prezzo);
        this.ingredienti = new ArrayList<String>();
    }

    public Pizza(String nome, Double prezzo, List<String> ingredienti) {
        super(nome, prezzo);
        this.ingredienti = ingredienti;
    }
}
