package com.example.GestionePizzeriaJPA.services;

import com.example.GestionePizzeriaJPA.model.Cliente;
import com.example.GestionePizzeriaJPA.repositories.ClienteDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClientiService {

    @Autowired @Qualifier("creaCliente") ObjectProvider<Cliente> clienteObjectProvider;
    @Autowired @Qualifier("creaClienteFake") ObjectProvider<Cliente> clienteFakeObjectProvider;
    @Autowired ClienteDAORepository db;

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = clienteObjectProvider.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public Cliente creaClienteFake() {
        return clienteFakeObjectProvider.getObject();
    }

    public void salvaCliente(Cliente cliente) {
        db.save(cliente);
        System.out.println("Cliente " + cliente.getNome() + " salvato nel DB!");
    }

    public Cliente leggiCliente(long id) {
        return db.findById(id).get();
    }

}
