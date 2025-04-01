package Esercizio.Soluzione2;

import Esercizio.Soluzione1.PostiTerminatiException;
import Esercizio.Soluzione1.PostoGiaOccupatoException;
import Esercizio.Soluzione1.PostoNonValidoException;

public class Teatro {

    private String nome;
    private Utente[] posti;

    public Teatro(String nome, int numPosti) {
        this.nome = nome;
        this.posti = resetPosti(numPosti);
    }

    public String getNome() {
        return nome;
    }
    public Utente[] getPosti() {
        return posti;
    }

    public Utente[] resetPosti(int numPosti) {
        Utente[] postiTeatro = new Utente[numPosti];
        for (int i = 0; i < postiTeatro.length; i++) {
            postiTeatro[i] = null;
        }
        return postiTeatro;
    }

    public void prenotaPosto(int numeroPosto, Utente u) throws Esercizio.Soluzione1.PostiTerminatiException, Esercizio.Soluzione1.PostoNonValidoException, Esercizio.Soluzione1.PostoGiaOccupatoException {
        // Teatro pieno
        if(!controlloPostiDisponibili()) {
            throw new PostiTerminatiException("Sold Out!!!");
        }
        // Posto fuori range
        if(numeroPosto <= 0 || numeroPosto - 1 > this.posti.length ) {
            throw new PostoNonValidoException("Valore non valido, devi inserire un valore compreso tra 1 e " + this.posti.length);
        }
        // Posto occupato
        if(posti[numeroPosto - 1] != null) {
            throw new PostoGiaOccupatoException("Posto " + numeroPosto + " occupato!!!");
        }

        // Prenoto posto
        posti[numeroPosto-1] = u;
        System.out.println("Prenotazione posto " + numeroPosto + " effettuata da " + u);
    }

    public boolean controlloPostiDisponibili() {
        for (int i = 0; i < this.posti.length ; i++) {
            if(posti[i] == null) {
                return true;
            }
        }
        return false;
    }
}
