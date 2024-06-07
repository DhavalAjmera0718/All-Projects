package com.example.OneToMany.MainEntity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.example.OneToMany.DTO_Customer.Product_DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor(staticName = "customerStatic")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Entity_Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String name;

	@OneToMany(targetEntity = Product_Entity.class)
	@OneToOne()
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "CustomerId_F" , referencedColumnName = "customerId")
	private List<Product_Entity> products;
	

}
