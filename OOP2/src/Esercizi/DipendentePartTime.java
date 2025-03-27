package Esercizi;

public class DipendentePartTime extends Dipendente{

    private int oreSettimanali;

    public DipendentePartTime(String matricola, String nomeCompleto, Dipartimento dipartimento, int oreSettimanali) {
        super(matricola, nomeCompleto, dipartimento);
        this.oreSettimanali = oreSettimanali;
    }

    public double calculateSalary() {
        //return getStipendio() - (getStipendio() * 0.4);
        if(this.oreSettimanali == 30) {
            return getStipendio() - (getStipendio() * 0.2);
        } else if(this.oreSettimanali == 20) {
            return getStipendio() - (getStipendio() * 0.4);
        } else if(this.oreSettimanali == 10) {
            return getStipendio() - (getStipendio() * 0.6);
        } else {
            return getStipendio();
        }
    }

    public String info() {
        return super.info() + " -> €" + calculateSalary();
    }
}
