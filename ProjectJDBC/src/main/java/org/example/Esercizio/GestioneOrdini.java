package org.example.Esercizio;

import com.github.javafaker.Faker;
import org.example.Esercizio.dao.ClienteDAO;
import org.example.Esercizio.dao.OrdineDAO;
import org.example.Esercizio.dao.ProdottoDAO;
import org.example.Esercizio.entities.Cliente;
import org.example.Esercizio.entities.Ordine;
import org.example.Esercizio.entities.Prodotto;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class GestioneOrdini {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static ProdottoDAO prodottoDAO = new ProdottoDAO();
    private static OrdineDAO ordineDAO = new OrdineDAO();

    public static void main(String[] args) {

        try {
            //DBConnection db = new DBConnection();
            //DBConnection.getInstance();

            if(clienteDAO.leggiTuttiClienti().size() == 0) {
                generaClienti(10);
            }
            if(prodottoDAO.leggiTuttiProdotto().size() == 0) {
                generaProdotti(10);
            }


            // CRUD Clienti
            // clienteDAO.salvaCliente(c)


            //Cliente c = clienteDAO.leggiCliente(3);
            //System.out.println(c);

            //c.setTelefono("+39 987.654.321");
            //clienteDAO.modificaCliente(c);

            //clienteDAO.eliminaCliente(c);

            //List<Cliente> listaClienti = clienteDAO.leggiTuttiClienti();
            //listaClienti.forEach(System.out::println);

            // CRUD Prodotti
            //Prodotto p = new Prodotto("Iphone", "Smartphone bellissimo!!", 899.99, 5);
            //prodottoDAO.salvaProdotto(p);

            //Prodotto p = prodottoDAO.leggiProdotto(6);
            //System.out.println(p);

            //p.setQuantitaDisponibile(9);
            //prodottoDAO.modificaProdotto(p);

            //prodottoDAO.eliminaProdotto(p);

            //prodottoDAO.leggiTuttiProdotto().forEach(System.out::println);


            //CRUD Ordine
            //Cliente c = clienteDAO.leggiCliente(4);
            //Prodotto p = prodottoDAO.leggiProdotto(8);
            //Ordine o = new Ordine(c, p, 1);
            //ordineDAO.creaOrdine(o);

            Ordine o = ordineDAO.leggiOrdine(1);
            System.out.println(o);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }




//        Prodotto p = new Prodotto("Iphone", "Smartphone di nuova generazione.", 899.99, 3);
//        System.out.println(p);
//
//        Ordine o = new Ordine(c, p, 1);
//        System.out.println(o);



    }

    public static void generaClienti(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            String firstname = fake.name().firstName();
            String lastname = fake.name().lastName();
            String email = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@example.com";
            String phone = fake.phoneNumber().cellPhone();
            Cliente c = new Cliente(firstname, lastname, email, phone);
            clienteDAO.salvaCliente(c);
        }
    }

    public static void generaProdotti(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            String nome = fake.commerce().productName();
            String descrizione = fake.commerce().productName() + " - " + fake.lorem().paragraph();
            double prezzo = fake.number().randomDouble(2, 10, 1000);
            int qt = fake.number().numberBetween(0,5);
            Prodotto p = new Prodotto(nome, descrizione, prezzo, qt);
            prodottoDAO.salvaProdotto(p);
        }
    }

}
