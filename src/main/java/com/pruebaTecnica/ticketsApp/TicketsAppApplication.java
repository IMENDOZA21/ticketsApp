package com.pruebaTecnica.ticketsApp;

import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.pruebaTecnica.ticketsApp.services.TicketGraphQLService;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsAppApplication.class, args);
	}

}
