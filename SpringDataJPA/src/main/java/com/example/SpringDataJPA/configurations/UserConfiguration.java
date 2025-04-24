package com.example.SpringDataJPA.configurations;

import com.example.SpringDataJPA.models.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.firstname}") private String adminFirstname;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.age}") private Integer adminAge;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean("customUser")
    @Scope("prototype")
    public User createCustomUser() {
        return new User();
    }

    @Bean("fakeUser")
    @Scope("prototype")
    public User createFakeUser() {
        Faker fake = new Faker(new Locale("it-IT"));
        return User.builder()
                .firstname(fake.name().firstName())
                .lastname(fake.name().lastName())
                .age(fake.number().numberBetween(18,80))
                .email(fake.internet().emailAddress())
                .build();
    }

    @Bean("adminUser")
    @Scope("singleton")
    public User createAdminUser() {
        return User.builder()
                .firstname(adminFirstname)
                .lastname(adminLastname)
                .age(adminAge)
                .email(adminEmail)
                .build();
    }

}
