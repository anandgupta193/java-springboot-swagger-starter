package com.rest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.rest")
@SpringBootApplication
public class RestDemoApplication {
	private static final Logger LOGGER =LoggerFactory.getLogger(RestDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
		LOGGER.info("Here");
	}
}
