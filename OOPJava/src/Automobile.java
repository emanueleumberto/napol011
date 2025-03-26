public class Automobile {

    // Membri della classe
    // Attributi o Proprietà di istanza
    public String marca;
    public String modello;
    public int cilindrata;
    public String colore;
    public String targa;
    public boolean motoreAcceso;
    public TipoAlimentazione tipoAlimentazione;

    public Automobile(String marca, String modello, int cilindrata, String colore, TipoAlimentazione tipoAlimentazione) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.colore = colore;
        this.tipoAlimentazione = tipoAlimentazione;
        this.motoreAcceso = false;
    }

    public Automobile(String marca, String modello, int cilindrata, String colore, TipoAlimentazione tipoAlimentazione, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.colore = colore;
        this.targa = targa;
        this.tipoAlimentazione = tipoAlimentazione;
        this.motoreAcceso = false;
    }

    // Metodi di istanza
    public void start() {
        motoreAcceso = true;
        System.out.println("Automobile " + marca + " " + modello + " start!");
    }

    public void stop() {
        motoreAcceso = false;
        System.out.println("Automobile " + marca + " " + modello + " stop!");
    }

    public void info() {
        System.out.println("Automobile " + marca + " " + modello);
        System.out.println("Targa: " + targa);
        System.out.println("Colore: " + colore);
        System.out.println("Cilindrata: " + cilindrata);
        System.out.println("Alimentazione: " + tipoAlimentazione);
        System.out.println("Motore acceso: " + motoreAcceso);
    }

}
