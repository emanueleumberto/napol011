package com.example.GestionePizzeriaJPA.runners;

import com.example.GestionePizzeriaJPA.model.Cliente;
import com.example.GestionePizzeriaJPA.model.Ordine;
import com.example.GestionePizzeriaJPA.model.Prodotto;
import com.example.GestionePizzeriaJPA.services.ClientiService;
import com.example.GestionePizzeriaJPA.services.OrdiniService;
import com.example.GestionePizzeriaJPA.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdineRunner implements CommandLineRunner {

    @Autowired ClientiService clientiService;
    @Autowired OrdiniService ordiniService;
    @Autowired ProdottiService prodottiService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("OrdineRunner...");

        // Clienti

        //Cliente marioRossi = clientiService.creaCliente("Mario Rossi", "393 123456789");
        //Cliente clienteFake = clientiService.creaClienteFake();

        //clientiService.salvaCliente(marioRossi);
        //clientiService.salvaCliente(clienteFake);

        //System.out.println(marioRossi);
        //System.out.println(clienteFake);

        // Ordini

//        Cliente mario = clientiService.leggiCliente(1);
//        Prodotto margherita = prodottiService.leggiProdotto(5);
//        Prodotto cocaCola = prodottiService.leggiProdotto(1);
//        Prodotto boscaiola = prodottiService.leggiProdotto(7);
//        Prodotto birra = prodottiService.leggiProdotto(2);
//
//        Ordine ordine = ordiniService.creaOrdine(mario, List.of(margherita, boscaiola, cocaCola, birra));
//        ordiniService.salvaOrdine(ordine);

        Ordine ordine = ordiniService.leggiOrdine(1);
        ordiniService.stampaOrdine(ordine);

    }
}
