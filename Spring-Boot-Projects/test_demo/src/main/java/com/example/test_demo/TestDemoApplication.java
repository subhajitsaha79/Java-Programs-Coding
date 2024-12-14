package com.example.test_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//SpringBootConfiguration - Class can have other beans defined inside this class @Bean - can be used further for dependency injection
//EnableAutoConfiguration - Automatically configure the web project using backend and data modules
//ComponentScan - Looking at all the annotations present in this project and create beans for all the annotations - Filter -> Only the subpackages under this project will be scanned
public class TestDemoApplication {

	public static void main(String[] args) {
		//Spring Boot Project will be initiated and launched
		//pom.xml is for the starter spring boot dependencies
		SpringApplication.run(TestDemoApplication.class, args);
	}

}
