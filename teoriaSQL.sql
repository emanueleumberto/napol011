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
-- DROP DATABASE IF EXISTS napol011_test;

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

-- DROP TABLE IF EXISTS napol011_test.utenti;
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


-- DML -> Data Manipulation Language
-- Definisce tutte le istruzioni SQL per l'inserimento e gestione di dati nelle tabelle

-- INSERT | UPDATE | DELETE

-- INSERT INTO db_name.table_name (column_name1, column_name2, ..., column_nameN)
-- 						   VALUES (value1, value2, ..., valueN);

-- UPDATE db_name.table_name 
-- 				SET column_name1=newValue1, column_name2=newValue2, ..., column_nameN=newValueN
-- 				WHERE column_name = value;

-- DELETE FROM db_name.table_name WHERE column_name = value;

-- utenti --> id_utente(pk),nome(NotNull),cognome(NotNull),citta(Null),
-- 				eta(Uns/Null),email(NotNull/Unq),codice_fiscale(NotNull/Unq)

INSERT INTO napol011_test.utenti (nome, cognome, citta, eta, email, codice_fiscale)
	VALUES  ("Mario", "Rossi", "Roma", 25, "m.rossi@example.com", "ABCDEF123AB12ABD"),
			("Giuseppe", "Verdi", "Milano", 31, "g.verdi@example.com", "DEFABC123AB12ABD"),
            ("Francesca", "Neri", "Napoli", 28, "f.neri@example.com", "FABDEC123AB12ABD");
INSERT INTO napol011_test.utenti (nome, cognome, email, codice_fiscale)
	VALUES  ("Antonio", "Bianchi", "a.bianchi@example.com", "BDEFAC123AB12ABD");
INSERT INTO napol011_test.utenti (nome, cognome, email, citta, codice_fiscale)
	VALUES  ("Maria", "Viola", "m.viola@example.com", "Torino", "BFADEC123AB12");

UPDATE napol011_test.utenti SET codice_fiscale = "BFADEC123AB12ABD" WHERE id_utente = 5;
UPDATE napol011_test.utenti SET citta = "Roma", eta = 35 WHERE id_utente = 4;

INSERT INTO napol011_test.passaporti (numero_passaporto, data_rilascio, id_utente)
				VALUES (1, "2025-02-10", 1),
						(2, "2025-01-21", 3),
                        (3, "2025-03-15", 5);

-- DELETE FROM napol011_test.utenti WHERE id_utente = 11;

-- DQL -> Data Query Language
-- Definisce tutte le istruzioni SQL per la lettura dei dati contenuti in un DB

-- SELECT 	-> Definisce un elenco di campi o tutto(*) da restituire in un resultset di dati
-- FROM 	-> Indica la sorgente di dati da cui leggere le informazioni (la/le tabelle)
-- WHERE	-> Search Condition, applica un filtro sulle righe della tabella indicata nel FROM
-- GROUP BY	-> Aggrega dei dati rispetto alla combinazione univoca data dalla group list
-- HAVING	-> Search Condition, applica un filtro sulle righe della tabella filtrata ed aggregata dal GROUP BY
-- ORDER BY	-> Consente di definire un ordinamento ben preciso
-- LIMIT	-> Consente di selezionare un numero definito di record

/*
	SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
*/

/*
	Operatori di confronto della Search Condition
    = (uguale)
    > (maggiore di)
    < (minore di)
    >= (maggiore o uguale)
    <= (minore o uguale)
    <>|!= (diverso da) 
    !< (non minore di)
    !> (non maggiore di)
    
    Operatori logici della Search Condition
    AND (restituisce TRUE se entrambe le condizioni sono vere)
    OR (restituisce TRUE se almeno una delle condizioni è vera)
    
    LIKE (contiene -> caratteri jolly -> _ %)
    BETWEEN (restituisce tutti i valori compresi tra >= AND <= del range specificato)
    IN | NOT IN (Di un elenco di dati in cui individuare una corrispondenza)
    
    Function SQL
    
    String function
    https://dev.mysql.com/doc/refman/8.4/en/string-functions.html
    CONCAT(column_name1, " - ", column_name2) -> Funzione che permette di concatenare due o più valori
    UPPER('String' | column_name) -> Funzione che permette di trasformare un valore testuale in Uppercase
    LOWER('String' | column_name) -> Funzione che permette di trasformare un valore testuale in Lowercase
    LENGTH('String' | column_name) -> Funzione che restituisce la lunghezza di una stringa o di un valore letto dal db
    TRIM('String' | column_name) -> Funzione che restituisce un valore testuale senza spazi vuoti prima o dopo il testo

	Numeric Function
    https://dev.mysql.com/doc/refman/8.4/en/numeric-functions.html
    COUNT(* | DISTINCT column_name) -> Funzione che restituisce il numero di record di una query
    FORMAT(number | column_name, 2) -> Funzione che restituisce un numero decimale formattato
    TRUNCATE(number | column_name, 2) -> Funzione che restituisce un numero decimale troncato
    ABS(number | column_name) -> Funzione che restituisce un valore assoluto (senza segno -)
    AVG(column_name) -> Funzione che restituisce la media dei valori numerici di una colonna
    CEIL(column_name) -> Funzione che restituisce un valore arrotondato per eccesso
    FLOOR(column_name) -> Funzione che restituisce un valore arrotondato per difetto
    ROUND(column_name) -> Funzione che restituisce un valore arrotondato per il numero intero più vicino
    RAND() -> Funzione che restituisce un valore casuale da 0 a 1
    MAX(column_name) -> Funzione che restituisce il valore massimo presente in una colonna
    MIN(column_name) -> Funzione che restituisce il valore minimo presente in una colonna
    SUM(column_name) -> Funzione che restituisce la somma dei valori presenti in una colonna

	Date Function
    ADDDATE(data, n) -> Funzione che aggiunge n ad una data
    ADDTIME(time, n) -> Funzione che aggiunge n ad un valore orario
    CURRENT_DATE() -> Funzione che restituisce una data in formato YYYY-MM-DD (String)
    CURRENT_TIME() -> Funzione che restituisce un orario in formato HH-MM-SS (String)
    CURRENT_TIMESTAMP() -> Funzione che restituisce data e ora del momento
    DATADIFF(data1, data2) -> Funzione che calcola la differenza di giorni tra due date
    DAY(data) -> Funzione che restituisce il giorno da una data completa
    MONTH(data) -> Funzione che restituisce il mese da una data completa
    YEAR(data) -> Funzione che restituisce l'anno da una data completa
    HOUR(data) -> Funzione che restituisce l'ora da una data completa
    MINUTE(data) -> Funzione che restituisce i minuti da una data completa
    SECOND(data) -> Funzione che restituisce i secondi da una data completa
    
    Advanced Function
    ISNULL(column_name) -> Funzione che restituisce 1 o 0 in base al valore NULL contenuto in una colonna
    LAST_INSERT_ID() -> Funzione che restituisce l'ultimo valore intero inserito nel campo ID della PK
    
*/

/*
	INNER JOIN | LEFT JOIN | RIGHT JOIN | CROSS JOIN
    
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        INNER JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
	
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        LEFT JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
       
	SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        RIGHT JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
	
    SELECT [DISTINCT] column_name1, column_name2, ..., column_nameN |*| aggregate_function(expression)
		FROM db_name.table_name1 AS tb1
        CROSS JOIN db_name.table_name2 AS tb2
        ON tb1.column_name = tb2.column_name
        [WHERE Search Condition]
        [GROUP BY]
        [HAVING Search Condition]
        [ORDER BY]
        [LIMIT]
    
*/

SELECT * FROM napol011_test.utenti;
SELECT nome, cognome, citta FROM napol011_test.utenti;
SELECT nome, cognome, citta FROM napol011_test.utenti WHERE citta = "Roma";
SELECT * FROM napol011_test.utenti WHERE eta <= 25;
SELECT * FROM napol011_test.utenti WHERE citta != "Roma";
SELECT * FROM napol011_test.utenti WHERE citta != "Roma" AND eta > 30;
SELECT * FROM napol011_test.utenti WHERE email LIKE "%.com";
SELECT * FROM napol011_test.utenti WHERE citta LIKE "%o";
SELECT * FROM napol011_test.utenti WHERE cognome LIKE "__r%"; 
SELECT * FROM napol011_test.utenti WHERE eta BETWEEN 25 AND 30;
SELECT * FROM napol011_test.utenti WHERE citta IN ("Roma", "Napoli", "Palermo");
SELECT * FROM napol011_test.utenti WHERE citta NOT IN ("Roma", "Napoli", "Palermo");
SELECT UPPER(nome), LOWER(cognome) FROM napol011_test.utenti;
SELECT * FROM napol011_test.utenti WHERE LENGTH(citta) > 5;
SELECT CONCAT(nome, " ", cognome, " età: ", eta) FROM napol011_test.utenti;
SELECT COUNT(*) FROM napol011_test.utenti WHERE LENGTH(citta) > 5;
SELECT MAX(eta) FROM napol011_test.utenti;
SELECT MIN(eta) FROM napol011_test.utenti;
SELECT SUM(eta) FROM napol011_test.utenti;
SELECT FORMAT(AVG(eta), 2) FROM napol011_test.utenti;
SELECT LAST_INSERT_ID() FROM napol011_test.utenti;

SELECT * FROM napol011_test.utenti;
SELECT * FROM napol011_test.utenti WHERE NOT ISNULL(eta);
SELECT citta, count(*) FROM napol011_test.utenti GROUP BY citta;
SELECT citta, count(*) 
		FROM napol011_test.utenti 
        WHERE NOT ISNULL(eta) 
        GROUP BY citta
        HAVING COUNT(*) >= 2
        ORDER BY citta
        LIMIT 3;
-- FROM --> [WHERE] --> [GROUP BY] --> [HAVING] --> [ORDER BY] --> [LIMIT] --> SELECT

SELECT * FROM napol011_test.utenti;
SELECT * FROM napol011_test.passaporti;

SELECT numero_passaporto, data_rilascio, nome, cognome, citta, eta, email, codice_fiscale FROM napol011_test.passaporti AS p
        INNER JOIN napol011_test.utenti AS u
		ON p.id_utente = u.id_utente;
        
SELECT numero_passaporto, data_rilascio, nome, cognome, citta, eta, email, codice_fiscale FROM napol011_test.passaporti AS p
        RIGHT JOIN napol011_test.utenti AS u
		ON p.id_utente = u.id_utente;
        
SELECT numero_passaporto, data_rilascio, nome, cognome, citta, eta, email, codice_fiscale FROM napol011_test.utenti AS u 
        LEFT JOIN napol011_test.passaporti AS p
		ON p.id_utente = u.id_utente;
        
SELECT * FROM napol011_test.utenti AS u 
		LEFT JOIN napol011_test.automobili AS a ON u.id_utente = a.id_utente
        LEFT JOIN napol011_test.passaporti AS p ON p.id_utente = u.id_utente;
        
-- SIMULARE UN FULL JOIN IN MySQL
SELECT numero_passaporto, data_rilascio, nome, cognome, citta, eta, email, codice_fiscale FROM napol011_test.passaporti AS p
        LEFT JOIN napol011_test.utenti AS u
		ON p.id_utente = u.id_utente
UNION ALL
SELECT numero_passaporto, data_rilascio, nome, cognome, citta, eta, email, codice_fiscale FROM napol011_test.passaporti AS p
        RIGHT JOIN napol011_test.utenti AS u
		ON p.id_utente = u.id_utente;

		
        
