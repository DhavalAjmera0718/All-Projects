package com.example.StudentManyToMany.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor/*(staticName = "PerentEntityStaticData")*/
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student_Entity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sid;
	private String sname;
	private String department;
	
//	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinTable(name = "STUDENT_COUSE_TABLE" , 
//	joinColumns = {@JoinColumn(name = "Student_ID" , referencedColumnName = "sid")},
//	inverseJoinColumns = {@JoinColumn(name="Couese_ID" , referencedColumnName = "cid")})
//	//@JsonManagedReference
	//@JsonBackReference
//	@JsonIgnoreProperties("student")
//	private List<Course_Entity> course;
	@OneToOne
	@Cascade(CascadeType.ALL)
//	private List<Course_Entity> course;
	private Course_Entity course;
	
	 
	
	
	

}
