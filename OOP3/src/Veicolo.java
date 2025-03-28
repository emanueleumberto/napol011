public abstract class Veicolo {

    private String marca;
    private String modello;
    private String colore;
    private static int count = 0;

    public Veicolo(String marca, String modello, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public abstract void start();

    public String info() {
        return  this.getMarca() + " " +
                this.getModello() + " Colore: " +
                this.getColore() + " ";
    }

    // Overloading dei metodi -> Creare metodi con lo stesso nome ma con firma differente
    // Numero di parametri | Tipo di parametri | Posizione dei parametri
    public void testPolimorfismo() {
        System.out.println("Sono il metodo 1");
    }

    public void testPolimorfismo(String str) {
        System.out.println("Sono il metodo 2");
    }

    public void testPolimorfismo(String str, int num) {
        System.out.println("Sono il metodo 3");
    }

    public void testPolimorfismo(String str1, String str2) {
        System.out.println("Sono il metodo 4");
    }

    public void testPolimorfismo(int num, String str) {
        System.out.println("Sono il metodo 5");
    }

}
