public class Automobile extends Veicolo {

    private int numPorte;

    public Automobile(String marca, String modello, String targa, int numPorte) {
        super(marca, modello, targa);
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return this.numPorte;
    }

    public String infoAutomobile() {
        return this.getMarca() + " " + this.getModello() + " Targa: " + this.getTarga() + " Num. Porte: " + this.numPorte;
    }
}
