package com.example.GestioneLoginMVC.configurations;

import com.example.GestioneLoginMVC.models.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UtenteConfiguration {

    @Bean("creaUtente")
    @Scope("prototype")
    public Utente creaUtente() {
        return new Utente();
    }

}
