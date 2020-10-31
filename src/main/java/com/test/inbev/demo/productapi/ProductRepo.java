/**
 * autor: geraldojr
 * teste para entrevita técnica ab-inbev
 * data 09/09/2020
 * 
 * intereface: ProductRepo
 * 		interface de acesso aos dados
 */
package com.test.inbev.demo.productapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("SELECT p FROM Product p WHERE upper(p.name) LIKE %?1%"
            + " OR upper(p.brand) LIKE %?1%"
            + " OR upper(p.description) LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")
    public List<Product> searchIgnoreCase(String keyword);
}