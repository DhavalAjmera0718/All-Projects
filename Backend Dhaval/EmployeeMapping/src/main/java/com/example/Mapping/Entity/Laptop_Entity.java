package com.example.Mapping.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "laptopStatic")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Laptop_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lapId;
	private String lapCompany;
	private String lapPrice;

}
