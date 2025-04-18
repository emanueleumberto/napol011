package com.example.IntroSpring.configurations;

import com.example.IntroSpring.classes.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.name}") private String adminName;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.age}") private Integer adminAge;

    @Bean
    @Scope("singleton")
    public User adminUser() {
        return new User(adminName, adminLastname, adminCity, adminAge);
    }

    @Bean
    @Scope("prototype")
    public User customUser(String firstname, String lastname, String city, Integer age) {
        return new User(firstname, lastname, city, age);
    }

}
