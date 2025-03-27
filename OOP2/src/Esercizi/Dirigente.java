package Esercizi;

public class Dirigente extends Dipendente {

    public Dirigente(String matricola, String nomeCompleto) {
        super(matricola, nomeCompleto, Dipartimento.AMMINISTRAZIONE);
    }

    public double calculateSalary() {
        return getStipendio() * 2;
    }

    public String info() {
        return super.info() + " -> €" + calculateSalary();
    }
}
