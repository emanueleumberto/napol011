package com.example.GestionePIzzeriaJDBC.repositories;

import com.example.GestionePIzzeriaJDBC.models.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAORepository {

    // CRUD Menu
    public void salvaMenu(Menu menu);
    public Menu leggiMenu(long id);
    public void modificaMenu(Menu menu);
    public void eliminaMenu(Menu menu);

}
