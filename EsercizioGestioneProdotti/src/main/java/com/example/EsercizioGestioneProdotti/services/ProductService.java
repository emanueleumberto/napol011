package com.example.EsercizioGestioneProdotti.services;

import com.example.EsercizioGestioneProdotti.models.Product;

import java.util.List;

public interface ProductService {

    public Product createFakeProduct();
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product saveProduct(Product product);
    public Product updatePutProduct(Long id, Product product);
    public Product updatePatchProduct(Long id, Product product);
    public void deleteProduct(Long id);

}
