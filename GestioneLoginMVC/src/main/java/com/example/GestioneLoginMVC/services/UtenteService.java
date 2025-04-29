package com.example.GestioneLoginMVC.services;

import com.example.GestioneLoginMVC.dto.UtenteDTO;
import com.example.GestioneLoginMVC.models.Utente;

public interface UtenteService {
    public Utente creaUtenteAdmin(String name, String email, String password);
    public Utente registerUser(UtenteDTO utente);
    public Utente authenticateUser(String email, String password);
}
