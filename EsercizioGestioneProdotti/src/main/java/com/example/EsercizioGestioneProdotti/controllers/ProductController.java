package com.example.EsercizioGestioneProdotti.controllers;

import com.example.EsercizioGestioneProdotti.models.Product;
import com.example.EsercizioGestioneProdotti.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        // GET /products → restituisce tutti i prodotti.
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        // GET /products/{id} → restituisce un prodotto specifico.
        /*try {
            return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        //return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        // POST /products → aggiunge un nuovo prodotto.
        /*try {
            return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }*/
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePutProduct(@PathVariable Long id, @RequestBody Product product) {
        // PUT /products/{id} → aggiorna un prodotto.
        if(productService.getProductById(id).getId() == product.getId()){
            //return new ResponseEntity<Product>(productService.updatePutProduct(id,product), HttpStatus.OK);
            return ResponseEntity.ok(productService.updatePutProduct(id,product));
        } else {
            //return new ResponseEntity<String>("Product id not found!", HttpStatus.NOT_FOUND);
            return ResponseEntity.badRequest().body("Product id not found!");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchProduct(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        // PATCH /products/{id} → aggiorna un prodotto.
        /*try {
            Product product = productService.getProductById(id);
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Product.class, key);
                if(field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, product, value);
                }
            });
            return new ResponseEntity<Product>(productService.updatePatchProduct(id, product), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/

        Product product = productService.getProductById(id);
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            if(field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, product, value);
            }
        });
        return ResponseEntity.ok(productService.updatePatchProduct(id, product));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        // DELETE /products/{id} → elimina un prodotto.
        /*try {
            productService.getProductById(id);
            productService.deleteProduct(id);
            return new ResponseEntity<String>("Product deleted!", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity.ok("Product deleted!");
    }

}
