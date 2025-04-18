package com.example.introSpringDemo.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String firstname;
    private String lastname;
    private String city;
    private Integer age;
    private String email;

}
