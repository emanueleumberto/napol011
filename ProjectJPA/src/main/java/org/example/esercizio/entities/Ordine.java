package org.example.esercizio.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordini")
@NamedQuery(name = "Ordine.findAll", query = "SELECT o FROM Ordine o")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ordine;

    @CreationTimestamp
    @Column(name = "data_ordine", columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime dataOrdine;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "ordini_clienti_fk"))
    private Cliente cliente;

    @OneToMany(mappedBy = "ordine", cascade = CascadeType.ALL)
    private List<DettaglioOrdine> dettaglioOrdine;

    public Ordine() {}

    public Ordine(Cliente cliente) {
        this.cliente = cliente;
        this.dettaglioOrdine = new ArrayList<DettaglioOrdine>();
    }

    public Integer getId_ordine() {
        return id_ordine;
    }
    public void setId_ordine(Integer id_ordine) {
        this.id_ordine = id_ordine;
    }
    public LocalDateTime getDataOrdine() {
        return dataOrdine;
    }
    public void setDataOrdine(LocalDateTime dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<DettaglioOrdine> getDettaglioOrdine() {
        return dettaglioOrdine;
    }
    public void setDettaglioOrdine(List<DettaglioOrdine> dettaglioOrdine) {
        this.dettaglioOrdine = dettaglioOrdine;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", dataOrdine=" + dataOrdine +
                ", cliente=" + cliente +
                ", dettaglioOrdine=" + dettaglioOrdine +
                '}';
    }
}
