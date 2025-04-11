package org.example.Esercizio.dao;

import org.example.Esercizio.DBConnection;
import org.example.Esercizio.entities.Cliente;
import org.example.Esercizio.entities.DettaglioOrdine;
import org.example.Esercizio.entities.Ordine;
import org.example.Esercizio.entities.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class OrdineDAO {

    public void creaOrdine(Ordine o) throws SQLException {
        String sql = "INSERT INTO ordini (id_cliente) VALUES (?)";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, o.getCliente().getIdCliente());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) {
            int order_insert_id = rs.getInt(1);
            sql = "INSERT INTO dettagli_ordine (id_ordine, id_prodotto, quantita, prezzo_unitario) VALUES (?, ?, ?, ?)";
            ps = DBConnection.getInstance().getConn().prepareStatement(sql);
            ps.setInt(1, order_insert_id);
            ps.setInt(2, o.getDettaglioOrdine().getProdotto().getIdProdotto());
            ps.setInt(3, o.getDettaglioOrdine().getQuantita());
            ps.setDouble(4, o.getDettaglioOrdine().getPrezzoUnitario());
            ps.executeUpdate();
        }
        System.out.println("Ordine inserito nel database!");
    }

    public Ordine leggiOrdine( int id ) throws SQLException {
        String sql = "SELECT o.id_ordine AS idOrdine, c.id_cliente, c.nome AS nomeCliente, c.cognome, c.email, c.telefono, " +
                     "o.data_ordine, d.id_dettagli_ordini, p.id_prodotto, p.nome AS nomeProdotto, p.descrizione, " +
                     "p.prezzo, p.quantita_disponibile, d.quantita, d.prezzo_unitario " +
                     "FROM napol011_gestione_ordini.ordini AS o " +
                     "INNER JOIN napol011_gestione_ordini.dettagli_ordine AS d " +
                     "ON o.id_ordine = d.id_ordine " +
                     "INNER JOIN napol011_gestione_ordini.clienti AS c " +
                     "ON o.id_cliente = c.id_cliente " +
                     "INNER JOIN napol011_gestione_ordini.prodotti AS p " +
                     "ON d.id_prodotto = p.id_prodotto " +
                     "WHERE o.id_ordine = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int idOrdine = rs.getInt("idOrdine");
            int idCliente = rs.getInt("id_cliente");
            int idProdotto = rs.getInt("id_prodotto");
            int idDettaglioOrdine = rs.getInt("id_dettagli_ordini");
            String nomeCliente = rs.getString("nomeCliente");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String nomeProdotto = rs.getString("nomeProdotto");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantitaDisponibile = rs.getInt("quantita_disponibile");
            LocalDate data_ordine = rs.getDate("data_ordine").toLocalDate();
            int quantita = rs.getInt("quantita");
            double prezzoUnitario = rs.getDouble("prezzo_unitario");

            Cliente c = new Cliente(idCliente, nomeCliente, cognome, email, telefono);
            Prodotto p = new Prodotto(idProdotto, nomeProdotto, descrizione, prezzo, quantitaDisponibile);
            DettaglioOrdine d = new DettaglioOrdine(idDettaglioOrdine, p, quantita, prezzoUnitario);
            Ordine o = new Ordine(idOrdine, c, data_ordine, d);
            return o;
        }
        return null;
    }

    public void modificaOrdine(Ordine o) {}

    public void eliminaOrdine(Ordine o) {}

    public List<Ordine> leggiTuttiOrdini() { return null; }
}
