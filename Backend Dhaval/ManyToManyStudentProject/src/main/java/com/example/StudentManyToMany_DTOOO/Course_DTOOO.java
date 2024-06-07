package com.example.StudentManyToMany_DTOOO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor(staticName = "childDTOStaticdata")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Course_DTOOO {

	
	private Long cid;
	private String name;
	private String fee;

//	private List<Student_DTO> student;
}
