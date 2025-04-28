package com.example.GestionePizzeriaJPA.services;

import com.example.GestionePizzeriaJPA.model.*;
import com.example.GestionePizzeriaJPA.repositories.OrdineDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdiniService {

    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> ordineObjectProvider;
    @Autowired OrdineDAORepository db;

    public Ordine creaOrdine(Cliente cliente, List<Prodotto> listaProdotti) {
        Ordine ordine = ordineObjectProvider.getObject();
        ordine.setCliente(cliente);
        ordine.setListaProdottiOrdinati(listaProdotti);
        ordine.setDataOrdine(LocalDate.now());
        ordine.setTotale(listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).sum());
        return ordine;
    }

    public void salvaOrdine(Ordine ordine) {
        db.save(ordine);
        System.out.println("Ordine " + ordine.getNumeroOrdine() + " salvato nel DB!");
    }

    public Ordine leggiOrdine(long numeroOrdine) {
        return db.findById(numeroOrdine).get();
    }

    public void stampaOrdine(Ordine ordine) {
        System.out.println("************* Ordine numero " + ordine.getNumeroOrdine() + " **************");
        System.out.println("Data: " + ordine.getDataOrdine());
        System.out.println("Cliente: " + ordine.getCliente().getNome() + "("+ordine.getCliente().getTelefono()+")");
        System.out.println("----- Pizze -----");
        ordine.getListaProdottiOrdinati().forEach(p -> {
            if(p instanceof Pizza) {
                Pizza pizza = (Pizza) p;
                System.out.println(pizza.getNome() + " " + pizza.getIngredienti().toString() + " €" + pizza.getPrezzo());
            }
        });
        System.out.println("----- Drink -----");
        ordine.getListaProdottiOrdinati().forEach(p -> {
            if(p instanceof Drink) {
                Drink drink = (Drink) p;
                System.out.println(drink.getNome() + " " + drink.getGradi() + "° €" + drink.getPrezzo() );
            }
        });

        System.out.println("Numero prodotti ordinati: " + ordine.getListaProdottiOrdinati().size());
        System.out.println("Totale: " + ordine.getTotale());
    }

}
