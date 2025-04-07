package org.example.Esercizio_0404;

import java.util.ArrayList;
import java.util.List;

public class Veicolo {

    private String targa;
    private String marca;
    private String modello;
    private int annoImmatricolazione;
    private List<String> interventiManutenzione;

    public Veicolo(String targa, String marca, String modello, int annoImmatricolazione) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.annoImmatricolazione = annoImmatricolazione;
        this.interventiManutenzione = new ArrayList<String>();
    }

    public String getTarga() { return targa; }
    public String getMarca() { return marca; }
    public String getModello() { return modello; }
    public int getAnnoImmatricolazione() { return annoImmatricolazione; }
    public List<String> getInterventiManutenzione() { return interventiManutenzione; }

    public void aggiungiIntervento(String intervento) {
        this.interventiManutenzione.add(intervento);
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "targa='" + targa + '\'' +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", annoImmatricolazione=" + annoImmatricolazione +
                ", interventiManutenzione=" + interventiManutenzione +
                '}';
    }
}
