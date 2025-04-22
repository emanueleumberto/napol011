package com.example.GestionePizzeria.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Drink extends Prodotto{

    private Integer gradi;

    public Drink(String nome, Double prezzo, Integer gradi) {
        super(nome, prezzo);
        this.gradi = gradi;
    }
}
