package com.example.GestioneLoginMVC.runners;

import com.example.GestioneLoginMVC.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UtenteRunner implements CommandLineRunner {

    @Autowired UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UtenteRunner...");
        //utenteService.creaUtenteAdmin("Admin", "admin@example.com", "Pa$$w0rd!");
    }

}
