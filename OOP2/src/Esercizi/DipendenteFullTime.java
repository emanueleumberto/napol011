package Esercizi;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String matricola, String nomeCompleto, Dipartimento dipartimento) {
        super(matricola, nomeCompleto, dipartimento);
    }

    public double calculateSalary() {
        return getStipendio();
    }

    public String info() {
        return super.info() + " -> €" + calculateSalary();
    }

}
