package com.mborgraeve.arduinoserver;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArduinoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArduinoServerApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	//TODO add security
        	//TODO add storage in h2 with persistence, save database
        	//TODO get instructions from database and serve them
        	//TODO add users for security and database
        	//TODO add planning in database (maybe gitcloud ?)
        	//TODO Be able to create instructions
        	//TODO Create home configuration
        	//TODO create mean to add new thermostats
        	//TODO serve temp depending on room
        	//TODO put in docker
        	//TODO creaTe receiver for IFTT
        	//TODO create rules for temp depending on people statuses (here, not here unknown, leaving work, close) : imely, geopositionning.
        	//TODO create config in gitcloud for routing events/iftt
        	//TODO create event router with config from git
        	//TODO See if smart home software already exists
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
