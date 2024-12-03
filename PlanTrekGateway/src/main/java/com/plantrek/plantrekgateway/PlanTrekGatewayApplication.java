package com.plantrek.plantrekgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PlanTrekGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanTrekGatewayApplication.class, args);
	}

}
