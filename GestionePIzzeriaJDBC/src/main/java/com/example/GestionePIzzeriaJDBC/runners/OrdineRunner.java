package com.example.GestionePIzzeriaJDBC.runners;

import com.example.GestionePIzzeriaJDBC.models.Cliente;
import com.example.GestionePIzzeriaJDBC.models.Ordine;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import com.example.GestionePIzzeriaJDBC.services.MenuService;
import com.example.GestionePIzzeriaJDBC.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class OrdineRunner implements CommandLineRunner {

    @Autowired OrdineService ordineService;
    @Autowired MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ordine runner...");

        //Cliente cliente = ordineService.creaCliente("Mario Rossi", "+39 123.456.789");
        //ordineService.salvaCliente(cliente);
        //Cliente fake = ordineService.creaClienteFake();
        //ordineService.salvaCliente(fake);

        //Cliente mario = ordineService.leggiCliente(1);
        //System.out.println(mario);

        //mario.setTelefono("(39) 123456789");
        //ordineService.modificaCliente(mario);

        //ordineService.eliminaCLiente(mario);

        //ordineService.leggiTuttiCliente().forEach(System.out::println);

        //Prodotto pizza = menuService.leggiProdotto(3);
        //Prodotto drink = menuService.leggiProdotto(2);
        //Cliente cliente = ordineService.leggiCliente(2);

        //Ordine ordine = ordineService.creaOrdine(cliente, List.of(pizza, drink));
        //ordineService.salvaOrdine(ordine);

        Ordine o = ordineService.leggiOrdine(1);
        System.out.println(o);

    }
}
