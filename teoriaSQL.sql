-- Commenti a singola riga
/*
	Commenti
    multi riga
*/

/*
	SQL ha diverse categorie di istruzioni
    DDL -> Data Definition Language
		- Definisce tutte le istruzioni SQL 
          per la creazione e la gestione di un DB
	DML -> Data Manipulation Language
		- Definisce tutte le istruzioni SQL
          per la creazione e gestione delle tabelle
          contenute in un DB
	DQL -> Data Query Language
		- Definisce tutte le istruzioni SQL
          per la lettura dei dati contenuti in un DB
	DCL -> Data Control Language
		- Definisce tutte le istruzioni SQL
          per la gestione e i permessi di un DB
*/		
        
-- DDL -> Data Definition Language
-- Definisce tutte le istruzioni SQL per la creazione e la gestione di un DB

-- CREATE | USE | ALTER (Deprecata) | DROP | SHOW

-- DB --> CREATE | USE | DROP | SHOW
-- CREATE DATABASE [IF NOT EXISTS] db_name;
-- SHOW DATABASES;
-- USE db_name;
-- DROP DATABASE [IF EXISTS] db_name;
-- RENAME DATABASE old_db_name TO new_db_name; (Deprecata)
-- ALTER DATABASE old_db_name MODIFY NAME = new_db_name; (Deprecata)

CREATE DATABASE IF NOT EXISTS napol011_test;
SHOW DATABASES;
USE napol011_test;
DROP DATABASE IF EXISTS napol011_test;

-- TABLE --> CREATE | ALTER | DROP
/* CREATE TABLE [IF NOT EXISTS] db_name.table_name (
	column_name1 datatype column_constraints,
    column_name2 datatype column_constraints,
    ...
    column_nameN datatype column_constraints,
    [constraint_name] table_constraints
	);
*/
-- DROP TABLE IF EXISTS db_name.table_name [CASCADE | RESTRICT];
-- ALTER TABLE db_name.table_name ADD COLUMN column_name datatype column_constraints;
-- ALTER TABLE db_name.table_name DROP COLUMN column_name [CASCADE | RESTRICT];
-- ALTER TABLE db_name.table_name RENAME COLUMN old_column_name TO new_column_name;
-- ALTER TABLE db_name.table_name MODIFY column_name datatype;
-- ALTER TABLE db_name.table_name ADD CONSTRAINT [constraint_name] table_constraints;
-- ALTER TABLE db_name.table_name DROP CONSTRAINT table_constraints;

-- RELAZIONI TABELLE --> OneToOne | OneToMany-ManyToOne | ManyToMany

DROP TABLE IF EXISTS napol011_test.utenti;
CREATE TABLE IF NOT EXISTS napol011_test.utenti (
	id_utente INT NOT NULL AUTO_INCREMENT, -- [PRIMARY KEY]
    nome VARCHAR(25) NOT NULL,
    cognome VARCHAR(25) NOT NULL,
    citta VARCHAR(25) NULL,
    eta INT UNSIGNED NULL,
    email VARCHAR(50) NOT NULL, -- [UNIQUE]
    CONSTRAINT pk_utente PRIMARY KEY(id_utente),
    CONSTRAINT uk_email UNIQUE(email)
);

ALTER TABLE napol011_test.utenti ADD COLUMN codice_fiscale CHAR(16) NOT NULL UNIQUE;
ALTER TABLE napol011_test.utenti MODIFY citta VARCHAR(50);
-- ALTER TABLE napol011_test.utenti RENAME COLUMN id_utente TO id_utente;
-- ALTER TABLE napol011_test.utenti DROP COLUMN email;

-- Relazione OneToOne
CREATE TABLE IF NOT EXISTS napol011_test.passaporti (
	id_passaporto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero_passaporto INT UNSIGNED NOT NULL UNIQUE,
    data_rilascio DATE NOT NULL,
    id_utente INT NOT NULL UNIQUE,
    CONSTRAINT fk_passaporti_utenti 
		FOREIGN KEY(id_utente) 
        REFERENCES napol011_test.utenti(id_utente)
);

CREATE TABLE IF NOT EXISTS napol011_test.passaporti (
	id_passaporto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero_passaporto INT UNSIGNED NOT NULL UNIQUE,
    data_rilascio DATE NOT NULL,
    CONSTRAINT fk_passaporti_utenti 
		FOREIGN KEY(id_passaporto) 
        REFERENCES napol011_test.utenti(id_utente)
);

-- Relazione OneToMany|ManyToOne
CREATE TABLE IF NOT EXISTS napol011_test.automobili (
	id_automobile INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(25) NOT NULL,
    modello VARCHAR(25) NOT NULL,
    targa CHAR(7) NOT NULL UNIQUE,
    id_utente INT NULL,
    CONSTRAINT fk_automobili_utenti 
		FOREIGN KEY(id_utente) 
        REFERENCES napol011_test.utenti(id_utente)
);

-- Relazione ManyToMany
CREATE TABLE IF NOT EXISTS napol011_test.corsi (
	id_corso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    ore INT NULL DEFAULT 250
);

CREATE TABLE IF NOT EXISTS napol011_test.utenti_corsi (
	utente_id INT NOT NULL,
    corso_id INT NOT NULL,
    CONSTRAINT fk_utenti_corsi1
		FOREIGN KEY(utente_id) 
        REFERENCES napol011_test.utenti(id_utente),
	CONSTRAINT fk_utenti_corsi2
		FOREIGN KEY(corso_id) 
        REFERENCES napol011_test.corsi(id_corso)  
);