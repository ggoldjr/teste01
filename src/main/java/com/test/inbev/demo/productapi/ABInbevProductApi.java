/**
 * autor: geraldojr
 * teste para entrevita técnica ab-inbev
 * data 09/09/2020
 * 
 * classe: ABInbevProductApi
 * 		main class
 */
package com.test.inbev.demo.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ABInbevProductApi {

	public static void main(String[] args) {
		SpringApplication.run(ABInbevProductApi.class, args);
	}

}
