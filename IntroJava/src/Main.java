import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // commento a linea singola
        // ctrl + / -> Commento a singola linea

        /*
            Commento
            multi
            linea
         */
        // ctrl + shift + / -> Commento multilinea

        /**
         *
         * Commento con notazione JavaDOC
         *
         */


        System.out.println("Ciao a tutti");

        // Classi -> Pascal-case -> Prima lettera Maiuscola e poi ogni ulteriore parola maiuscola (IntroJava)
        // Interfacce -> Pascal-case -> Prima lettera Maiuscola e poi ogni ulteriore parola maiuscola (IntroJava)
        // Metodi -> Camel-case -> Prima lettera minuscola e poi ogni ulteriore parola maiuscola (introJava)
        // Variabili -> Camel-case -> Prima lettera minuscola e poi ogni ulteriore parola maiuscola (introJava)
        // Package -> Snake-case -> Prima lettera minuscola e ogni ulteriore parola collegata con un underscore (intro_java)
        // Costanti -> Snake-case -> Tutto maiuscolo e ogni ulteriore parola collegata con un underscore (INTRO_JAVA)

        // Tipi di dato primitivi
        // boolean  -> 1 bit
        // char     -> 16 bit
        // byte     -> 8 bit
        // short    -> 16 bit
        // int      -> 32 bit
        // long     -> 64 bit
        // float    -> 32 bit
        // double   -> 64 bit

        // Una variabile è una locazione di memoria in grado di memorizzare un dato
        // tipo nome = valore

        boolean b = true;
        char c = 'c';
        short sh = 25;
        int i = 25;
        long l = 25;
        double f = 5.2;

        int x, y, z;
        x = 1;
        y = 2;
        z = 3;

        // Definire una costante in java
        final int CONST = 25;

        // Tipo di dato String
        String s = new String("Ciao");
        String str = "Ciao";
        String numStr = "25";

        int num1 = sh; // Conversione Implicita short -> int
        int num2 = (int) l;  // Conversione Esplicita long -> int
        System.out.println(num1);
        System.out.println(num2);

        int num3 = (int) f; // Conversione esplicita double -> int
        int num4 = c; // Conversione implicita char -> int
        //int num5 = (int) b; // Errore boolean -> int
        int num6 = Integer.parseInt(numStr); // Parse tra dati di tipo String e int
        double num7 = Double.parseDouble(numStr); // Parse tra dati di tipo String e double

        // Array -> un tipo di dato che aggrega più valori dello stesso tipo
        String[] strs = new String[5]; // 0 - 1 - 2 - 3 - 4
        strs[0] = "uno";
        strs[1] = "due";
        strs[2] = "tre";

        System.out.println(strs[1]);

        int[] nums = {1, 2, 3, 4, 5};
        nums[4] = 10;

        System.out.println(nums[1]);

        // Operatore di assegnameto
        // =

        // Operatori aritmetici
        // + - * / %

        int n1 = 10;
        int n2 = 3;
        System.out.println(n1 / n2);
        System.out.println(n1 % n2);

        double r = (double) n1 / n2;
        System.out.println(r);

        // Operatori aritmetici di assegnamento
        // += -= *= /= %=
        int z1 = 10;
        z1 = z1 + 2;
        z1 += 2;

        // Operatore unario di pre o post incremento e pre o post decremento

        z1 = z1 + 1;
        z1 += 1;
        z1++;
        z1--;

        int yz = 25;
        // int zx = yz++; // 26 | 25 -> prima assegna e poi incrementa
        int zx = ++yz; // 26 | 26 -> prima incrementa e poi assegna
        System.out.println(yz + " | " + zx);

        // Operatori relazionali
        // == != > < >= <= Operatori relazione che restituiscono un valore booleano (true | false)

        // Operatori logici
        // && || ! ^

        /*

            condizione1 && condizione2 --> true && true --> true
            condizione1 && condizione2 --> true && false --> false
            condizione1 && condizione2 --> false && true --> false
            condizione1 && condizione2 --> false && false --> false

            condizione1 || condizione2 --> true || true --> true
            condizione1 || condizione2 --> true || false --> true
            condizione1 || condizione2 --> false || true --> true
            condizione1 || condizione2 --> false || false --> false

            condizione1 ^ condizione2 --> true || true --> false
            condizione1 ^ condizione2 --> true || false --> true
            condizione1 ^ condizione2 --> false || true --> true
            condizione1 ^ condizione2 --> false || false --> false

            !true --> false
            !false --> true

        */

        // Scanner -> per interagire con l'utente è possibile utilizzare un oggetto
        // in grado di richiere dati tramite terminale

        Scanner sc = new Scanner(System.in);
        //System.out.println("Inserisci il tuo nome");
        //String nome = sc.nextLine();
        //System.out.println("Inserisci la tua età");
        //int eta = sc.nextInt();
        //sc.nextLine();
        //int eta = Integer.parseInt(sc.nextLine());
        //System.out.println("Inserisci la città di nascita");
        //String citta = sc.nextLine();
        //System.out.println("Ciao " + nome + " anni: " + eta + " città: " + citta);

        // Metodo di una classe
        // modificatore tipoDiRitorno nomeMetodo(tipoParametro nomeParamentro) {
        // blocco di istruzioni }

        //somma1(); // eseguo il metodo con nome somma()
        somma2(10, 15);
        int res = somma3(10, 15);
        System.out.println(res);

    }

    public static void somma1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int x1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int x2 = Integer.parseInt(sc.nextLine());
        int result = x1 + x2;
        System.out.println("Il risultato della somma tra " + x1 + " e " + x2 + " è " + result);
    }

    public static void somma2(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("Il risultato della somma tra " + num1 + " e " + num2 + " è " + result);
    }

    public static int somma3(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

}