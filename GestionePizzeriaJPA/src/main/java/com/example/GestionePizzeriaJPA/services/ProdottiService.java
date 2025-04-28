package com.example.GestionePizzeriaJPA.services;

import com.example.GestionePizzeriaJPA.model.Drink;
import com.example.GestionePizzeriaJPA.model.Menu;
import com.example.GestionePizzeriaJPA.model.Pizza;
import com.example.GestionePizzeriaJPA.model.Prodotto;
import com.example.GestionePizzeriaJPA.repositories.ProdottiRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottiService {

    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> pizzaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> drinkObjectProvider;
    @Autowired ProdottiRepository db;

    public Pizza creaPizza(String nome, Double prezzo, List<String> ingredienti, Menu menu ) {
        Pizza pizza = pizzaObjectProvider.getObject();
        pizza.setNome(nome);
        pizza.setPrezzo(prezzo);
        pizza.setIngredienti(ingredienti);
        pizza.setMenu(menu);
        return pizza;
    }

    public Drink creaDrink(String nome, Double prezzo, Integer gradi, Menu menu ) {
        Drink drink = drinkObjectProvider.getObject();
        drink.setNome(nome);
        drink.setPrezzo(prezzo);
        drink.setGradi(gradi);
        drink.setMenu(menu);
        return drink;
    }

    public void salvaProdotto(Prodotto prodotto) {
        db.save(prodotto);
        System.out.println("Prodotto " + prodotto.getNome() + " salvato nel DB!");
    }

    public Prodotto leggiProdotto(long id) {
        return db.findById(id).get();
    }

}
