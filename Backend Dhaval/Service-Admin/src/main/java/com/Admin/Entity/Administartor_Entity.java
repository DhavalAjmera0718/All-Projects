package com.Admin.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Administartor_Entity")
public class Administartor_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String password;
	
	//@Id
	private String name;
	
	private String gender;
	
	private String contact;
	
	private String address;
	
	private String city;
	
	private String pinCode;
	
	private String securityKey;
	
	

}
