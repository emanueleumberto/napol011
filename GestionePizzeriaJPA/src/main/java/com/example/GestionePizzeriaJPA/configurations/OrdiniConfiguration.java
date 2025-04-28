package com.example.GestionePizzeriaJPA.configurations;

import com.example.GestionePizzeriaJPA.model.Cliente;
import com.example.GestionePizzeriaJPA.model.Ordine;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class OrdiniConfiguration {

    @Bean("creaCliente")
    @Scope("prototype")
    public Cliente creaCliente() {
        return new Cliente();
    }

    @Bean("creaClienteFake")
    @Scope("prototype")
    public Cliente creaClienteFake() {
        Faker fake = new Faker(new Locale("it-IT"));
        Cliente cliente = new Cliente();
        cliente.setNome(fake.name().fullName());
        cliente.setTelefono(fake.phoneNumber().cellPhone());
        return cliente;
    }

    @Bean("creaOrdine")
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }

}
