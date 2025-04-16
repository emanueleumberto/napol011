package org.example.esercizio.dao;

import com.github.javafaker.Faker;
import org.example.esercizio.entities.Cliente;
import org.example.esercizio.entities.DettaglioOrdine;
import org.example.esercizio.entities.Ordine;
import org.example.esercizio.entities.Prodotto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

public class OrdineDAO {

    private static Logger log = LoggerFactory.getLogger(OrdineDAO.class);
    private static Faker fake = new Faker(new Locale("it-IT"));
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static Ordine salvaOrdine(Ordine ordine) {
        em.getTransaction().begin();
        em.persist(ordine);
        em.getTransaction().commit();
        log.info("Ordine " + ordine.getId_ordine() + " salvato nel DB!");
        return ordine;
    }

    public static Ordine leggiOrdine(int id) {
        return em.find(Ordine.class, id);
    }

    public static void eliminaOrdine(Ordine ordine) {
        em.getTransaction().begin();
        em.remove(ordine);
        em.getTransaction().commit();
        log.info("Ordine " + ordine.getId_ordine() + " eliminato dal DB!");
    }

    public static List<Ordine> leggiTuttiOrdini() {
        Query q = em.createNamedQuery("Ordine.findAll", Ordine.class);
        return q.getResultList();
    }

    public static void salvaDettaglioOrdine(DettaglioOrdine dettaglio) {
        em.getTransaction().begin();
        em.persist(dettaglio);
        em.getTransaction().commit();
        log.info("Dettaglio Ordine " + dettaglio.getId_dettaglio_ordine() + " salvato nel DB!");
    }

    public static void popolaDB(int num) {
        List<Cliente> listaClienti = ClienteDAO.leggiTuttiClienti();
        List<Prodotto> listaProdotti = ProdottoDAO.leggiTuttiProdotti();
        for (int i = 0; i < num; i++) {
            Cliente cliente = listaClienti.get(fake.number().numberBetween(0, listaClienti.size()-1));
            Ordine ordine = salvaOrdine(new Ordine(cliente));
            int numProdotti = fake.number().numberBetween(1,5);
            for (int j = 0; j < numProdotti; j++) {
                Integer quantita = fake.number().numberBetween(1,3);
                Prodotto prodotto = listaProdotti.get(fake.number().numberBetween(0, listaProdotti.size()-1));
                if(prodotto.getQuantitaDisponibile()>quantita) {
                    DettaglioOrdine d = new DettaglioOrdine(quantita, ordine, prodotto);
                    prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile()-quantita);
                    salvaDettaglioOrdine(d);
                } else {
                    log.warn("Prodotto " + prodotto.getNome() + " quantità non disponibile!");
                    j--;
                }
            }
        }
    }

}
