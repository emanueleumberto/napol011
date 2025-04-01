package Esercizio.Soluzione1;

public class Teatro {

    private String nome;
    //private boolean posti[];
    private boolean[] posti;

    public Teatro(String nome, int numPosti) {
        this.nome = nome;
        this.posti = resetPosti(numPosti);
    }

    public String getNome() {
        return nome;
    }
    public boolean[] getPosti() {
        return posti;
    }

    public boolean[] resetPosti(int numPosti) {
        boolean[] postiTeatro = new boolean[numPosti];
        for (int i = 0; i < postiTeatro.length; i++) {
            postiTeatro[i] = false;
        }
        return postiTeatro;
    }

    public void prenotaPosto(int numeroPosto) throws PostiTerminatiException, PostoNonValidoException, PostoGiaOccupatoException {
        // Teatro pieno
        if(!controlloPostiDisponibili()) {
            throw new PostiTerminatiException("Sold Out!!!");
        }
        // Posto fuori range
        if(numeroPosto <= 0 || numeroPosto - 1 > this.posti.length ) {
            throw new PostoNonValidoException("Valore non valido, devi inserire un valore compreso tra 1 e " + this.posti.length);
        }
        // Posto occupato
        if(posti[numeroPosto - 1]) {
            throw new PostoGiaOccupatoException("Posto " + numeroPosto + " occupato!!!");
        }

        // Prenoto posto
        posti[numeroPosto-1] = true;
        System.out.println("Prenotazione posto " + numeroPosto + " effettuata!");
    }

    public boolean controlloPostiDisponibili() {
        for (int i = 0; i < this.posti.length ; i++) {
            if(!posti[i]) {
                return true;
            }
        }
        return false;
    }
}
