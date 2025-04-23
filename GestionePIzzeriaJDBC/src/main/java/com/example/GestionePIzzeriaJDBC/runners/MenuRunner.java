package com.example.GestionePIzzeriaJDBC.runners;

import com.example.GestionePIzzeriaJDBC.models.Drink;
import com.example.GestionePIzzeriaJDBC.models.Menu;
import com.example.GestionePIzzeriaJDBC.models.Pizza;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import com.example.GestionePIzzeriaJDBC.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Menu runner...");

        // Save Menu
        //Menu menu = menuService.creaMenu("Da Peppe");
        //menuService.salvaMenu(menu);

        // Find Menu
        Menu menu = menuService.leggiMenu(2);
        menu.stampaMenu();

        // Update Menu
        //menu.setNome("Da Peppino");
        //menuService.modificaMenu(menu);

        // Delete Menu
        //menuService.eliminaMenu(menu);

        // Save Prodotto
        //Menu menu = menuService.leggiMenu(2);
        // Save Pizza
        //Pizza margherita = menuService.creaPizza("Pizza Margherita", List.of("Pomodoro", "Mozzarella", "Basilico"), 6.00, menu);
        //menuService.salvaProdotto(margherita);
        //Pizza boscaiola = menuService.creaPizza("Pizza Boscaiola", List.of("Mozzarella", "Funghi", "Salsiccia"), 8.00, menu);
        //menuService.salvaProdotto(boscaiola);
        // Save Drink
        //Drink cocaCola = menuService.creaDrink("Coca Cola", 0, 2.5, menu);
        //menuService.salvaProdotto(cocaCola);
        //Drink acqua = menuService.creaDrink("Acqua", 0, 1.5, menu);
        //menuService.salvaProdotto(acqua);

        // Find Prodotto
        //Prodotto prodotto = menuService.leggiProdotto(1);
        //System.out.println(prodotto);

        // Update Prodotto
        //prodotto.setPrezzo(6.5);
        //menuService.modificaProdotto(prodotto);

        // Delete Prodotto
        //menuService.eliminaProdotto(prodotto);

        //List<Prodotto> listaProdotti = menuService.leggiTuttiProdotti(2);
        //listaProdotti.forEach(System.out::println);
    }
}
