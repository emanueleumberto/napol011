public class Veicolo {

    private String marca;
    private String modello;
    private String targa;

    public Veicolo(String marca, String modello, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
    }

    public String getMarca() { return this.marca; }

    public String getModello() { return this.modello; }

    public String getTarga() { return this.targa; }

    public void setTarga(String targa) { this.targa = targa; }

    /*public String info() {
        return this.marca + " " + this.modello + " Targa: " + this.targa;
    }*/

}
