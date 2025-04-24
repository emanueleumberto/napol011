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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(nullable = true)
    private Integer hour;

    // Solo se voglio una relazione bidirezionale
    @ManyToMany(mappedBy = "courses")
    private List<User> userList;

    public Course(String courseName, Integer hour) {
        this.courseName = courseName;
        this.hour = hour;
        this.userList = new ArrayList<User>();
    }

}
