package org.example.Esercizio.dao;

import org.example.Esercizio.DBConnection;
import org.example.Esercizio.entities.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // CRUD Cliente
    public void salvaCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO clienti (nome, cognome, email, telefono) " +
                     "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql); // conn.preparedStatement(sql)
        ps.setString(1, c.getNome());
        ps.setString(2, c.getCognome());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getTelefono());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " salvato nel DB!");
    }

    public Cliente leggiCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clienti WHERE id_cliente = ?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            return new Cliente(id_cliente, nome, cognome, email, telefono);
        }
        return null;
    }

    public void modificaCliente(Cliente c) throws SQLException {
        String sql = "UPDATE clienti SET nome=?, cognome=?, email=?, telefono=? WHERE id_cliente=?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getCognome());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getTelefono());
        ps.setInt(5, c.getIdCliente());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " modificato nel DB!");
    }

    public void eliminaCliente(Cliente c) throws SQLException {
        String sql = "DELETE FROM clienti WHERE id_cliente=?";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, c.getIdCliente());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " eliminato dal DB!");
    }

    public List<Cliente> leggiTuttiClienti() throws SQLException {
        String sql = "SELECT * FROM clienti";
        PreparedStatement ps = DBConnection.getInstance().getConn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Cliente> listaClienti = new ArrayList<Cliente>();
        while(rs.next()) {
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            listaClienti.add(new Cliente(id_cliente, nome, cognome, email, telefono));
        }
        return listaClienti;
    }

}
