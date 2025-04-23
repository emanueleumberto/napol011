package com.example.GestionePIzzeriaJDBC.repositories;

import com.example.GestionePIzzeriaJDBC.models.Ordine;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class OrdineDAO implements OrdineDAORepository{

    @Autowired JdbcTemplate jdbc;

    @Override
    public void salvaOrdine(Ordine ordine) {
        String sql = "INSERT INTO ordini (cliente_id, data_ordine, totale) VALUES (?, ?, ?)";
        //jdbc.update(sql, ordine.getCliente().getId(), ordine.getDataOrdine(), ordine.getTotale());

        GeneratedKeyHolder holder = new GeneratedKeyHolder(); // Oggetto che serve per leggere l'ultimo ID creato

        // Esegue il metodo update di JdbcTemplate passandogli un PreparedStatement custom
        jdbc.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Imposto il paramentro Statement.RETURN_GENERATED_KEYS nel preparedStatement
                ps.setLong(1, ordine.getCliente().getId()); // Sostituisco ai segnaposto(?) il valore che voglio inserire nel DB
                ps.setString(2, ordine.getDataOrdine().toString()); // Sostituisco ai segnaposto(?) il valore che voglio inserire nel DB
                ps.setDouble(3, ordine.getTotale()); // Sostituisco ai segnaposto(?) il valore che voglio inserire nel DB
                return ps;
            }
        }, holder); // Oggetto holder serve per recuperare l'ultimo ID creato (riga 24 [GeneratedKeyHolder])

        long numerOrdine = holder.getKey().longValue(); // Leggo l'id generato dalla query precedente

        String sql2 = "INSERT INTO prodotti_ordini (numero_ordine, id_prodotto) VALUES (?, ?)";
        // Itero tutti i prodotti presenti nell'ordine e li salvo nel DB
        ordine.getListaProdottiOrdinati().forEach(p -> {
            jdbc.update(sql2, numerOrdine, p.getId());
        });

        System.out.println("Ordine n." + numerOrdine + " salvato nel DB!");
    }

    @Override
    public Ordine leggiOrdine(long numeroOrdine) {
        String sql = "SELECT * FROM ordini AS o INNER JOIN clienti AS c " +
                     "ON o.cliente_id = c.id_cliente WHERE o.numero_ordine = ?";
        return jdbc.queryForObject(sql, new OrdineRowMapper(),numeroOrdine);
    }

    @Override
    public List<Prodotto> leggiProdottiOrdine(long numeroOrdine) {
        String sql = "SELECT * FROM prodotti_ordini AS po " +
                     "INNER JOIN prodotti AS p ON po.id_prodotto = p.id_prodotto " +
                     "INNER JOIN menu AS m ON p.menu_id = m.id_menu " +
                     "WHERE po.numero_ordine = ?";
        return jdbc.query(sql, new ProdottoRowMapper(), numeroOrdine);
    }

    @Override
    public void modificaOrdine(Ordine ordine) {

    }

    @Override
    public void eliminaOrdine(Ordine ordine) {

    }

    @Override
    public List<Ordine> leggiTuttiOrdini() {
        return List.of();
    }


}
