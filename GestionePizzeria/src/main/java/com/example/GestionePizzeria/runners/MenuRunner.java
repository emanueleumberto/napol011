package com.example.GestionePizzeria.runners;

import com.example.GestionePizzeria.classes.Menu;
import com.example.GestionePizzeria.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        Menu menu = menuService.creaMenu("Da peppe");
        menu.stampaMenu();
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
