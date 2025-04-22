package com.example.GestionePizzeria.services;

import com.example.GestionePizzeria.classes.Drink;
import com.example.GestionePizzeria.classes.Menu;
import com.example.GestionePizzeria.classes.Pizza;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired @Qualifier("pizzaMargherita") ObjectProvider<Pizza> pizzaMargheritaObjectProvider;
    @Autowired @Qualifier("pizzaBoscaiola") ObjectProvider<Pizza> pizzaBoscaiolaObjectProvider;
    @Autowired @Qualifier("pizzaDiavola") ObjectProvider<Pizza> pizzaDiavolaObjectProvider;
    @Autowired @Qualifier("pizzaCustom") ObjectProvider<Pizza> pizzaCustomObjectProvider;
    @Autowired @Qualifier("drinkAcqua") ObjectProvider<Drink> drinkAcquaObjectProvider;
    @Autowired @Qualifier("drinkCocaCola") ObjectProvider<Drink> drinkCocaColaObjectProvider;
    @Autowired @Qualifier("drinkBirra") ObjectProvider<Drink> drinkBirraObjectProvider;
    @Autowired @Qualifier("drinkCustom") ObjectProvider<Drink> drinkCustomObjectProvider;
    @Autowired @Qualifier("menu") ObjectProvider<Menu> menuObjectProvider;

    public Pizza creaPizzaMargherita() { return pizzaMargheritaObjectProvider.getObject(); }
    public Pizza creaPizzaBoscaiola() { return pizzaBoscaiolaObjectProvider.getObject(); }
    public Pizza creaPizzaDiavola() { return pizzaDiavolaObjectProvider.getObject(); }
    public Drink creaDrinkAcqua() { return drinkAcquaObjectProvider.getObject(); }
    public Drink creaDrinkCocaCola() { return drinkCocaColaObjectProvider.getObject(); }
    public Drink creaDrinkBirra() { return drinkBirraObjectProvider.getObject(); }

    public Pizza creaPizza(String nome, double prezzo, List<String> ingredienti) {
        Pizza pizza = pizzaCustomObjectProvider.getObject();
        pizza.setNome(nome);
        pizza.setPrezzo(prezzo);
        pizza.setIngredienti(ingredienti);
        return pizza;
    }

    public Drink creaDrink(String nome, double prezzo, int gradi) {
        Drink drink = drinkCustomObjectProvider.getObject();
        drink.setNome(nome);
        drink.setPrezzo(prezzo);
        drink.setGradi(gradi);
        return drink;
    }

    public Menu creaMenu(String nome) {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome(nome);
        menu.getListaPizze().add(creaPizzaMargherita());
        menu.getListaPizze().add(creaPizzaBoscaiola());
        menu.getListaPizze().add(creaPizzaDiavola());
        menu.getListaPizze().add(creaPizza("Pizza Olive", 7.5, List.of("Pomodoro", "Olive", "Capperi")));
        menu.getListaDrink().add(creaDrinkAcqua());
        menu.getListaDrink().add(creaDrinkCocaCola());
        menu.getListaDrink().add(creaDrinkBirra());
        menu.getListaDrink().add(creaDrink("Spritz", 8.00, 9));
        return menu;
    }

}
