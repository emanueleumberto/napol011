package com.example.GestionePIzzeriaJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionePIzzeriaJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePIzzeriaJdbcApplication.class, args);
	}

	/*
		CREATE DATABASE IF NOT EXISTS `napol011_gestione_pizzeria_jdbc`;

		USE `napol011_gestione_pizzeria_jdbc`;

		CREATE TABLE IF NOT EXISTS menu (
			id_menu INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			nome_menu VARCHAR(100) NOT NULL
		 );

		 CREATE TABLE IF NOT EXISTS prodotti (
			id_prodotto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			nome_prodotto VARCHAR(100) NOT NULL,
			prezzo DECIMAL(10,2) NOT NULL,
			ingredienti_pizza VARCHAR(255) NULL,
			gradi_drink INT NULL,
			menu_id INT NOT NULL,
			tipo_prodotto VARCHAR(100) NOT NULL,
			CONSTRAINT prodotto_menu_fk
				FOREIGN KEY(menu_id)
				REFERENCES menu(id_menu)
				ON DELETE CASCADE ON UPDATE CASCADE
		 );

		 CREATE TABLE IF NOT EXISTS clienti(
			id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			nome_cliente VARCHAR(100) NOT NULL,
			telefono_cliente VARCHAR(50) NOT NULL UNIQUE
		 );

		 CREATE TABLE IF NOT EXISTS ordini (
			numero_ordine INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			cliente_id INT NOT NULL,
			data_ordine DATE NOT NULL,
			totale DECIMAL(10,2) NOT NULL,
			CONSTRAINT ordine_cliente_fk
				FOREIGN KEY(cliente_id)
				REFERENCES clienti(id_cliente)
				ON DELETE CASCADE ON UPDATE CASCADE
		 );

		 CREATE TABLE IF NOT EXISTS prodotti_ordini(
			numero_ordine INT NOT NULL,
			id_prodotto INT NOT NULL,
			CONSTRAINT ordine_fk
				FOREIGN KEY(numero_ordine)
				REFERENCES ordini(numero_ordine)
				ON DELETE CASCADE ON UPDATE CASCADE,
			CONSTRAINT prodotti_fk
				FOREIGN KEY(id_prodotto)
				REFERENCES prodotti(id_prodotto)
				ON DELETE CASCADE ON UPDATE CASCADE
		 );

 */


}
