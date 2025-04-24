package com.example.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "veicoli")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veicolo", discriminatorType = DiscriminatorType.STRING)
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modello;
    @Column(nullable = false, unique = true)
    private String targa;

    // Gestisco l'ereditarietà tra classi in JPA
    // -> SINGLE_TABLE
    //      @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    //      @DiscriminatorColumn(name = "tipo_veicolo", discriminatorType = DiscriminatorType.STRING)
    // -> TABLE_PER_CLASS
    //      @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    // -> JOINED
    //      @Inheritance(strategy = InheritanceType.JOINED)


}
