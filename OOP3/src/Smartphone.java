public class Smartphone implements Navigatore{

    private String marca;
    private String modello;
    private String colore;

    @Override
    public void startNavigatore() {

    }

    @Override
    public void stopNavigatore() {

    }

    @Override
    public void aggiornaNavigatore() {
        System.out.println("Navigatore aggiornato Smartphone");
    }
}
