package Esercizio_3103;

import java.util.Scanner;

public class GestionePlayerMultimediale {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Audio a1 = new Audio("Song1", 3, 5);
        //a1.alzaVolume();
        //a1.abbassaVolume();
        //a1.play();

        Video v1 = new Video("Movie1", 5, 6, 3);
        //v1.alzaVolume();
        //v1.abbassaVolume();
        //v1.aumentaLuminosita();
        //v1.diminuisciLuminosita();
        //v1.play();

        Immagine i1 = new Immagine("myImg", 3);
        //i1.aumentaLuminosita();
        //i1.diminuisciLuminosita();
        //i1.show();

        ElementoMultimediale[] arr = new ElementoMultimediale[5];
        arr[0] = i1;
        arr[1] = a1;
        arr[2] = v1;
        arr[3] = null;
        arr[4] = null;

        do {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != null) {
                    System.out.println(i + 1 + " - " + arr[i].getTitolo());
                } else {
                    System.out.println(i+1 + " - Empty" );
                }
            }
            System.out.print("Quale elemento vuoi riprodurre? Oppure scrivi 0 per terminare: ");
            int scelta = Integer.parseInt(sc.nextLine());
            if(scelta == 0) { return; }
            for (int i = 0; i < arr.length; i++) {
                if(i+1 == scelta) {
                    //System.out.println(arr[i]);
                    if(arr[i] != null) {
                        if(arr[i] instanceof ElementoRiproducibile) {
                            ElementoRiproducibile er = (ElementoRiproducibile) arr[i];
                            er.play();
                        } else if( arr[i] instanceof Immagine) {
                            Immagine img = (Immagine) arr[i];
                            img.show();
                        } else {
                            System.out.println("Elemento sconosciuto!!!");
                        }
                    } else {
                        System.out.println("Empty");
                    }
                }
            }

        } while (true);
    }

}
