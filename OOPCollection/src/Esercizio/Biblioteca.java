package Esercizio;

import java.util.*;

public class Biblioteca {

    private List<Libro> libriDisponibili;
    private Set<Lettore> utentiRegistrati;
    private Map<Lettore, Set<Libro>> prestiti;

    public Biblioteca() {
        this.libriDisponibili = new ArrayList<Libro>();
        this.utentiRegistrati = new HashSet<Lettore>();
        this.prestiti = new HashMap<Lettore, Set<Libro>>();
    }

    public List<Libro> getLibriDisponibili() {
        return libriDisponibili;
    }

    public Set<Lettore> getUtentiRegistrati() {
        return utentiRegistrati;
    }

    public Map<Lettore, Set<Libro>> getPrestiti() {
        return prestiti;
    }

    public void aggiungiLibro(Libro libro) {
        this.libriDisponibili.add(libro);
    }

    public void registraLettore(Lettore lettore) throws LettoreException {
        boolean insert = this.utentiRegistrati.add(lettore);
        if(!insert) {
            //System.out.println("Utente già registrato!!!");
            throw new LettoreException("Utente già registrato!!!");
        }
    }

    public boolean prestaLibro(Lettore lettore, String isbn) throws LibroException, LettoreException {

        Libro lib = trovaLibroDaISBN(isbn);
        if(lib == null) { throw new LibroException("Codice ISBN non trovato!!"); }
        if(this.utentiRegistrati.contains(lettore)) {
            Set<Libro> listaLettore = new HashSet<Libro>();
            listaLettore.add(lib);
            this.prestiti.put(lettore, listaLettore);
            this.libriDisponibili.remove(lib);
            System.out.println("Libro " + lib.getTitolo() + " preso in prestito da " + lettore.getNome());
            return true;
        } else {
            throw new LettoreException("Lettore non registrato nella biblioteca!");
        }
    }

    public Set<Libro> getLibriInPrestito(Lettore lettore) throws PrestitoException {
        if(this.prestiti.containsKey(lettore)) {
            return this.prestiti.get(lettore);
        } else {
            throw new PrestitoException("Nessun prestito effettuato dall'utente " + lettore.getNome());
        }
    }

    public boolean restituisciLibro(Lettore lettore, String isbn) throws LibroException, LettoreException, PrestitoException {
        Libro lib = trovaLibroDaISBN(isbn);
        if(lib == null) { throw new LibroException("Codice ISBN non trovato!!"); }

        if(this.utentiRegistrati.contains(lettore)) {
            Set<Libro> prestitoUtente = this.getLibriInPrestito(lettore);
            for(Libro l : prestitoUtente) {
               if(l.getIsbn().equals(isbn)){
                   prestitoUtente.remove(l);
                   this.libriDisponibili.add(l);
                   System.out.println("Libro " + l.getTitolo() + " restituito da " + lettore.getNome());
               }
            }
            throw new PrestitoException("Il libro che vuoi restituire non è presente nella tua lista di presitit");
        } else {
            throw new LettoreException("Lettore non registrato nella biblioteca!");
        }
    }

    public void stampaPrestiti() {}

    private Libro trovaLibroDaISBN(String isbn) {
        for(Libro l: this.libriDisponibili) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }
}
