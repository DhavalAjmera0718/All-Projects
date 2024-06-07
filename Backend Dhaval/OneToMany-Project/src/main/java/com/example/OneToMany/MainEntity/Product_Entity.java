package com.example.OneToMany.MainEntity;

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
@AllArgsConstructor(staticName = "productEntityStatic")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String productName;
	private Long price;
	

}
