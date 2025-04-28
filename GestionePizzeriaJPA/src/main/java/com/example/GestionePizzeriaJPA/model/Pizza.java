package com.example.GestionePizzeriaJPA.model;

import com.example.GestionePizzeriaJPA.utilities.StringListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("pizza")
public class Pizza extends Prodotto {

    @Convert(converter = StringListConverter.class)
    List<String> ingredienti;

    public Pizza(String nome, Double prezzo, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = new ArrayList<String>();
    }

    public Pizza(String nome, Double prezzo, List<String> ingredienti, Menu menu) {
        super(nome, prezzo, menu);
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return super.toString() + " ingredienti: " + ingredienti;
    }
}
