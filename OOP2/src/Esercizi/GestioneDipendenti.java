package Esercizi;

public class GestioneDipendenti {

    public static void main(String[] args) {

        DipendenteFullTime d1 = new DipendenteFullTime("A001", "Mario Rossi", Dipartimento.PRODUZIONE);
        DipendenteFullTime d2 = new DipendenteFullTime("A002", "Giuseppe Verdi", Dipartimento.AMMINISTRAZIONE);
        DipendentePartTime d3 = new DipendentePartTime("A003", "Francesca Neri", Dipartimento.AMMINISTRAZIONE, 20);
        Dirigente d4 = new Dirigente("A005", "Antonio Bianchi");
        DipendentePartTime d5 = new DipendentePartTime("A005", "Luigi Viola", Dipartimento.PRODUZIONE, 30);
        DipendenteFullTime d6 = new DipendenteFullTime("A006", "Maria Gialli", Dipartimento.VENDITE);

        /*System.out.println(d1.info());
        System.out.println(d2.info());
        System.out.println(d3.info());
        System.out.println(d4.info());
        System.out.println(d5.info());
        System.out.println(d6.info());*/

        Dipendente[] dipendenti = new Dipendente[6];
        dipendenti[0] = d1;
        dipendenti[1] = d2;
        dipendenti[2] = d3;
        dipendenti[3] = d4;
        dipendenti[4] = d5;
        dipendenti[5] = d6;

        for (int i=0; i<dipendenti.length ; i++) {
            Dipendente d = dipendenti[i];
            /*if(d instanceof DipendenteFullTime) {
                DipendenteFullTime dft = (DipendenteFullTime) d;
                System.out.println(dft.info());
            } else if(d instanceof DipendentePartTime) {
                DipendentePartTime dpt = (DipendentePartTime) d;
                System.out.println(dpt.info());
            } else if(d instanceof Dirigente) {
                Dirigente dr = (Dirigente) d;
                System.out.println(dr.info());
            }*/
            System.out.println(d.info());
        }

    }

}
