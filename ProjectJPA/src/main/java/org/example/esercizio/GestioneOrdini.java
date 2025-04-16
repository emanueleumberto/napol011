package org.example.esercizio;

import org.example.esercizio.dao.ClienteDAO;
import org.example.esercizio.dao.OrdineDAO;
import org.example.esercizio.dao.ProdottoDAO;
import org.example.esercizio.entities.Cliente;
import org.example.esercizio.entities.DettaglioOrdine;
import org.example.esercizio.entities.Ordine;
import org.example.esercizio.entities.Prodotto;

public class GestioneOrdini {

    public static void main(String[] args) {
        System.out.println("*********** Gestione Ordini ***********");

        if(ClienteDAO.leggiTuttiClienti().size() == 0) { ClienteDAO.popolaDB(10); }
        if(ProdottoDAO.leggiTuttiProdotti().size() == 0) { ProdottoDAO.popolaDB(10); }
        if(OrdineDAO.leggiTuttiOrdini().size() == 0) { OrdineDAO.popolaDB(3); }

        System.out.println("Clienti n." + ClienteDAO.leggiTuttiClienti().size());
        System.out.println("Prodotti n." + ProdottoDAO.leggiTuttiProdotti().size());
        System.out.println("Ordini n." + OrdineDAO.leggiTuttiOrdini().size());

        //Cliente cliente = ClienteDAO.leggiCliente(4);
        //System.out.println(cliente);
        //cliente.setEmail("t.damico@example.com");
        //ClienteDAO.salvaCliente(cliente);
        //ClienteDAO.eliminaCliente(cliente);

        //Prodotto prodotto = ProdottoDAO.leggiProdotto(8);
        //System.out.println(prodotto);
        //prodotto.setQuantitaDisponibile(3);
        //ProdottoDAO.salvaProdotto(prodotto);
        //ProdottoDAO.eliminaProdotto(prodotto);

        //Ordine ordine = OrdineDAO.leggiOrdine(1);
        //DettaglioOrdine dettaglio = new DettaglioOrdine(1, ordine, ProdottoDAO.leggiProdotto(1));
        //OrdineDAO.salvaDettaglioOrdine(dettaglio);
        //System.out.println(ordine);
        //OrdineDAO.eliminaOrdine(ordine);

    }
}
