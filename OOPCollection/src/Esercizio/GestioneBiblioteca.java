package Esercizio;

import java.sql.SQLOutput;
import java.util.Set;

public class GestioneBiblioteca {

    private static Biblioteca biblio = new Biblioteca();

    public static void main(String[] args) {

        Lettore u1 = new Lettore("Mario Rossi", "m.rossi@example.com");
        Lettore u2 = new Lettore("Giuseppe Verdi", "g.verdi@example.com");
        Lettore u3 = new Lettore("Francesca Neri", "f.neri@example.com");

        Libro l1 = new Libro("9788831002479", "Piccole donne crescono",
                            "Louisa May Alcott", 2020);
        Libro l2 = new Libro("9788811601661", "Un disastro è per sempre",
                            "Jamie McGuire", 2017);
        Libro l3 = new Libro("9788833576237", "Qui, solo qui",
                            "Christelle Dabos", 2023);
        Libro l4 = new Libro("9788811149750", "L'ultimo disastro",
                            "Jamie McGuire", 2018);
        Libro l5 = new Libro("9788859282396", "Albania",
                            "Piero Pasini", 2023);

        biblio.aggiungiLibro(l1);
        biblio.aggiungiLibro(l2);
        biblio.aggiungiLibro(l3);
        biblio.aggiungiLibro(l4);
        biblio.aggiungiLibro(l5);

        System.out.println("Libri disponibili: " + biblio.getLibriDisponibili().size());
        for (Libro l: biblio.getLibriDisponibili()) {
            System.out.println("   - " + l);
        }

        try {
            biblio.registraLettore(u1);
            biblio.registraLettore(u2);
            biblio.registraLettore(u3);
            //biblio.registraLettore(u1);

            System.out.println("Lettori registrati: " + biblio.getUtentiRegistrati().size());
            for (Lettore l : biblio.getUtentiRegistrati()) {
                System.out.println("   - " + l);
            }
        } catch (LettoreException e) {
            System.err.println(e.getMessage());
        }

        // Effettuo prestito
        System.out.println("****** Gestione Prestiti: ");
        try {
            biblio.prestaLibro(u2, "9788811149750");

            Set<Libro> prestitoUtente = biblio.getLibriInPrestito(u2);
            for(Libro l : prestitoUtente) {
                System.out.println("  -> " + l);
            }
        } catch (LibroException | LettoreException | PrestitoException e) {
            System.err.println(e.getMessage());
        }

    }

}
