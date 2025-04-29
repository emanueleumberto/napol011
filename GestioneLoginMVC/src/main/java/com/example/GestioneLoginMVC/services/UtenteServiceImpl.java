package com.example.GestioneLoginMVC.services;

import com.example.GestioneLoginMVC.dto.UtenteDTO;
import com.example.GestioneLoginMVC.enumerations.Ruolo;
import com.example.GestioneLoginMVC.models.Utente;
import com.example.GestioneLoginMVC.repositories.UtenteDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired @Qualifier("creaUtente") ObjectProvider<Utente> utenteObjectProvider;
    @Autowired UtenteDAORepository db;

    @Override
    public Utente creaUtenteAdmin(String name, String email, String password) {
        Utente utente = utenteObjectProvider.getObject();
        utente.setNome(name);
        utente.setEmail(email);
        utente.setPassword(password);
        utente.setRuolo(Ruolo.ADMIN);
        return db.save(utente);
    }

    @Override
    public Utente registerUser(UtenteDTO utente) {
        Utente u = utenteObjectProvider.getObject();
        u.setNome(utente.getNome());
        u.setPassword(utente.getPassword());
        u.setEmail(utente.getEmail());;
        return db.save(u);
    }

    @Override
    public Utente authenticateUser(String email, String password) {
        return db.findByEmailAndPassword(email, password);
    }
}
