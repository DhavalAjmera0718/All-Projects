package com.example.StudentManyToMany_DTOOO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor(staticName = "perentDtoStaticData")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Student_DTO {

	
	private Long sid;
	private String sname;
	private String department;
	
//	private List<Course_DTOOO> course;
//	private Course_DTOOO course;

	private Course_DTOOO course;

}
