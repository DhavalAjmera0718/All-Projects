package com.example.Student.Enitity;

import org.springframework.context.annotation.Primary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Primary
public class Student_Enitity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long RollNo;
	private String Name;
	private String address;
	private int age;

}
