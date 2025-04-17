package com.example.IntroSpring.configurations;

import com.example.IntroSpring.classes.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserConfiguration {

    @Bean
    @Scope("singleton")
    public User adminUser() {

        return new User("Mario", "Rossi", "Roma", 45);
    }

    @Bean
    @Scope("prototype")
    public User customUser(String firstname, String lastname, String city, Integer age) {
        return new User(firstname, lastname, city, age);
    }

}
