package com.example.GestionePizzeria.configurations;

import com.example.GestionePizzeria.classes.*;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Locale;

@Configuration
public class PizzeriaConfig {

    // Pizze
    @Bean("pizzaMargherita")
    @Scope("singleton")
    public Pizza creaPizzaMargherita() {
        return new Pizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella", "Basilico"));
    }

    @Bean("pizzaBoscaiola")
    @Scope("singleton")
    public Pizza creaPizzaBoscaiola() {
        return new Pizza("Pizza Boscaiola", 8.00, List.of("Mozzarella", "Funghi", "Salsiccia"));
    }

    @Bean("pizzaDiavola")
    @Scope("singleton")
    public Pizza creaPizzaDiavola() {
        return new Pizza("Pizza Diavola", 7.00, List.of("Pomodoro", "Mozzarella", "Salame Piccante"));
    }

    @Bean("pizzaCustom")
    @Scope("prototype")
    public Pizza creaPizzaCustom() {
        return new Pizza();
    }

    // Drink
    @Bean("drinkAcqua")
    @Scope("singleton")
    public Drink creaDrinkAcqua() {
        return new Drink("Acqua", 2.00, 0);
    }
    @Bean("drinkCocaCola")
    @Scope("singleton")
    public Drink creaDrinkCocaCola() {
        return new Drink("Coca Cola", 4.00, 0);
    }
    @Bean("drinkBirra")
    @Scope("singleton")
    public Drink creaDrinkBirra() {
        return new Drink("Birra", 5.00, 6);
    }
    @Bean("drinkCustom")
    @Scope("prototype")
    public Drink creaDrinkCustom() {
        return new Drink();
    }

    // Menu
    @Bean("menu")
    @Scope("singleton")
    public Menu creaMenu() {
        return new Menu();
    }

    // Clienti
    @Bean("clienteCustom")
    @Scope("prototype")
    public Cliente creaClienteCustom() {
        return new Cliente();
    }

    @Bean("clienteFake")
    @Scope("prototype")
    public Cliente creaClienteFake() {
        Faker fake = new Faker(new Locale("it-IT"));
        return new Cliente(fake.name().fullName(), fake.phoneNumber().cellPhone());
    }

    // Ordini
    @Bean("ordine")
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }
}
