package com.example.IntroSpring.Esercizio.configurations;

import com.example.IntroSpring.Esercizio.classes.Drink;
import com.example.IntroSpring.Esercizio.classes.Menu;
import com.example.IntroSpring.Esercizio.classes.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PizzeriaConfig {

    // Menu
    @Bean
    @Scope("singleton")
    public Menu creaMenu() {
        Menu menu = new Menu("Pizzeria da Peppe");
        menu.getListaPizze().add(creaPizzaMargherita());
        menu.getListaPizze().add(creaPizzaBoscaiola());
        menu.getListaPizze().add(creaPizzaDiavola());
        menu.getListaPizze().add(creaPizzaCustom("Pizza Olive", 7.5, List.of("Pomodoro", "Olive", "Capperi")));
        menu.getListaDrink().add(creaDrinkCocaCola());
        menu.getListaDrink().add(creaDrinkBirra());
        menu.getListaDrink().add(creaDrinkAcqua());
        menu.getListaDrink().add(creaDrinkCustom("Spritz", 10.00, 8));
        return menu;
    }


    // Pizze

    @Bean
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    @Bean
    @Scope("prototype")
    public Pizza creaPizzaCustom(String nome, double prezzo, List<String> ingredienti) {
        return new Pizza(nome, prezzo, ingredienti);
    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaMargherita() {
        return new Pizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella"));
    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaBoscaiola() {
        return new Pizza("Pizza Boscaiola", 8.00, List.of("Mozzarella", "Funghi", "Salsiccia"));
    }

    @Bean
    @Scope("singleton")
    public Pizza creaPizzaDiavola() {
        return new Pizza("Pizza Diavola", 7.00, List.of("Pomodoro", "Mozzarella", "Salame Piccante"));
    }


    // Drink
    @Bean
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }

    @Bean
    @Scope("prototype")
    public Drink creaDrinkCustom(String nome, double prezzo, int gradi) {
        return new Drink(nome, prezzo, gradi);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkCocaCola() {
        return new Drink("Coca Cola", 3.00, 0);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkBirra() {
        return new Drink("Birra", 5.00, 6);
    }

    @Bean
    @Scope("singleton")
    public Drink creaDrinkAcqua() {
        return new Drink("Acqua", 2.00, 0);
    }

}
