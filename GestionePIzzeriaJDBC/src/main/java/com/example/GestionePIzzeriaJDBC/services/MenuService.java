package com.example.GestionePIzzeriaJDBC.services;

import com.example.GestionePIzzeriaJDBC.models.Drink;
import com.example.GestionePIzzeriaJDBC.models.Menu;
import com.example.GestionePIzzeriaJDBC.models.Pizza;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import com.example.GestionePIzzeriaJDBC.repositories.MenuDAO;
import com.example.GestionePIzzeriaJDBC.repositories.ProdottoDAO;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired MenuDAO menuDAO;
    @Autowired ProdottoDAO prodottoDAO;
    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> pizzaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> drinkObjectProvider;
    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> menuObjectProvider;

    public Pizza creaPizza(String nome, List<String> ingredienti, double prezzo, Menu menu) {
        Pizza pizza = pizzaObjectProvider.getObject();
        pizza.setNome(nome);
        pizza.setIngredienti(ingredienti);
        pizza.setPrezzo(prezzo);
        pizza.setMenu(menu);
        return pizza;
    }

    public Drink creaDrink(String nome, int gradi, double prezzo, Menu menu) {
        Drink drink = drinkObjectProvider.getObject();
        drink.setNome(nome);
        drink.setGradi(gradi);
        drink.setPrezzo(prezzo);
        drink.setMenu(menu);
        return drink;
    }

    public Menu creaMenu(String nome) {
        Menu menu = menuObjectProvider.getObject();
        menu.setNome(nome);
        return menu;
    }

    // DB method JDBC
    // CRUD Menu
    public void salvaMenu(Menu menu) { menuDAO.salvaMenu(menu); }
    public Menu leggiMenu(long id) {
        Menu menu = menuDAO.leggiMenu(id);
        List<Prodotto> listaProdotti = leggiTuttiProdotti(id);
        List<Pizza> listaPizze =  listaProdotti.stream()
                                    .filter(p -> p instanceof Pizza)
                                    .map(p -> (Pizza) p)
                                    .toList();
        List<Drink> listaDrink = listaProdotti.stream()
                                    .filter(p -> p instanceof Drink)
                                    .map(p -> (Drink) p)
                                    .toList();
        menu.setListaPizze(listaPizze);
        menu.setListaDrink(listaDrink);
        return menu;
    }
    public void modificaMenu(Menu menu) { menuDAO.modificaMenu(menu); }
    public void eliminaMenu(Menu menu) { menuDAO.eliminaMenu(menu); }

    // CRUD Prodotti
    public void salvaProdotto(Prodotto prodotto) { prodottoDAO.salvaProdotto(prodotto); }
    public Prodotto leggiProdotto(long id) { return prodottoDAO.leggiProdotto(id); }
    public void modificaProdotto(Prodotto prodotto) { prodottoDAO.modificaProdotto(prodotto); }
    public void eliminaProdotto(Prodotto prodotto) { prodottoDAO.eliminaProdotto(prodotto); }
    public List<Prodotto> leggiTuttiProdotti(long id_menu) { return prodottoDAO.leggiTuttiProdotti(id_menu); }


}
