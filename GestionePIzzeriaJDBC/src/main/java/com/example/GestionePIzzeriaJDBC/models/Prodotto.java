package com.example.GestionePIzzeriaJDBC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prodotto {

    private Long id;
    private String nome;
    private Double prezzo;
    private Menu menu;

    public Prodotto(String nome, Double prezzo, Menu menu) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Prodotto - id: " + id +
                ", nome: " + nome +
                ", prezzo: " + prezzo +
                ", menu: " + menu + " ";
    }
}
