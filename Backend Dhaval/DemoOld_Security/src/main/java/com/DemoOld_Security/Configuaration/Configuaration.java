package com.DemoOld_Security.Configuaration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Configuaration {
	
	@Bean
	public Docket docket() 
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfoDetails()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
				
	}

	private ApiInfo apiInfoDetails() {
		// TODO Auto-generated method stub
		return new ApiInfo("DEMO PROJECT", "DEMO DATA", "V2.7.7", "Tearms And Conditions", new Contact("Dhaval", "dhaval.ajmera@gmail.com", "ABC")
				, "TEXT", "URL", Collections.emptyList());
	}
	
	

}
