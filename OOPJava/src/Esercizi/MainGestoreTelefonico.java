package Esercizi;

public class MainGestoreTelefonico {
    public static void main(String[] args) {
        SIM s1 = new SIM("+39 123.456.789");

        Chiamata c1 = new Chiamata("+39 987.654.321");
        Chiamata c2 = new Chiamata("+39 654.321.789");
        Chiamata c3 = new Chiamata("+39 369.258.147");
        s1.ricaricaCredito(10);
        s1.effettuaChiamata(c1);
        s1.effettuaChiamata(c2);
        s1.effettuaChiamata(c3);
        s1.stampaSim();
    }
}
