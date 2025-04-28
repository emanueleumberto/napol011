package com.example.GestionePizzeriaJPA.runners;

import com.example.GestionePizzeriaJPA.model.*;
import com.example.GestionePizzeriaJPA.services.ClientiService;
import com.example.GestionePizzeriaJPA.services.MenuService;
import com.example.GestionePizzeriaJPA.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;
    @Autowired ProdottiService prodottiService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MenuRunner...");

        // Menu

        //Menu menuProdotti = menuService.creaMenu("Napol011");
        //menuService.salvaMenu(menuProdotti);

        //Menu menuProdotti = menuService.leggiMenu(1);
        //System.out.println(menuProdotti);

        //menuService.stampaMenu(menuProdotti);

        // Prodotti

        //Pizza margherita = prodottiService.creaPizza("Margherita", 6.00, List.of("Pomodoro", "Mozzarella", "Basilico"), menuProdotti);
        //Pizza diavola = prodottiService.creaPizza("Divaola", 7.50, List.of("Pomodoro", "Mozzarella", "Salame Piccante"), menuProdotti);
        //Pizza boscaiola = prodottiService.creaPizza("Boscaiola", 9.00, List.of("Mozzarella", "Funghi", "Salsiccia"), menuProdotti);

        //prodottiService.salvaProdotto(margherita);
        //prodottiService.salvaProdotto(diavola);
        //prodottiService.salvaProdotto(boscaiola);

        //Drink cocaCola = prodottiService.creaDrink("Coca Cola", 2.5, 0, menuProdotti);
        //Drink birra = prodottiService.creaDrink("Birra", 3.5, 6, menuProdotti);
        //Drink acqua = prodottiService.creaDrink("Acqua", 1.5, 0, menuProdotti);

        //prodottiService.salvaProdotto(cocaCola);
        //prodottiService.salvaProdotto(birra);
        //prodottiService.salvaProdotto(acqua);

        //Pizza p = (Pizza) prodottiService.leggiProdotto(5);
        //System.out.println(p);

        //Drink d = (Drink) prodottiService.leggiProdotto(1);
        //System.out.println(d);



    }
}
