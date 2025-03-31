package Esercizio_2803;

public class Utente {

    private static int count = 0;
    private String nome;
    private String cognome;
    private String IDUtente;
    private Libro[] listaPrestiti;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        //this.IDUtente = "U00" + ++count;

        /*if(count < 10) {
            this.IDUtente = "U0" + ++count;
        } else {
            this.IDUtente = "U" + ++count;
        }*/

        // condizione ? true : false
        this.IDUtente = count < 10 ? "U0" + ++count : "U" + ++count;
        this.listaPrestiti = new Libro[3];
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getIDUtente() { return IDUtente; }
    public Libro[] getListaPrestiti() { return listaPrestiti; }

    public void prendereInPrestito(Libro libro) {
        // → Aggiunge il libro alla lista e aggiorna la disponibilità
        if(libro.isDisponibile()) { // Controllo se il libro è disponibile o meno
            for (int i = 0; i < listaPrestiti.length; i++) {
                if(listaPrestiti[i] == null) {
                    libro.prestareLibro(); // imposto la proprietà disponibile a false
                    this.listaPrestiti[i] = libro; // inserisco il libro nell'array di libri personali
                    return; // esce dal metodo a differenza del break che esce dal for e continua.
                }
            }
            // viene eseguito quando, illibro è disponibile ma non ho la possibilità di prenderlo
            // perchè già in possesso di 3 libri
            System.out.println("Hai già 3 libri in prestito, restituisci qualcosa.");
        } else {
            System.out.println("Libro " + libro.getTitolo() + " non disponibile, torna tra qualche giorno.");
        }
    }

    public void restituireLibro(Libro libro) {
        // → Rimuove il libro dalla lista e aggiorna la disponibilità

        for (int i = 0; i < listaPrestiti.length ; i++) {
            if(this.listaPrestiti[i] != null && this.listaPrestiti[i].getISBN().equals(libro.getISBN())) {
                libro.restituireLibro();
                this.listaPrestiti[i] = null;
                return;
            }
        }
        System.out.println("Il libro che vuoi restituire non è a te assegnato!!!");
    }

    public void mostraLibriInPrestito() {
        // → Stampa i libri presi in prestito dall'utente
        System.out.println("Libri in prestito da " + this.nome + " " + this.cognome);
        for (int i = 0; i < listaPrestiti.length ; i++) {
            if(listaPrestiti[i] != null) {
                System.out.println("     - " + listaPrestiti[i].getTitolo());
            }
        }
    }

}
