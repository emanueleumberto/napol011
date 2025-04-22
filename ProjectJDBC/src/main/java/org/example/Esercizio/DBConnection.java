package org.example.Esercizio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static DBConnection db;
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "napol011_gestione_ordini";
    private Statement st;
    private Connection conn;

    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        st = conn.createStatement();
        createDatabase();
        createTableClienti();
        createTableProdotti();
        createTableOrdini();
        createTableDettagliOrdine();
        st.close();
        conn.close();
    }

    public static DBConnection getInstance() throws SQLException {
        if(db == null) {
            db = new DBConnection();
        }
        return db;
    }

    public Connection getConn() {
        return conn;
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        conn = DriverManager.getConnection(url+dbName, user, pass);
        st = conn.createStatement();
    }

    private void createTableClienti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS clienti (" +
                "id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(100) NOT NULL," +
                "cognome VARCHAR(100) NOT NULL," +
                "email VARCHAR(150) NOT NULL UNIQUE," +
                "telefono VARCHAR(20) NULL" +
                ")";
        st.executeUpdate(sql);
    }

    private void createTableProdotti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS prodotti (" +
                "id_prodotto INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(100) NOT NULL," +
                "descrizione TEXT NULL," +
                "prezzo DECIMAL(10,2) NOT NULL," +
                "quantita_disponibile INT NOT NULL" +
                ")";
        st.executeUpdate(sql);
    }

    private void createTableOrdini() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ordini (" +
                "id_ordine INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "id_cliente INT NOT NULL," +
                "data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "CONSTRAINT ordini_clienti_fk FOREIGN KEY(id_cliente) " +
                "REFERENCES clienti(id_cliente) " +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";
        st.executeUpdate(sql);
    }

    private void createTableDettagliOrdine() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS dettagli_ordine (" +
                "id_dettagli_ordini INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "id_ordine INT NOT NULL," +
                "id_prodotto INT NOT NULL," +
                "quantita INT NOT NULL," +
                "prezzo_unitario DECIMAL(10,2) NOT NULL," +
                "CONSTRAINT dettagli_ordini_fk FOREIGN KEY(id_ordine) " +
                "REFERENCES ordini(id_ordine) ON UPDATE CASCADE ON DELETE CASCADE," +
                "CONSTRAINT dettagli_ordini_prodotti_fk FOREIGN KEY(id_prodotto) " +
                "REFERENCES prodotti(id_prodotto) ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";
        st.executeUpdate(sql);
    }

}
