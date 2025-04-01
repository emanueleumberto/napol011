package Esercizio.Soluzione2;

public abstract class Utente {

    private String nome;
    private String cognome;
    private String cf;

    public Utente(String nome, String cognome, String cf) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getCf() { return cf; }

    @Override
    public String toString() {
        return this.nome + " " + this.cognome + " CF: " + this.cf;
    }
}
