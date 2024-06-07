package com.example.Pan.Enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pan_India")
public class Pan_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pan_Id;
	
	private String pan_Name;
	
	private String pan_Number;
}
