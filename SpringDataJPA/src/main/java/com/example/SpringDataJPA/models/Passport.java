package com.example.SpringDataJPA.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id", nullable = false)
    private Long id;

    @Column(name = "number_passport" ,nullable = false, unique = true)
    private Integer numberPassport;

    @Column(name="date_passport", nullable = false)
    private LocalDate datePassport;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Passport(Integer numberPassport, LocalDate datePassport, User user) {
        this.numberPassport = numberPassport;
        this.datePassport = datePassport;
        this.user = user;
    }

}
