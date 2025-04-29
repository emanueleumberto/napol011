package com.example.GestioneLoginMVC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UtenteDTO {

    private String nome;
    private String email;
    private String password;

}
