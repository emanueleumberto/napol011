package com.example.IntroSpring.Esercizio.classes;

public abstract class Prodotto {

    private String nome;
    private double prezzo;

    public Prodotto() {}

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return nome + " prezzo: " + prezzo;
    }
}
