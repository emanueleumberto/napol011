package com.example.GestionePizzeriaJPA.repositories;

import com.example.GestionePizzeriaJPA.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDAORepository extends JpaRepository<Menu, Long> {
}
