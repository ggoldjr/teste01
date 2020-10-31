/**
 * autor: geraldojr
 * teste para entrevita técnica ab-inbev
 * data 09/09/2020
 * 
 * classe: ProductService
 * 		responsável por disponibilizar os serviços da aplicação
 */
package com.test.inbev.demo.productapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
@Service
@Transactional
@RestController
public class ProductService {
 
    @Autowired
    private ProductRepo repo;

    @GetMapping("/products")
    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repo.searchIgnoreCase(keyword.toUpperCase());
        }
        return repo.findAll();
    }
    
    @PostMapping("/products")
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
    
    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

      return repo.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id));
    }
    
    @DeleteMapping("/products/{id}")
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

      return repo.findById(id)
        .map(product -> {
      	  product.setName(newProduct.getName());
      	  product.setDescription(newProduct.getDescription());
      	  product.setPrice(newProduct.getPrice());
      	  product.setBrand(newProduct.getBrand());
          return repo.save(product);
        })
        .orElseGet(() -> {
      	  newProduct.setId(id);
          return repo.save(newProduct);
        });
    }
}