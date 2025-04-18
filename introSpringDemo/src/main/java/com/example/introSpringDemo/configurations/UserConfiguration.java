package com.example.introSpringDemo.configurations;

import com.example.introSpringDemo.classes.User;
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

    @Value("${user.admin.firstname}") private String adminName;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.age}") private Integer adminAge;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean("adminUser")
    @Scope("singleton")
    public User createAdminUser() {
        return new User(adminName, adminLastname, adminCity, adminAge, adminEmail);
    }

    @Bean("customUser")
    @Scope("prototype")
    public User createCustomUser() {
        return new User();
    }

    @Bean("fakeUser")
    @Scope("prototype")
    public User createFakeUser() {
        Faker fake = new Faker(new Locale("it-IT"));
        return new User(
                fake.name().firstName(),
                fake.name().lastName(),
                fake.address().cityName(),
                fake.number().numberBetween(18,80),
                fake.internet().emailAddress());
    }

}
