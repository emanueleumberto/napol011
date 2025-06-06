package com.example.IntroSpring.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String city;
    private Integer age;

    public User(String firstname, String lastname, String city, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }
}
