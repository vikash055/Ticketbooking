package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({ "com.example.demo" })
@SpringBootApplication
//@EnableJpaRepositories
//@EntityScan
public class TicketbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketbookingApplication.class, args);
	}
}
