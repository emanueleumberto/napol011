package com.example.GestionePIzzeriaJDBC.repositories;

import com.example.GestionePIzzeriaJDBC.models.Drink;
import com.example.GestionePIzzeriaJDBC.models.Menu;
import com.example.GestionePIzzeriaJDBC.models.Pizza;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdottoRowMapper implements RowMapper<Prodotto> {

    @Override
    public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getLong("id_menu"));
        menu.setNome(rs.getString("nome_menu"));
        if(rs.getString("tipo_prodotto").equals("Pizza")) {
            Pizza pizza = new Pizza();
            pizza.setId(rs.getLong("id_prodotto"));
            pizza.setNome(rs.getString("nome_prodotto"));
            pizza.setPrezzo(rs.getDouble("prezzo"));
            pizza.setIngredienti(List.of(rs.getString("ingredienti_pizza")));
            pizza.setMenu(menu);
            return pizza;
        } else if(rs.getString("tipo_prodotto").equals("Drink")) {
            Drink drink = new Drink();
            drink.setId(rs.getLong("id_prodotto"));
            drink.setNome(rs.getString("nome_prodotto"));
            drink.setPrezzo(rs.getDouble("prezzo"));
            drink.setGradi(rs.getInt("gradi_drink"));
            drink.setMenu(menu);
            return drink;
        }
        return null;
    }

}
