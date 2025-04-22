package com.example.GestionePizzeria.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Menu {

    private String nome;
    private List<Pizza> listaPizze;
    private List<Drink> listaDrink;

    public Menu() {
        this.listaPizze = new ArrayList<Pizza>();
        this.listaDrink = new ArrayList<Drink>();
    }

    public void stampaMenu() {
        System.out.println("************* Menu Pizzeria " + nome + " **************");
        System.out.println("----- Pizze -----");
        this.listaPizze.forEach(p -> {
            System.out.print(this.listaPizze.indexOf(p)+1 + " - ");
            System.out.println(p.getNome() + " " + p.getIngredienti().toString() + " €" + p.getPrezzo());
        });
        System.out.println("----- Drink -----");
        this.listaDrink.forEach(d -> {
            System.out.print(this.listaDrink.indexOf(d)+1 + " - ");
            System.out.println(d.getNome() + " " + d.getGradi() + "° €" + d.getPrezzo() );
        });

    }

}
