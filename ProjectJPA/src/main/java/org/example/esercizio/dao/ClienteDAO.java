package org.example.esercizio.dao;

import com.github.javafaker.Faker;
import org.example.esercizio.entities.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

public class ClienteDAO {

    private static Logger log = LoggerFactory.getLogger(ClienteDAO.class);
    private static Faker fake = new Faker(new Locale("it-IT"));
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void salvaCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        log.info("Cliente " + cliente.getNome() + " " + cliente.getCognome() + " salvato nel DB!");
    }

    public static Cliente leggiCliente(int id) {
        return em.find(Cliente.class, id);
    }

    public static void eliminaCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        log.info("Cliente " + cliente.getNome() + " " + cliente.getCognome() + " eliminato dal DB!");
    }

    public static List<Cliente> leggiTuttiClienti() {
        Query q = em.createNamedQuery("Cliente.findAll", Cliente.class);
        return q.getResultList();
    }

    public static void popolaDB(int num) {
        for (int i = 0; i < num; i++) {
            String firstname = fake.name().firstName();
            String lastname = fake.name().lastName();
            String email = firstname.toLowerCase().charAt(0) + "." + lastname.toLowerCase().replace(" ", "").replace("'", "") + "@example.com";
            String phone = fake.phoneNumber().cellPhone();
            Cliente c = new Cliente(firstname, lastname, email, phone);
            salvaCliente(c);
        }
    }
}
