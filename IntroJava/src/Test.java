public class Test {
    // Membri della classe

    // Attributi o proprietà di istanza
    // Scope globale o di classe
    public String nome = "Mario";
    public String tipo = "Utente";

    // Metodi di istanza
    public void start() {
        // Scope di Metodo
        String abc = "----";
        System.out.println(nome);
        System.out.println(abc);
        if(true) {
            // Scope di blocco
            String t = "Ciao";
            System.out.println(nome);
            System.out.println(abc);
            System.out.println(t);
        }
        // System.out.println(t); -> Errore siamo fuori dal blocco
    }

    public void stop() {
        System.out.println(nome);
        // System.out.println(abc);  -> Errore siamo fuori dal metodo start
    }


}
