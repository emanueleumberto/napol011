package com.example.GestionePizzeriaJPA.services;

import com.example.GestionePizzeriaJPA.model.Drink;
import com.example.GestionePizzeriaJPA.model.Menu;
import com.example.GestionePizzeriaJPA.model.Pizza;
import com.example.GestionePizzeriaJPA.repositories.MenuDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;
    @Autowired MenuDAORepository db;

    public Menu creaMenu(String nomeMenu) {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome(nomeMenu);
        return menu;
    }

    public void stampaMenu(Menu menu) {
        System.out.println("************* Menu Pizzeria " + menu.getNome() + " **************");
        System.out.println("----- Pizze -----");
        menu.getListaProdotti().forEach(p -> {
            if(p instanceof Pizza) {
                Pizza pizza = (Pizza) p;
                System.out.println(pizza.getNome() + " " + pizza.getIngredienti().toString() + " €" + pizza.getPrezzo());
            }
        });
        System.out.println("----- Drink -----");
        menu.getListaProdotti().forEach(p -> {
            if(p instanceof Drink) {
                Drink drink = (Drink) p;
                System.out.println(drink.getNome() + " " + drink.getGradi() + "° €" + drink.getPrezzo() );
            }
        });
    }

    public void salvaMenu(Menu menu) {
        db.save(menu);
        System.out.println("Menu " + menu.getNome() + " salvato nel DB!");
    }

    public Menu leggiMenu(long id) {
        return db.findById(id).get();
    }
}
