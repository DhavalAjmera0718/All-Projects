package com.example.Student.Dataset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
	
	private Long RollNo;
	private String Name;
	private String address;
	private int age;

}
