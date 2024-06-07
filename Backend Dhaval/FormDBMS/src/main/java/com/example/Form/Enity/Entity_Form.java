package com.example.Form.Enity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Entity_Form {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String mobilNo;
	private String gender;
	private int age;
	private String nation;
	private String address;
	private LocalDate date;
}
