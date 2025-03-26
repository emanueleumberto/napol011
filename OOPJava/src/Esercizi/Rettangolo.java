package Esercizi;

public class Rettangolo {

    public double altezza;
    public double larghezza;

    public Rettangolo(double altezza, double larghezza) {
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public double calcolarePerimetro() {
        return (this.altezza*2)+(this.larghezza*2);
    }

    public double calcolareArea() {
        return this.altezza * this.larghezza;
    }

    public void stampaRettangolo() {
        System.out.println("Larghezza: " + this.larghezza);
        System.out.println("Altezza: " + this.altezza);
        System.out.println("Perimetro: " + this.calcolarePerimetro());
        System.out.println("Area: " + this.calcolareArea());
    }

}
