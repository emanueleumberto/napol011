package org.example.esercizio.dao;

import com.github.javafaker.Faker;
import org.example.esercizio.entities.Prodotto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

public class ProdottoDAO {

    private static Logger log = LoggerFactory.getLogger(ProdottoDAO.class);
    private static Faker fake = new Faker(new Locale("it-IT"));
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void salvaProdotto(Prodotto prodotto) {
        em.getTransaction().begin();
        em.persist(prodotto);
        em.getTransaction().commit();
        log.info("Prodotto " + prodotto.getNome() + " salvato nel DB!");
    }

    public static Prodotto leggiProdotto(int id) {
        return em.find(Prodotto.class, id);
    }

    public static void eliminaProdotto(Prodotto prodotto) {
        em.getTransaction().begin();
        em.remove(prodotto);
        em.getTransaction().commit();
        log.info("Prodotto " + prodotto.getNome() + " eliminato dal DB!");
    }

    public static List<Prodotto> leggiTuttiProdotti() {
        Query q = em.createNamedQuery("Prodotto.findAll", Prodotto.class);
        return q.getResultList();
    }

    public static void popolaDB(int num) {
        for (int i = 0; i < num; i++) {
            String productName = fake.commerce().productName();
            String description = fake.lorem().paragraph();
            BigDecimal price = BigDecimal.valueOf(
                                    Double.parseDouble(
                                            fake.commerce()
                                                    .price()
                                                    .replace(",", ".")));
            int qt = fake.number().numberBetween(0,5);
            Prodotto p = new Prodotto(productName, description, price, qt);
            salvaProdotto(p);
        }
    }

}
