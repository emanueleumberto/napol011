package org.example.Esercizio.entities;

import java.time.LocalDate;

public class Ordine {

    private int idOrdine;
    private Cliente cliente;
    private LocalDate dataOrdine;
    private DettaglioOrdine dettaglioOrdine;

    public Ordine(Cliente cliente, Prodotto prodotto, int quantita) {
        this.cliente = cliente;
        this.dettaglioOrdine = new DettaglioOrdine(prodotto, quantita);
    }

    public Ordine(int idOrdine, Cliente cliente, LocalDate dataOrdine, DettaglioOrdine dettaglioOrdine) {
        this.idOrdine = idOrdine;
        this.cliente = cliente;
        this.dataOrdine = dataOrdine;
        this.dettaglioOrdine = dettaglioOrdine;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public DettaglioOrdine getDettaglioOrdine() {
        return dettaglioOrdine;
    }

    public void setDettaglioOrdine(DettaglioOrdine dettaglioOrdine) {
        this.dettaglioOrdine = dettaglioOrdine;
    }

    @Override
    public String toString() {
        return idOrdine + " - cliente: " + cliente + ", dataOrdine=" + dataOrdine + ", dettaglioOrdine: " + dettaglioOrdine;
    }
}
