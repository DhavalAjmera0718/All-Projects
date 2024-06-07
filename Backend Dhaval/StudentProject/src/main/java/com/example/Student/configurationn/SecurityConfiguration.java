
package com.example.Student.configurationn;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
// 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
 
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		 return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails normalUserDetails = User.withUsername("root")
		.password(passwordEncoder().encode("root"))
		.roles("NORMAL")
		.build();
		
		UserDetails adminUserDetails = User.withUsername("admin")
		.password(passwordEncoder().encode("admin"))
		.roles("ADMIN")
		.build();
		
		return new InMemoryUserDetailsManager(normalUserDetails , adminUserDetails);
	}
	
//	
	 public static final String[] AUTH_STRINGS= {
			 	
    		 	"/swagger-resources/**",
    	        "/swagger-ui.html",
    	        "/v2/api-docs",
    	        "/webjars/**",
    	        "/v3/api-docs/**",
    	        "/swagger-ui/**",
 //    		"/api/v1/auth/**",
//    		"/v3/api-docs.yaml",
//    		"/swagger-ui.html"
    };
//	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //http
//            .authorizeRequests((requests) -> requests
//                .requestMatchers("/Home").permitAll() // permit access to "/Home" without authentication
//                .anyRequest().authenticated()
//            )
//            .formLogin(Customizer.withDefaults()) // use default Spring Security login form
//            .logout(Customizer.withDefaults()); // use default Spring Security logout functionality
        
    	
    	
    	
            http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                		.requestMatchers(AUTH_STRINGS).permitAll()
                		.requestMatchers("/AboutUs").hasRole("ADMIN")
                		.requestMatchers("/Service").hasRole("NORMAL")
                        .anyRequest()
                        .authenticated())
                .formLogin(Customizer.withDefaults());
//                .logout(Customizer.withDefaults());
           // System.err.println(http);
        return http.build();
    }
  /************************************ http://localhost:8090/AUTH_STRINGS/swagger-ui.html *******************************************************************************/
//    @Bean
//    public Docket docket() 
//    {
//    	 return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfoDetails())
//    			 .select()
//    			 .apis(RequestHandlerSelectors.any())
//    			 .paths(PathSelectors.any())
//    			 .build();
//    	            
//   }
//    private ApiInfo apiInfoDetails() {
//		// TODO Auto-generated method stub
//		return new ApiInfo("Student PROJECT", "STUDENTDATA", "V3.2.2", "Tearms And Conditions", new Contact("Dhaval", "dhaval.ajmera@gmail.com", "ABC")
//				, "TEXT", "URL", Collections.emptyList());
//    }
    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Student Project From Configuartion")
                .description("Spring shop sample application")
                .version("v3.2.2")
                .contact(new Contact().name("DHAVAL AJMERA").email("dhaval.ajmera@gmail.com"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("SpringShop Wiki Documentation")
                .url("https://springshop.wiki.github.org/docs"));
    
//    	Info info=new Info()
//    			.title("Student Project from Configuration")
//    			.version("v3.2.2")
//    			.contact(new Contact().name("DHAVAL AJMERA").email("dhaval.ajmera@gmail.com"))
//    			.license(new License().name("Apache 2.0").url("http://springdoc.org"))
//    			.description("Student Project OpenApi");
    
    	
    	
    	
    	//return new OpenAPI().info(info);
    }
   
}
 