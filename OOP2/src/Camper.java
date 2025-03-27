public class Camper extends Veicolo {

    private int numLetti;

    public Camper(String marca, String modello, String targa, int numLetti) {
        super(marca, modello, targa);
        this.numLetti = numLetti;
    }

    public int getNumLetti() {
        return this.numLetti;
    }

    public void setNumLetti(int numLetti) {
        this.numLetti = numLetti;
    }

    public String infoCamper() {
        return this.getMarca() + " " + this.getModello() + " Targa: " + this.getTarga() + " Num. Letti: " + this.numLetti;
    }
}
