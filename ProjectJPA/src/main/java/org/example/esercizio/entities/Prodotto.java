package org.example.esercizio.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "prodotti")
@NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prodotto;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String descrizione;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prezzo;
    @Column(name = "quantita_disponibile", nullable = false)
    private Integer quantitaDisponibile;

    public Prodotto() {}

    public Prodotto(String nome, String descrizione, BigDecimal prezzo, Integer quantitaDisponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public Integer getId_prodotto() {
        return id_prodotto;
    }
    public void setId_prodotto(Integer id_prodotto) {
        this.id_prodotto = id_prodotto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public BigDecimal getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
    public Integer getQuantitaDisponibile() {
        return quantitaDisponibile;
    }
    public void setQuantitaDisponibile(Integer quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_prodotto=" + id_prodotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantitaDisponibile=" + quantitaDisponibile +
                '}';
    }
}
