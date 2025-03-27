public class Moto extends Veicolo {

    private int numPosti;

    public Moto(String marca, String modello, String targa, int numPosti) {
        super(marca, modello, targa);
        this.numPosti = numPosti;
    }

    public int getNumPosti() {
        return this.numPosti;
    }

    public String infoMoto() {
        return this.getMarca() + " " + this.getModello() + " Targa: " + this.getTarga() + " Num. Posti: " + this.numPosti;
    }
}
