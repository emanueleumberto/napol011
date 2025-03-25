import java.time.LocalDate;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        // Algoritmi e strutture di controllo
        // if-else switch for while

        // IF-ELSE
        // if(condizione) { blocco di istruzioni }
        // else if(condizione){ blocco di istruzioni }
        // ...
        // else { blocco di istruzioni }
        int x = 5;
        if(x > 5) {
            System.out.println("x > 5");
            if(x % 2 == 0) {
                System.out.println("Numero pari");
            } else {
                System.out.println("Numero dispari");
            }
        } else if (x == 5) {
            System.out.println("x = 5");
        } else {
            System.out.println("x < 5");
        }

        // SWITCH
        // switch (espressione)
        // case n: blocco di istruzioni; break;
        // ...
        // case n: blocco di istruzioni; break;
        // default: blocco di istruzioni; break;
        Scanner sc = new Scanner(System.in);
        System.out.println("Scegli un opzione tra 1-2-3");
        int s = Integer.parseInt(sc.nextLine());
        switch (s) {
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
            default:
                System.out.println("Errore");
                break;
        }



        // FOR
        // for(inizializzazione; condizione; incremento) { blocco di istruzioni }
        for(int i=0; i<10; i++) {
            if(i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

        // WHILE

        // while(condizione) { blocco di istruzioni }
        int z = 0;
        while(z<10) {
            System.out.println(z);
            z++;
        }

        while (true) {
            System.out.println("Seleziona un valore tra 1-5 o 0 per uscire");
            int st = Integer.parseInt(sc.nextLine());
            if(st > 0 && st <=5) {
                System.out.println("Il valore inserito è " + st);
            } else if(st == 0) {
                break;
            } else {
                System.out.println("Valore errato!!!");
            }
        }

        int y = 0;
        do {
            System.out.println(y);
            y++;
        } while (y<5);
        int st;
        do {
            System.out.println("Seleziona un valore tra 1-5 o 0 per uscire");
            st = Integer.parseInt(sc.nextLine());
            System.out.println("Il valore inserito è " + st);
        } while (st != 0);


        System.out.println("FINE");


        // Per contare la lunghezza di una stringa utilizzare:
        "stringa".length();

        // Oggetto LocalDate
        // LocalDate.now() -> restituisce la data del momento
        // .getMonth() -> restituisce il mese di un oggetto di tipo LocalDate
        // .getYear() -> restituisce il anno di un oggetto di tipo LocalDate
        // .getDayOfMonth() -> restituisce il giorno di un oggetto di tipo LocalDate
        LocalDate oggi = LocalDate.now();
        LocalDate altraData = LocalDate.of(2000, 10, 1);
        System.out.println(oggi.getMonth());
        System.out.println(oggi.getYear());
        System.out.println(oggi.getDayOfMonth());


        // Soluzione esercizi
        //int r = somma();
        //System.out.println("Il risultato della somma è: " + r);
    }

    // Esercizio 1
    // Implementare il seguente metodo
    // somma       -> Chiede ad un utente due numeri tramite Scanner, li somma e ne restituisce il risultato
    //                se è un numero pari altrimenti restituisce 0;
    public static int somma() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci il secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        int r = num1 + num2;
        if(r % 2 == 0) { return r; }
        else { return 0; }
    }

}
