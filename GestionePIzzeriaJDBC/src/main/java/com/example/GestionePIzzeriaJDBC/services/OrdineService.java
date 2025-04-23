package com.example.GestionePIzzeriaJDBC.services;

import com.example.GestionePIzzeriaJDBC.models.Cliente;
import com.example.GestionePIzzeriaJDBC.models.Ordine;
import com.example.GestionePIzzeriaJDBC.models.Prodotto;
import com.example.GestionePIzzeriaJDBC.repositories.ClienteDAO;
import com.example.GestionePIzzeriaJDBC.repositories.OrdineDAO;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService {

    @Autowired ClienteDAO clienteDAO;
    @Autowired OrdineDAO ordineDAO;
    @Autowired @Qualifier("creaCliente") ObjectProvider<Cliente> clienteObjectProvider;
    @Autowired @Qualifier("creaClienteFake") ObjectProvider<Cliente> clienteFakeObjectProvider;
    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> ordineObjectProvider;

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = clienteObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public Cliente creaClienteFake() {
        return clienteFakeObjectProvider.getObject();
    }

    public Ordine creaOrdine(Cliente cliente, List<Prodotto> listaProdotti) {
        Ordine ordine = ordineObjectProvider.getObject();
        ordine.setCliente(cliente);
        ordine.setListaProdottiOrdinati(listaProdotti);
        ordine.setDataOrdine(LocalDate.now());
        ordine.setTotale(listaProdotti.stream().mapToDouble(Prodotto::getPrezzo).sum());
        return ordine;
    }

    public void salvaCliente(Cliente cliente) { clienteDAO.salvaCliente(cliente); }
    public Cliente leggiCliente(long id) { return clienteDAO.leggiCliente(id); }
    public void modificaCliente(Cliente cliente) { clienteDAO.modificaCliente(cliente); }
    public void eliminaCLiente(Cliente cliente) { clienteDAO.eliminaCliente(cliente); }
    public List<Cliente> leggiTuttiCliente() { return clienteDAO.leggiTuttiClienti(); }

    public void salvaOrdine(Ordine ordine) { ordineDAO.salvaOrdine(ordine); }
    public Ordine leggiOrdine(long numeroOrdine) {
        Ordine ordine = ordineDAO.leggiOrdine(numeroOrdine);
        ordine.setListaProdottiOrdinati(ordineDAO.leggiProdottiOrdine(numeroOrdine));
        return ordine;
    }
}
