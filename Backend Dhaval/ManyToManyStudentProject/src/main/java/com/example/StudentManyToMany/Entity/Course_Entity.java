package com.example.StudentManyToMany.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	private String name;
	private String fee;
	
//	@ManyToMany(mappedBy = "course",cascade = CascadeType.ALL)
	//@JsonBackReference
	//@JsonIgnore
	//@JsonManagedReference
//	@JsonIgnoreProperties("course") 
//	private List<Student_Entity> student;
	
	
//	private Student_Entity student;
	
	
	
}
