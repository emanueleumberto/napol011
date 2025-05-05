package com.example.EsercizioGestioneProdotti.services;

import com.example.EsercizioGestioneProdotti.models.Product;
import com.example.EsercizioGestioneProdotti.repositories.ProductRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired @Qualifier("createFakeProduct") ObjectProvider<Product> productFakeObjectProvider;
    @Autowired @Qualifier("createProduct") ObjectProvider<Product> productObjectProvider;
    @Autowired ProductRepository productRepository;

    @Override
    public Product createFakeProduct() {
        return productFakeObjectProvider.getObject();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updatePutProduct(Long id, Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updatePatchProduct(Long id, Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
