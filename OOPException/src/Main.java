import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            Integer[] resDiv = calcolaDivisione();
            System.out.println(resDiv.length);
        } catch (NullPointerException e) {
            //System.out.println("Valore null!!!");
            System.err.println(e.getMessage());
        } catch (CustomException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            //System.out.println("Sono la gestione delle eccezioni propagata fino al main");
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Blocco try/catch terminato!!");
        }


        System.out.println("FINE");
    }

    public static Integer[] calcolaDivisione() throws CustomException {
        int c = 0;
        Integer[] arr = new Integer[5];
        //arr[8] = 25;
        do {
            try {
                System.out.print("Inserisci un numero: ");
                int x = Integer.parseInt(sc.nextLine());
                System.out.print("Inserisci un numero: ");
                int y = Integer.parseInt(sc.nextLine());
                int div = x / y;
                //System.out.println("Il risultato è: " + div);
                arr[c] = div;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                //System.out.println("Valori errati, inserisci dei numeri");
                System.out.println(e.getMessage());
                c--;
            } catch (ArithmeticException e) {
                //System.out.println("Non è possibile effettuare una divisione per 0");
                System.out.println(e.getMessage());
                c--;
            } catch (Exception e) {
                //System.out.println("Errore!!!");
                System.out.println(e.getMessage());
                c--;
            }

            c++;
        } while (c<3);
        stampaArray(arr);
        /*try {
            stampaArray(arr);
        } catch (NullPointerException e) {
            System.out.println("Valore null!!!");
        }*/

        return arr;
    }

    public static void stampaArray(Integer[] arr) throws CustomException {

        for (int i = 0; i < arr.length; i++) {

            if(i == 3) {
                // Lancia una eccezione custom
                /*try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Indice i = 3");
                }*/
                throw new CustomException("Sono una Custom Exception!!!");
            }

            System.out.println("Valore " + (i + 1) + ": " + arr[i].toString());
        }

       /* try {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Valore " + (i + 1) + ": " + arr[i].toString());
            }
        } catch (NullPointerException e) {
            System.out.println("Valore null!!!");
        }*/
    }

}