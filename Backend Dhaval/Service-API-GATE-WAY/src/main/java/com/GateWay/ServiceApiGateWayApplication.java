package com.GateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiGateWayApplication.class, args);
	}

}
