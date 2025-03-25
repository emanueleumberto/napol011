import java.time.LocalDate;
import java.util.Scanner;

public class MainEsercizi {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Soluzione Esercizi");
        //int sum = somma();
        //int mol = moltiplica();
        //int sot = sottrai();
        //double div = dividi();

        //concatena(somma(), moltiplica(), sottrai(), dividi());

        //LocalDate now = LocalDate.now();
        //stampaMese(now);
        //stampaStagione(now);

        //String str = inserisciStringa();
        //System.out.println(str);

        //suddividiStringa("Ciao");

        //contoAllRovescia();

        //popolaArray();
    }

    // Esercizio 1
    public static int somma() {
        // somma -> Chiede ad un utente due numeri, li somma e ne restituisce il risultato
        System.out.print("Inbserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inbserisci un numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        return num1 + num2;
    }

    public static int moltiplica() {
        // moltiplica -> Chiede ad un utente due numeri, li moltiplica e ne restituisce il risultato
        System.out.print("Inbserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inbserisci un numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        return num1 * num2;
    }

    public static int sottrai() {
        // sottrai -> Chiede ad un utente due numeri, li sottrae e ne restituisce il risultato
        System.out.print("Inbserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inbserisci un numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        return num1 - num2;
    }

    public static double dividi() {
        // dividi -> Chiede ad un utente due numeri, li divide e ne restituisce il risultato
        System.out.print("Inbserisci un numero: ");
        double num1 = Double.parseDouble(sc.nextLine());
        System.out.print("Inbserisci un numero: ");
        double num2 = Double.parseDouble(sc.nextLine());
        if(num2 == 0) {
            return 0;
        } else {
            return num1 / num2;
        }
    }

    public static void concatena(int so, int mo, int st, double di) {
        // concatena  -> Prende in ingresso 4 valori (somma, moltiplica, sottrai, dividi) e stampa nel terminale
        //                    una stringa con tutti i valori calcolati dai metodi precedenti
        System.out.println("Risultati del calcoli precedenti: ");
        System.out.println("     - Somma: " + so);
        System.out.println("     - Differenza: " + st);
        System.out.println("     - Moltiplica: " + mo);
        System.out.println("     - Dividi: " + di);
    }

    // Esercizio 2
    public static boolean stringaPariDispari() {
        // Chiede ad un utente una stringa, ritorna true se il numero dei caratteri
        // è pari altrimenti deve ritornare false
        System.out.print("Inserisci una stringa: ");
        // Soluzione 1
        //return sc.nextLine().length() % 2 == 0;

        String str = sc.nextLine();
        // Soluzione 2
        //int len = str.length();
        //boolean b = len % 2 == 0;
        //return b;

        if(str.length() % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean annoBisestile() {
        //Per essere un anno bisestile deve essere divisibile per 4,
        //qualora sia divisibile per 100 deve essere anche divisibile per 400
        System.out.print("Inserisci un anno: ");
        int anno = Integer.parseInt(sc.nextLine());
        if(anno % 400 == 0) {
            return true;
        } else if(anno % 4 == 0 && anno % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void stampaMese(LocalDate obj) {
        // passare un oggetto di tipo LocalDate come paramentro del metodo e stampare a video
        // la data completa nel seguente formato (11 - Febbraio - 2025)
        int day = obj.getDayOfMonth();
        String month = obj.getMonth().toString();
        int year = obj.getYear();

        switch (month) {
            case "MARCH":
                month = "Marzo";
                break;
        }

        System.out.println(day + "-"+ month+"-"+year);

    }

    public static void stampaStagione(LocalDate obj) {
        // passare un oggetto di tipo LocalDate come paramentro del metodo e stampare a video
        // la stagione corrispondente
        switch (obj.getMonthValue()) {
            case 12, 1, 2 :
                System.out.println("Inverno");
                break;
            case 3,4,5:
                System.out.println("Primavera");
                break;
            case 6,7,8:
                System.out.println("Estate");
                break;
            case 9,10,11:
                System.out.println("Autunno");
                break;
            default:
                System.out.println("ERRORE");
                break;
        }
    }

    public static String inserisciStringa() {
        // Scrivere un metodo che chiede di inserire una stringa e ne controlla la lunghezza.
        // deve ripetere la richiesta di inserimento della stringa fin quando la lunghezza
        // non è almeno di 5 caratteri. Infine si deve ritornare la stringa inserita.
        String str;
        do {
            System.out.print("Inserisci una stringa: ");
             str = sc.nextLine();
        } while (str.length() < 5);
        return str;
    }

    public static void suddividiStringa(String str) {
        // Scrivere un metodo che riceve come paramentro una stringa, si deve suddividere
        // in caratteri separati da una virgola e stampare a video.  ("s,t,r,i,n,g,a")

        //String[] strSplit = str.split("");

        // 0->c 1->i 2->a 3->o
        int i=0;
        String testo = ""; //c,i,a,o
        while (i < str.length()) {
            if(i == str.length()-1) {
                testo += str.charAt(i);
            } else {
                testo += str.charAt(i) + ",";
            }
            i++;
        }
        System.out.println(testo);
    }

    public static void contoAllRovescia() {
        // Scrivere un metodo che chiede di inserire un numero e stampi il conto alla rovescia
        // da quel numero fino a zero.
        System.out.print("Inbserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        for(int i=num1; i>=0; i--) {
            System.out.println(i + " -> " + num1);
        }
    }

    public static void popolaArray() {
        // Scrivere un metodo che chiede di inserire la lunghezza di un array, in base al
        // valore fornito dall'utente creare un array di Stringhe e popolarlo con il metodo
        // inserisciStringa creato in precedenza. Infine stampare le stringhe contenute
        // nell'array tramite il metodo suddividiStringa.
        System.out.print("Inserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        String[] arr = new String[num1];
        // Popolo il mio array con le stringhe inserite nel metodo inserisciStringa()
        for(int i=0; i<arr.length; i++) {
            arr[i] = inserisciStringa();
        }
        // stampo i valori dell'array tramite il metodo suddividiStringa()
        for(int i=0; i<arr.length; i++) {
            suddividiStringa(arr[i]);
        }

    }
}
