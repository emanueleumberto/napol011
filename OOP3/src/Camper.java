public class Camper extends Veicolo{

    private int numLetti;
    private static int count = 0;

    public Camper(String marca, String modello, String colore, int numLetti) {
        super(marca, modello, colore);
        this.numLetti = numLetti;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void start() {
        System.out.println("Start Camper!");
    }

    public int getNumLetti() {
        return numLetti;
    }

    public void setNumLetti(int numLetti) {
        this.numLetti = numLetti;
    }

    @Override
    public String info() {
        return  "Camper: " +
                super.info() +
                this.getNumLetti();
    }
}
