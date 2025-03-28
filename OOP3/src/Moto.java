public class Moto extends Veicolo{

    private int numPosti;
    private static int count = 0;

    public Moto(String marca, String modello, String colore, int numPosti) {
        super(marca, modello, colore);
        this.numPosti = numPosti;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void start() {
        System.out.println("Start Moto!");
    }

    public int getNumPosti() {
        return numPosti;
    }

    @Override
    public String info() {
        return  "Moto: " +
                super.info() +
                this.getNumPosti();
    }
}
