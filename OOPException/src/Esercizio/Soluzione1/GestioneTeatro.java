package Esercizio.Soluzione1;

import java.util.Arrays;
import java.util.Scanner;

public class GestioneTeatro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Teatro t = new Teatro("Ariston", 10);

        while (true) {
            System.out.print("Quale posto vuoi prenotare? Inserisci un valore da 1 a "
                    + t.getPosti().length + ": ");
            int numPosto = Integer.parseInt(sc.nextLine());
            try {
                t.prenotaPosto(numPosto);
            } catch (PostiTerminatiException | PostoNonValidoException | PostoGiaOccupatoException e) {
                System.err.println(e.getMessage());
            }

            System.out.println(Arrays.toString(t.getPosti()));
        }
    }

}
