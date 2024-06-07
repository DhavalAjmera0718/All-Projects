package com.example.Adhar.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adhar_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adhar_id;
	
	
	private String adhar_Name;
	
	private String adhar_Number;
	
}
