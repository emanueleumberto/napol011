package Esercizio_2803;

public class GestioneBiblioteca {
    public static void main(String[] args) {

        Libro l1 = new Libro("Il vento conosce il mio nome", "Isabel Allende", "2000000153513");
        Libro l2 = new Libro("Game of Desire. Devozione", "Hazel Riley", "9788820081140");
        Libro l3 = new Libro("L' uomo duplicato", "José Saramago", "2000000153360");
        Libro l4 = new Libro("La strada giovane", "Antonio Albanese", "9788807036521");
        Libro l5 = new Libro("Le cose che ci salvano", "Lorenza Gentile", "2000000153483");

//        System.out.println(l1.getDettagli());
//        System.out.println(l2.getDettagli());
//        System.out.println(l3.getDettagli());
//        System.out.println(l4.getDettagli());
//        System.out.println(l5.getDettagli());

        Utente u1 = new Utente("Mario", "Rossi");
        Utente u2 = new Utente("Giuseppe", "Verdi");
        Utente u3 = new Utente("Francesca", "Neri");

//        u1.prendereInPrestito(l4);
//        u1.prendereInPrestito(l1);
//        u1.restituireLibro(l4);
//        u1.mostraLibriInPrestito();

        Biblioteca b1 = new Biblioteca("New Biblioteca");
        b1.aggiungiLibro(l1);
        b1.aggiungiLibro(l2);
        b1.aggiungiLibro(l3);
        b1.aggiungiLibro(l4);
        b1.aggiungiLibro(l5);

        b1.registraUtente(u1);
        b1.registraUtente(u2);
        b1.registraUtente(u3);

        b1.mostraCatalogo();
        b1.mostraUtentiRegistrati();

        b1.prestitoLibro("U01", "2000000153360");
        b1.prestitoLibro("U03", "2000000153483");
        b1.prestitoLibro("U02", "2000000153360");
        b1.restituzioneLibro("U01", "2000000153360");
        b1.prestitoLibro("U02", "2000000153360");

//        System.out.println(u1); // Stampa il riferimento alla zona di memoria di u1
//        Utente search = b1.cercaUtente("U01");
//        System.out.println(search);
    }
}
