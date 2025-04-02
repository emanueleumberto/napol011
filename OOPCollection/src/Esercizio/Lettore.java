package Esercizio;

public class Lettore {

    private static int count = 1;
    private int id;
    private String nome;
    private String email;

    public Lettore(String nome, String email) {
        this.id = count++;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Lettore " + "id=" + id + ", nome='" + nome + ", email='" + email;
    }
}
