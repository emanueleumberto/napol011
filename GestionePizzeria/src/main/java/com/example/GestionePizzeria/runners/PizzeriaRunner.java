package com.example.GestionePizzeria.runners;

import com.example.GestionePizzeria.services.MenuService;
import com.example.GestionePizzeria.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class PizzeriaRunner implements CommandLineRunner {

    @Autowired OrdineService ordineService;
    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        ordineService.creaOrdine(
                ordineService.creaClienteFake(),
                List.of(
                        menuService.creaPizzaMargherita(),
                        menuService.creaDrinkBirra(),
                        menuService.creaPizzaBoscaiola(),
                        menuService.creaDrinkCocaCola()
                ));
        ordineService.creaOrdine(
                ordineService.creaClienteCustom("Mario Rossi", "+39 123456789"),
                List.of(
                        menuService.creaPizzaDiavola(),
                        menuService.creaDrink("Chinotto", 3, 0),
                        menuService.creaPizzaMargherita(),
                        menuService.creaDrinkCocaCola(),
                        menuService.creaPizzaMargherita(),
                        menuService.creaDrinkAcqua()
                )
        );

        ordineService.stampaOrdini();
    }
}
