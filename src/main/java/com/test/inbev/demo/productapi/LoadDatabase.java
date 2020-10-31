/**
 * autor: geraldojr
 * teste para entrevita técnica ab-inbev
 * data 09/09/2020
 * 
 * classe: LoadDatabase
 * 		faz a carga inicial de informações a serem usadas na aplicação
 */
package com.test.inbev.demo.productapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ProductRepo repository) {
	  // name / description / price / brand
    return args -> {
    	repository.save(new Product("Antarctica Sub-Zero", "American Lager", 7.5, "Antarctica"));
        repository.save(new Product("Original", "American Lager", 8.5, "Antarctica"));
        repository.save(new Product("Caracu", "Sweet Stout", 9.5, "Antarctica"));
        repository.save(new Product("GATORADE FRUTAS CÍTRICAS", "ISOTÔNICOS", 5.5, "GATORADE"));
    };
  }
}