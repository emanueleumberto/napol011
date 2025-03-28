public class Automobile extends Veicolo implements Navigatore {

    private int numPorte;
    private static int count = 0;

    public Automobile(String marca, String modello, String colore, int numPorte) {
        super(marca, modello, colore);
        this.numPorte = numPorte;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void start() {
        System.out.println("Start Automobile!");
    }

    public int getNumPorte() {
        return numPorte;
    }

    @Override
    public String info() {
        return  "Automobile: " +
                super.info() +
                this.getNumPorte();
    }

    @Override
    public void startNavigatore() {

    }

    @Override
    public void stopNavigatore() {

    }

    @Override
    public void aggiornaNavigatore() {
        System.out.println("Navigatore aggiornato Automobile");
    }
}
