package com.example.Mapping.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "EmpStatic")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Emp_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emp_id;
	private String name;
	private String city;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Laptop_Entity laptop;

}
