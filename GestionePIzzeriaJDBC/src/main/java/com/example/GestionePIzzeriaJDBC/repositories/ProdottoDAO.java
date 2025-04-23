package com.example.GestionePIzzeriaJDBC.repositories;

import com.example.GestionePIzzeriaJDBC.models.Drink;
import com.example.GestionePIzzeriaJDBC.models.Pizza;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdottoDAO implements ProdottoDAORepository {

    @Autowired JdbcTemplate jdbc;

    @Override
    public void salvaProdotto(Prodotto prodotto) {
        String sql = "INSERT INTO prodotti (nome_prodotto, prezzo, ingredienti_pizza, " +
                                            "gradi_drink, menu_id, tipo_prodotto) " +
                                            "VALUES (?,?,?,?,?,?)";
        /*String ingredienti = null;
        if(prodotto instanceof Pizza) {
            Pizza pizza = (Pizza) prodotto;
            ingredienti = pizza.getIngredienti().toString();
        }*/

        String ingredienti = (prodotto instanceof Pizza) ?
                ((Pizza) prodotto).getIngredienti().toString() : null;
        Integer gradi = (prodotto instanceof Drink) ?
                ((Drink) prodotto).getGradi() : null;

        jdbc.update(sql,
                prodotto.getNome(),
                prodotto.getPrezzo(),
                ingredienti,
                gradi,
                prodotto.getMenu().getId(),
                prodotto.getClass().getSimpleName());
        System.out.println(prodotto.getClass().getSimpleName() + " " + prodotto.getNome() + " salvato nel DB");
    }

    @Override
    public Prodotto leggiProdotto(long id) {
        String sql = "SELECT * FROM prodotti AS p INNER JOIN menu AS m " +
                     "ON p.menu_id = m.id_menu WHERE id_prodotto = ?";
        return jdbc.queryForObject(sql,new ProdottoRowMapper(), id);
    }

    @Override
    public void modificaProdotto(Prodotto prodotto) {
        String ingredienti = (prodotto instanceof Pizza) ?
                ((Pizza) prodotto).getIngredienti().toString() : null;
        Integer gradi = (prodotto instanceof Drink) ?
                ((Drink) prodotto).getGradi() : null;

        String sql = "UPDATE prodotti SET nome_prodotto = ?, prezzo = ?, " +
                            "ingredienti_pizza = ?, gradi_drink = ?, menu_id = ?, " +
                            "tipo_prodotto = ? WHERE id_prodotto = ?";
        jdbc.update(sql,
                prodotto.getNome(),
                prodotto.getPrezzo(),
                ingredienti,
                gradi,
                prodotto.getMenu().getId(),
                prodotto.getClass().getSimpleName(),
                prodotto.getId());
        System.out.println(prodotto.getClass().getSimpleName() + " " + prodotto.getNome() + " modificato nel DB");
    }

    @Override
    public void eliminaProdotto(Prodotto prodotto) {
        String sql = "DELETE FROM prodotti WHERE id_prodotto = ?";
        jdbc.update(sql, prodotto.getId());
        System.out.println(prodotto.getClass().getSimpleName() + " " + prodotto.getNome() + " eliminato dal DB");
    }

    @Override
    public List<Prodotto> leggiTuttiProdotti(long menu_id) {
        String sql = "SELECT * FROM prodotti AS p INNER JOIN menu AS m " +
                "ON p.menu_id = m.id_menu WHERE menu_id = ?";
        return jdbc.query(sql, new ProdottoRowMapper(), menu_id);
    }
}
