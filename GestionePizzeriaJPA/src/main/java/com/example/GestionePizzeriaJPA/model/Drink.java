package com.example.GestionePizzeriaJPA.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("drink")
public class Drink extends Prodotto{

    private Integer gradi;

    public Drink(String nome, Double prezzo, Integer gradi, Menu menu) {
        super(nome, prezzo, menu);
        this.gradi = gradi;
    }

    @Override
    public String toString() {
        return super.toString() + " gradi: " + gradi;
    }
}
