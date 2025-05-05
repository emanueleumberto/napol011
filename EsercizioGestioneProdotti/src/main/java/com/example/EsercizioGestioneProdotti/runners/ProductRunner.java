package com.example.EsercizioGestioneProdotti.runners;

import com.example.EsercizioGestioneProdotti.models.Product;
import com.example.EsercizioGestioneProdotti.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner implements CommandLineRunner {

    @Autowired ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ProductRunner...");

        if(productService.getAllProducts().size() == 0) {
            for (int i = 0; i < 10; i++) {
                Product p = productService.createFakeProduct();
                productService.saveProduct(p);
            }
            System.out.println("Database created");
        } else {
            System.out.println("Database completed");
        }
    }
}
