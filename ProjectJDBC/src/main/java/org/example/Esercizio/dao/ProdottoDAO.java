package org.example.Esercizio.dao;

import org.example.Esercizio.DBConnection;
import org.example.Esercizio.entities.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    // CRUD Prodotto
    public void salvaProdotto(Prodotto p) throws SQLException {
        String sql = "INSERT INTO prodotti (nome, descrizione, prezzo, quantita_disponibile) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql); // conn.preparedStatement(sql)
        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getQuantitaDisponibile());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + "  €" + p.getPrezzo() + " salvato nel DB!");
    }

    public Prodotto leggiProdotto(int id) throws SQLException {
        String sql = "SELECT * FROM prodotti WHERE id_prodotto=?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idProdotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int qt = rs.getInt("quantita_disponibile");
            return new Prodotto(idProdotto, nome, descrizione, prezzo, qt);
        }
        return null;
    }

    public void modificaProdotto(Prodotto p) throws SQLException {
        String sql = "UPDATE prodotti SET nome=?, descrizione=?, prezzo=?, quantita_disponibile=? WHERE id_prodotto=? ";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getQuantitaDisponibile());
        ps.setInt(5, p.getIdProdotto());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + "  €" + p.getPrezzo() + " modificato nel DB!");
    }

    public void eliminaProdotto(Prodotto p) throws SQLException {
        String sql = "DELETE FROM prodotti WHERE id_prodotto=? ";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, p.getIdProdotto());
        ps.executeUpdate();
        System.out.println("Prodotto " + p.getNome() + "  €" + p.getPrezzo() + " eliminato dal DB!");
    }

    public List<Prodotto> leggiTuttiProdotto() throws SQLException {
        String sql = "SELECT * FROM prodotti";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
        while (rs.next()) {
            int id = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int qt = rs.getInt("quantita_disponibile");
            listaProdotti.add(new Prodotto(id, nome, descrizione, prezzo, qt));
        }
        return listaProdotti;
    }

}
