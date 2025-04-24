package com.example.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    // Solo se voglio una relazione bidirezionale
    @OneToMany(mappedBy = "company")
    private List<User> employees;

    public Company(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<User>();
    }

}
