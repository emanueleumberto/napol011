package com.example.IntroSpring.Esercizio.classes;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String nome;
    private List<Pizza> listaPizze;
    private List<Drink> listaDrink;

    public Menu(String nome) {
        this.nome = nome;
        this.listaPizze = new ArrayList<Pizza>();
        this.listaDrink = new ArrayList<Drink>();
    }

    public Menu(String nome, List<Pizza> listaPizze, List<Drink> listaDrink) {
        this.nome = nome;
        this.listaPizze = listaPizze;
        this.listaDrink = listaDrink;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Pizza> getListaPizze() {
        return listaPizze;
    }
    public void setListaPizze(List<Pizza> listaPizze) {
        this.listaPizze = listaPizze;
    }
    public List<Drink> getListaDrink() {
        return listaDrink;
    }
    public void setListaDrink(List<Drink> listaDrink) {
        this.listaDrink = listaDrink;
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

    @Override
    public String toString() {
        return "Menu{" +
                "nome='" + nome + '\'' +
                ", listaPizze=" + listaPizze +
                ", listaDrink=" + listaDrink +
                '}';
    }
}
