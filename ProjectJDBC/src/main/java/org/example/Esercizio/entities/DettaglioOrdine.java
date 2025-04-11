package org.example.Esercizio.entities;

public class DettaglioOrdine {

    private int idDettagliOrdine;
    private Prodotto prodotto;
    private int quantita;
    private double prezzoUnitario;

    public DettaglioOrdine(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzoUnitario = prodotto.getPrezzo();
    }

    public DettaglioOrdine(int idDettagliOrdine, Prodotto prodotto, int quantita, double prezzoUnitario) {
        this.idDettagliOrdine = idDettagliOrdine;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public int getIdDettagliOrdine() {
        return idDettagliOrdine;
    }

    public void setIdDettagliOrdine(int idDettagliOrdine) {
        this.idDettagliOrdine = idDettagliOrdine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    @Override
    public String toString() {
        return idDettagliOrdine + " - prodotto: " + prodotto + ", qt=" + quantita +", €" + prezzoUnitario;
    }
}
