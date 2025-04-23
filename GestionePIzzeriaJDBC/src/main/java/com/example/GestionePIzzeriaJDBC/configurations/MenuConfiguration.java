package com.example.GestionePIzzeriaJDBC.configurations;

import com.example.GestionePIzzeriaJDBC.models.Drink;
import com.example.GestionePIzzeriaJDBC.models.Menu;
import com.example.GestionePIzzeriaJDBC.models.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MenuConfiguration {

    @Bean("creaPizza")
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    @Bean("creaDrink")
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }

    @Bean("creaMenu")
    @Scope("prototype")
    public Menu creaMenu() {
        return new Menu();
    }

}
