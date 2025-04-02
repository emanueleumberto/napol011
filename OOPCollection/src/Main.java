import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Collections
        // Contenitori dinamici di elementi. A differenza degli array che hanno una dimensione fissa
        // Una collection può essere ordinata o non ordinata, può ammettere dei duplicati o no.
        // L'interfaccia Collection non specifica nulla di quanto detto sopra (valori ordinato e/o duplicati).
        // Collection
        //    Non memorizza l'ordine in cui sono stati inseriti i dati, non definisce se ci possono essere valori duplicati
        //    Non può contenere valori primitivi, ma solo oggetti. Se ho bisogno di utilizzare dati primitivi sono costretto
        //    utilizzare classi Wrapper(Integer, Double, Char, Boolean)
        //      -> List
        //          Gli elementi sono indicizzati può contenere duplicati
        //          I valori inseriti sono memorizzati in base all'ordine di inserimento.
        //          Consente di leggere, aggiungere, rimuovere e modificare gli elementi in base ad un indice
        //          -> La classe principale che implementa List è ArrayList
        //      -> Set
        //          Non ammettono dulicati ma gli elementi non sono indicizzati
        //          I valori inseriti NON sono memorizzati in base all'ordine di inserimento.
        //          -> La classe principale che implementa Set è HashSet
        //       -> SortedSet
        //              Non ammettono dulicati, ma a differenza da Set gli elementi sono indicizzati
        //              I valori inseriti NON sono memorizzati in base all'ordine di inserimento.
        //              -> La classe principale che implementa SortedSet è TreeSet
        //      -> Queue
        //          Crea una coda che ha dei metodi per leggere, inserire ed eliminare elementi ad inizio e fine della lista
        //          -> La classe principale che implementa Queue è LinkedList
        // Map
        //    Definisce una funzione composta da chiave/valore. Non può contenere valori primitivi.
        //    Se ho bisogno di utilizzare dati primitivi sono costretto utilizzare classi Wrapper(Integer, Double, Char, Boolean)
        //    Una chiave sarà un valore univoco della mappa che servirà per poter accedere al valore associato
        //    I valori inseriti NON sono memorizzati in base all'ordine di inserimento.
        //    -> La classe principale che implementa Map è HashMap
        //      -> SortedMap
        //          Fornisce un ordine sulle chiavi
        //          -> La classe principale che implementa SortedMap è TreeMap


        //testCollection();
        //testList();
        //testSet();
        //testQueue();
        testMap();

    }

    public static void testCollection() {
        Collection<String> c = new ArrayList<String>();
        c.add("Primo Elemento");
        c.add("Secondo Elemento");
        c.add("Terzo Elemento");

        boolean cont = c.contains("Secondo Elemento");
        System.out.println("Contains element 'Secondo Elemento': " + cont);

        boolean isEmp = c.isEmpty();
        System.out.println("Collection isEmpy?: " + isEmp);

        int size = c.size();
        System.out.println("Collection size: " + size);

        c.remove("Secondo Elemento");

        for (String str : c) {
            System.out.println(str);
        }

        c.clear();
        isEmp = c.isEmpty();
        System.out.println("Collection isEmpy?: " + isEmp);

    }

    public static void testList() {
        List<String> l = new ArrayList<String>();
        l.add("Primo Elemento");
        l.add("Secondo Elemento");
        l.add("Terzo Elemento");
        l.add("Secondo Elemento");

        boolean cont = l.contains("Secondo Elemento");
        System.out.println("Contains element 'Secondo Elemento': " + cont);

        boolean isEmp = l.isEmpty();
        System.out.println("List isEmpy?: " + isEmp);

        int size = l.size();
        System.out.println("List size: " + size);

        String ele = l.get(1);
        System.out.println("Element index 1: " + ele);

        //l.set(1,"Nuovo Elemento");

        int index = l.indexOf("Secondo Elemento"); // Restituisce l'indice dell'elemento cercato o -1 se non lo trova
        System.out.println("Index Element 'Secondo Elemento': " + index);

        //l.remove("Secondo Elemento");

        for (String str : l) {
            System.out.println(str);
        }

        l.clear();
        isEmp = l.isEmpty();
        System.out.println("List isEmpy?: " + isEmp);

    }

    public static void testSet() {
        //Set<String> s = new HashSet<String>();
        SortedSet<String> s = new TreeSet<String>();
        s.add("Primo Elemento");
        s.add("Secondo Elemento");
        s.add("Terzo Elemento");
        s.add("Secondo Elemento"); // Valore duplicato | Non è stato inserito
        
        //add() ->  restituisce true se il valore è stato inserito correttamente nel set
        //          restituisce false se il valore è duplicato e quindi non è stato inserito
        if(s.add("Quarto Elemento")) {
            System.out.println("Valore inserito nel set");
        } else {
            System.out.println("Valore duplicato");
        }

        boolean cont = s.contains("Secondo Elemento");
        System.out.println("Contains element 'Secondo Elemento': " + cont);

        boolean isEmp = s.isEmpty();
        System.out.println("Collection isEmpy?: " + isEmp);

        int size = s.size();
        System.out.println("Collection size: " + size);

        //s.remove("Secondo Elemento");

        for (String str : s) {
            System.out.println(str);
        }

        //s.clear();
        //isEmp = s.isEmpty();
        //System.out.println("Collection isEmpy?: " + isEmp);

        // Metodi di SortedSet
        String s1 = s.first();
        System.out.println("First Element: " + s1);
        String l1 = s.last();
        System.out.println("Last Element: " + l1);


    }

    public static void testQueue() {
        Queue<String> q = new LinkedList<String>();
        q.add("Primo Elemento");
        q.add("Secondo Elemento");
        q.add("Terzo Elemento");
        q.add("Quarto Elemento");
        q.add("Quinto Elemento");

        boolean cont = q.contains("Secondo Elemento");
        System.out.println("Contains element 'Secondo Elemento': " + cont);

        boolean isEmp = q.isEmpty();
        System.out.println("Collection isEmpy?: " + isEmp);

        int size = q.size();
        System.out.println("Collection size: " + size);

        q.remove("Secondo Elemento");

        String getFirst = q.peek(); // Legge il primo elemento della coda
        System.out.println("First Element Peek: " + getFirst);

        String first = q.poll(); // Legge e rimuove il primo elemento della coda
        System.out.println("First Element Pool: " + first);

        for (String str : q) {
            System.out.println(str);
        }

        /*q.clear();
        isEmp = q.isEmpty();
        System.out.println("Collection isEmpy?: " + isEmp);*/

    }

    public static void testMap() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("A", "Primo Elemento");
        m.put("B", "Secondo Elemento");
        m.put("C", "Terzo Elemento");

        boolean key = m.containsKey("B");
        System.out.println("Contains Key 'B': " + key);

        boolean val = m.containsValue("Primo Elemento");
        System.out.println("Contains value 'Primo Elemento': " + val);

        String ele = m.get("C");
        System.out.println("Element key 'C': " + ele);

        int size = m.size();
        System.out.println("Map size: " + size);

        boolean isEmp = m.isEmpty();
        System.out.println("Map isEmpy?: " + isEmp);

        Set<String> keys = m.keySet();
        for (String k : keys) {
            System.out.println(k + " -> " + m.get(k));
        }

        System.out.println("****************************");

        Collection<String> values =  m.values();
        for (String v : values) {
            System.out.println(v);
        }

        m.clear();
        isEmp = m.isEmpty();
        System.out.println("MAp isEmpy?: " + isEmp);

    }
}