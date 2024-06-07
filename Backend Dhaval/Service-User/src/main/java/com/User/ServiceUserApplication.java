package com.User;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUserApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() 
	{
		return new RestTemplate();
	}
//	 @Bean
//	    public CorsFilter corsFilter() {
//	        CorsConfiguration corsConfiguration = new CorsConfiguration();
//	        corsConfiguration.addAllowedOrigin("*");
//	        corsConfiguration.addAllowedHeader("*");
//	        corsConfiguration.addAllowedMethod("*");
//	        corsConfiguration.setAllowCredentials(true); // If you need credentials such as cookies, set this to true
//	        
//	        // Apply the configuration to all paths
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", corsConfiguration);
//
//	        // Return the configured CorsFilter
//	        return new CorsFilter(source);
//	    }
}
