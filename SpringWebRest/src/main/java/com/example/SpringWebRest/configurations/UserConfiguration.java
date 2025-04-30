package com.example.SpringWebRest.configurations;

import com.example.SpringWebRest.models.User;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class UserConfiguration {

    @Bean
    @Scope("prototype")
    public User createUser() {
        return new User();
    }

    @Bean
    @Scope("prototype")
    public User createFakeUser() {
        Faker fake = new Faker(new Locale("it-IT"));
        return User.builder()
                .firstname(fake.name().firstName())
                .lastname(fake.name().lastName())
                .city(fake.address().cityName())
                .age(fake.number().numberBetween(18,80))
                .email(fake.internet().emailAddress())
                .password(fake.internet().password())
                .build();
    }

}
