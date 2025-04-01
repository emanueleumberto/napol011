package Esercizio.Soluzione2;

import Esercizio.Soluzione1.PostiTerminatiException;
import Esercizio.Soluzione1.PostoGiaOccupatoException;
import Esercizio.Soluzione1.PostoNonValidoException;

import java.util.Arrays;
import java.util.Scanner;

public class GestioneTeatro {

    private static Scanner sc = new Scanner(System.in);
    private static Teatro t = new Teatro("Ariston", 10);

    public static void main(String[] args) {
        /*Uomo u1 = new Uomo("Mario", "Rossi", "ABC123DEF");
        Donna d1 = new Donna("Francesca", "Neri", "POI987REW");
        System.out.println(u1);
        System.out.println(d1);*/

        while(true) {
            System.out.print("Quale posto vuoi prenotare? Inserisci un valore da 1 a " + t.getPosti().length + ": ");
            int numPosto = Integer.parseInt(sc.nextLine());

            try {
                t.prenotaPosto(numPosto, creaUtente());
            } catch (PostiTerminatiException | PostoNonValidoException | PostoGiaOccupatoException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                System.out.println(Arrays.toString(t.getPosti()));
            }
        }

    }

    public static Utente creaUtente() throws Exception {
        System.out.print("Che utente vuoi creare? F | M");
        String s = sc.nextLine();

        if(s != "F" || s != "M") {
            throw new Exception("Valore inserito non valido");
        }

        Utente u = null;

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cognome: ");
        String cognome = sc.nextLine();
        System.out.print("CF: ");
        String cf = sc.nextLine();

        if(s.equals("F")) {
            u = new Donna(nome, cognome, cf);
        } else if(s.equals("M")) {
            u = new Uomo(nome, cognome, cf);
        }
        return u;
    }
}
