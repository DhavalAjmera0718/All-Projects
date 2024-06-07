package com.Teacher.Entity;

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
public class Teacher_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacher_id;
	
	private String teacher_name;
	
	private String teaching_sub;

}
