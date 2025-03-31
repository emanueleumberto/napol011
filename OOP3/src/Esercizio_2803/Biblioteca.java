package Esercizio_2803;

public class Biblioteca {

    private String nome;
    private Libro[] catalogoLibri;
    private Utente[] utentiRegistrati;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.catalogoLibri = new Libro[10];
        this.utentiRegistrati = new Utente[10];
    }

    public void aggiungiLibro(Libro libro) {
        // → Aggiunge un libro al catalogo se non esiste

        // Controllo se il libro è già presente nel catalogo
        for (int i = 0; i < catalogoLibri.length; i++) {
            if (this.catalogoLibri[i] != null && this.catalogoLibri[i].getISBN().equals(libro.getISBN())){
                System.out.println("Libro " + libro.getTitolo() + " già presente nel catalogo!");
                return;
            }
        }

        // Inserisco il libro nel catalogo
        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if (this.catalogoLibri[i] == null) {
                this.catalogoLibri[i] = libro;
                System.out.println(libro.getTitolo() + " inserito nel catalogo libri.");
                return;
            }
        }
        System.out.println("Catalogo libri pieno!!!");
    }

    public void registraUtente(Utente utente) {
        // → Aggiunge un utente alla lista se non esiste

        // Controllo se l'utente è già registrato
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] != null && this.utentiRegistrati[i].getIDUtente().equals(utente.getIDUtente())) {
                System.out.println(utente.getNome() + " " + utente.getCognome() +" già presente nella lista degli utenti registrati");
                return;
            }
        }

        // Inserisco il nuovo utente nella lista
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] == null) {
                this.utentiRegistrati[i] = utente;
                System.out.println(utente.getNome() + " " + utente.getCognome() +" registrato nella lista degli utenti");
                return;
            }
        }
        System.out.println("Lista utenti registrti pieno!!!");
    }

    public void mostraCatalogo() {
        // → Stampa tutti i libri con la loro disponibilità
        System.out.println("Catalogo Libri: ");
        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if(catalogoLibri[i] != null) {
                System.out.println("     - " + catalogoLibri[i].getDettagli());
            }
        }
    }

    public void mostraUtentiRegistrati() {
        // → Stampa tutti gli utenti registrati
        System.out.println("Utenti registrati: ");
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(utentiRegistrati[i] != null) {
                System.out.println("     - " + utentiRegistrati[i].getIDUtente() + " - " + utentiRegistrati[i].getNome() + " " + utentiRegistrati[i].getCognome());
            }
        }
    }

    public void prestitoLibro(String idUtente, String ISBN) {
        // → Permette a un utente di prendere in prestito un libro
        //   (se disponibile) e se non ha già presi 3

        Utente u = cercaUtente(idUtente); // Utente || null
        Libro l = cercaLibro(ISBN); // Libro || null
        if(u != null && l != null ) {
            if(l.isDisponibile()) {
                System.out.println("Libro " + l.getTitolo() + " preso in prestito da " + u.getNome() + " " + u.getCognome());
            }
            u.prendereInPrestito(l);
        } else {
            System.out.println("Errore!!!");
        }

    }

    public void restituzioneLibro(String idUtente, String ISBN) {
        // → Permette a un utente di restituire un libro

        Utente u = cercaUtente(idUtente); // Utente || null
        Libro l = cercaLibro(ISBN); // Libro || null
        if(u != null && l != null) {
            u.restituireLibro(l);
            System.out.println("Libro " + l.getTitolo() + " restituito da " + u.getNome() + " " + u.getCognome());
        } else {
            System.out.println("Errore!!!");
        }

    }

    public Utente cercaUtente(String idUtente) {
        for (int i = 0; i < this.utentiRegistrati.length; i++) {
            if(this.utentiRegistrati[i] != null && this.utentiRegistrati[i].getIDUtente().equals(idUtente)) {
                return this.utentiRegistrati[i];
            }
        }
        return null;
    }

    public Libro cercaLibro(String ISBN) {
        for (int i = 0; i < this.catalogoLibri.length; i++) {
            if(this.catalogoLibri[i] != null && this.catalogoLibri[i].getISBN().equals(ISBN)) {
                return this.catalogoLibri[i];
            }
        }
        return null;
    }


}
