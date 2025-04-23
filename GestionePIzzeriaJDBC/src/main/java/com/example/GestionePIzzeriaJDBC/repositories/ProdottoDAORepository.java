package com.example.GestionePIzzeriaJDBC.repositories;

import com.example.GestionePIzzeriaJDBC.models.Menu;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoDAORepository {

    // CRUD Prodotti
    public void salvaProdotto(Prodotto prodotto);
    public Prodotto leggiProdotto(long id);
    public void modificaProdotto(Prodotto prodotto);
    public void eliminaProdotto(Prodotto prodotto);

    public List<Prodotto> leggiTuttiProdotti(long menu_id);

}
