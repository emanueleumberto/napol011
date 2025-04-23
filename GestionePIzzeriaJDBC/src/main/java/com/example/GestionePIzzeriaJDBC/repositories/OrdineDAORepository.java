package com.example.GestionePIzzeriaJDBC.repositories;

import com.example.GestionePIzzeriaJDBC.models.Ordine;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineDAORepository {

    // CRUD Ordini
    public void salvaOrdine(Ordine ordine);
    public Ordine leggiOrdine(long numeroOrdine);
    public void modificaOrdine(Ordine ordine);
    public void eliminaOrdine(Ordine ordine);

    public List<Ordine> leggiTuttiOrdini();
    public List<Prodotto> leggiProdottiOrdine(long numeroOrdine);

}
