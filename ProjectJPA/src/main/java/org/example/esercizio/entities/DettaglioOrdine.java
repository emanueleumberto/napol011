package org.example.esercizio.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "dettagli_ordini")
public class DettaglioOrdine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dettaglio_ordine;
    @Column(nullable = false)
    private Integer quantita;
    @Column(name = "prezzo_unitario" ,nullable = false, precision = 10, scale = 2)
    private BigDecimal prezzoUnitario;

    @ManyToOne
    @JoinColumn(name = "id_ordine", foreignKey = @ForeignKey(name = "dettaglio_ordini_ordine_fk"))
    private Ordine ordine;

    @ManyToOne
    @JoinColumn(name = "id_prodotto", foreignKey = @ForeignKey(name = "dettaglio_ordini_prodotti_fk"))
    private Prodotto prodotto;

    public DettaglioOrdine() {}

    public DettaglioOrdine(Integer quantita, Ordine ordine, Prodotto prodotto) {
        this.quantita = quantita;
        this.ordine = ordine;
        this.prezzoUnitario = prodotto.getPrezzo();
        this.prodotto = prodotto;
    }

    public Integer getId_dettaglio_ordine() {
        return id_dettaglio_ordine;
    }
    public void setId_dettaglio_ordine(Integer id_dettaglio_ordine) {
        this.id_dettaglio_ordine = id_dettaglio_ordine;
    }
    public Integer getQuantita() {
        return quantita;
    }
    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
    public BigDecimal getPrezzoUnitario() {
        return prezzoUnitario;
    }
    public void setPrezzoUnitario(BigDecimal prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }
    public Ordine getOrdine() {
        return ordine;
    }
    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
    public Prodotto getProdotto() {
        return prodotto;
    }
    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" +
                "id_dettaglio_ordine=" + id_dettaglio_ordine +
                ", quantita=" + quantita +
                ", prezzoUnitario=" + prezzoUnitario +
                ", prodotto=" + prodotto +
                '}';
    }
}
