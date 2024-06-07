package com.EMPLOYEEAUTH.Configuaration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class Api_FreeMarker_Config {

	@Primary
	@Bean
	public FreeMarkerConfigurationFactoryBean factoryBean() 
	{
		FreeMarkerConfigurationFactoryBean bean =  new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates");
		return bean;
	}
	
	

	
	
}
