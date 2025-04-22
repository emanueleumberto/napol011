package com.example.GestionePizzeria.services;

import com.example.GestionePizzeria.classes.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    private static int numOrdine = 1;
    private List<Ordine> listaOrdini = new ArrayList<Ordine>();
    @Autowired @Qualifier("clienteCustom") ObjectProvider<Cliente> clienteCustomObjectProvider;
    @Autowired @Qualifier("clienteFake") ObjectProvider<Cliente> clienteFakeObjectProvider;
    @Autowired @Qualifier("ordine") ObjectProvider<Ordine> ordineObjectProvider;

    public Cliente creaClienteCustom(String nome, String telefono) {
        Cliente cliente = clienteCustomObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public Cliente creaClienteFake() {
        return clienteFakeObjectProvider.getObject();
    }

    public void creaOrdine(Cliente cliente, List<Prodotto> listaProdottiOrdinati) {
        Ordine ordine = ordineObjectProvider.getObject();
        ordine.setNumeroOrdine(numOrdine++);
        ordine.setCliente(cliente);
        ordine.setListaProdottiOrdinati(listaProdottiOrdinati);
        ordine.setDataOrdine(LocalDate.now());
        listaOrdini.add(ordine);
    }

    public void stampaOrdini() {
        listaOrdini.forEach(o -> {
            System.out.println("Ordine n." + o.getNumeroOrdine());
            System.out.println("Data: " + o.getDataOrdine());

            System.out.println("Lista pizze ordinate:");
            o.getListaProdottiOrdinati().forEach(p -> {
                if(p instanceof Pizza) {
                    System.out.println("    - " + p.getNome() + " - " + p.getPrezzo());
                }
            });

            System.out.println("Lista drink ordinati:");
            o.getListaProdottiOrdinati().forEach(d -> {
                if(d instanceof Drink) {
                    System.out.println("    - " + d.getNome() + " - " + d.getPrezzo());
                }
            });

            System.out.println("Totale ordine: " + o.getListaProdottiOrdinati()
                                                    .stream()
                                                    .mapToDouble(Prodotto::getPrezzo)
                                                    .sum());
        });
    }

}
