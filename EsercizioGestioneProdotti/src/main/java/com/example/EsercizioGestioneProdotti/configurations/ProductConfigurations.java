package com.example.EsercizioGestioneProdotti.configurations;

import com.example.EsercizioGestioneProdotti.models.Product;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;

@Configuration
public class ProductConfigurations {

    @Bean
    @Scope("prototype")
    public Product createProduct() {
        return new Product();
    }

    @Bean
    @Scope("prototype")
    public Product createFakeProduct() {
        Faker fake = new Faker(new Locale("it-IT"));
        return Product.builder()
                .name(fake.commerce().productName())
                .price(new BigDecimal(fake.commerce().price().replace(",", ".")))
                .description(fake.lorem().paragraph())
                .createdAt(LocalDateTime.now())
                .build();
    }

}
