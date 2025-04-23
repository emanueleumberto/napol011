package com.example.GestionePIzzeriaJDBC.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private Long id;
    private String nome;
    private String telefono;

}
