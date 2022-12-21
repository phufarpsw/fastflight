package com.project_sop.reserveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReserveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReserveServiceApplication.class, args);
	}

}
