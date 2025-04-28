package com.example.GestionePizzeriaJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private List<Prodotto> listaProdotti;

    public Menu() {
        this.listaProdotti = new ArrayList<Prodotto>();
    }

    @Override
    public String toString() {
        return "Menu " + nome;
    }
}
