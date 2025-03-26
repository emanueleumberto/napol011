package Esercizi;

public class SIM {

    public String numeroTelefono;
    public double credito;
    public Chiamata[] listaChiamate;

    public SIM(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.credito = 0;
        this.listaChiamate = new Chiamata[5];
    }

    public void stampaSim() {
        System.out.println("Sim numero: " + this.numeroTelefono);
        System.out.println("Credito: " + this.credito);
        System.out.println("Lista di chiamate: ");
        for (int i = 0; i <this.listaChiamate.length ; i++) {
            if(this.listaChiamate[i] != null) {
                System.out.println("     - " + this.listaChiamate[i].numeroChiamato);
            } else {
                System.out.println("     - " + this.listaChiamate[i]);
            }
        }
    }

    public void ricaricaCredito(double credito) {
        this.credito += credito;
        System.out.println("Ricarica da €" + credito + " effettuata sul numero " + this.numeroTelefono);
    }

    public void effettuaChiamata(Chiamata chiamata) {
        if(this.credito > 0) {
            System.out.println("Chiamata effettuata sul numero " + chiamata.numeroChiamato + " durata: " + chiamata.durata);
            aggiornaCredito(chiamata.durata);
            salvaChiamata(chiamata);
        } else {
            System.out.println("Non hai credito sufficiente!!!");
        }
    }

    public void aggiornaCredito(double minuti) {
        double importoSpeso = minuti * 0.2;
        this.credito -= importoSpeso;
    }

    public void salvaChiamata(Chiamata chiamata) {
        //this.listaChiamate[0] = chiamata;
        for (int i = 0; i < this.listaChiamate.length ; i++) {
            if(this.listaChiamate[i] == null) {
                this.listaChiamate[i] = chiamata;
                break;
            }
        }
    }
    
}
