package com.example.StudentManyToMany.Implii;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.StudentManyToMany.Entity.Course_Entity;
import com.example.StudentManyToMany.Entity.Student_Entity;
import com.example.StudentManyToMany.Reoo.Course_Repo;
import com.example.StudentManyToMany.Reoo.Student_Repo;
import com.example.StudentManyToMany.Service.Student_Service;
import com.example.StudentManyToMany.Utils.Helper_Student;
import com.example.StudentManyToMany_DTOOO.Course_DTOOO;
import com.example.StudentManyToMany_DTOOO.Student_DTO;

@Component
public class Student_Implimantation implements Student_Service {

	
	@Autowired
	private Student_Repo repo;
	
	@Autowired
	private Course_Repo course_Repo;
	
	@Autowired
	private Helper_Student helper;
	
/*---------------------------------------------------- SAVE DATA MANY TO MANY ------------------------------------------------------------------------------------*/	
//	public String SaveData(Student_DTO sDto) 
//	{
//		
//		Student_Entity mainEntitityData = helper.DtoToEntityConvert(sDto);
//		repo.save(mainEntitityData);
//		System.err.println(sDto);
//		System.err.println(mainEntitityData);
//		return ".............Your Data Has Been Saved............";
//	}
//	
/*------------------------------------------------------[ SAVE DATA ONE TO MANY WITH ANGULAR]------------------------------------------------------------------------------------*/	

	public String SaveData(Student_DTO sDto) 
	{
		
		Student_Entity mainEntitityData = helper.DtoToEntityConvert(sDto);
		repo.save(mainEntitityData);
		System.err.println(sDto);
		System.err.println(mainEntitityData);
		return ".............Your Data Has Been Saved............";
	}
	
	
/**************************************************** GET DATA MANY TO MANY *************************************************************************************/	
	
	public Student_DTO GetDataById(Long id) 
	{
		Student_Entity mainEntity = repo.findById(id).get();
//		Course_Entity childEntityData = mainEntity.getCourse();
		
		Student_DTO perentDtoData = helper.EnitityToDto_Convert(mainEntity);
		return perentDtoData;
	}
	
/**************************************************** GET CHILD DATA MANY TO MANY *************************************************************************************/		

	public Course_DTOOO getChildData(Long id) 
	
	{
		Course_Entity childData = course_Repo.findById(id).get();
		Course_DTOOO ChildGetData = helper.EnitityToDtoConvert_Child(childData);
		System.err.println("Child Data:->"+childData);
		return ChildGetData;
	}


@Override
public List<Student_DTO> GetAllStudentData() {
	
	List<Student_Entity> all = repo.findAll();
	
	List<Student_DTO> dummyList =  new ArrayList<>();
	
	for (Student_Entity student_Entity : all) {
		Student_DTO enitityToDto_Convert = helper.EnitityToDto_Convert(student_Entity);
		dummyList.add(enitityToDto_Convert);
		
	}
	return dummyList;
	
//	List<Student_Entity> all = (List<Student_Entity>) repo.findAll();
//	
//	List<Student_DTO> dummyList = new ArrayList<>();
//	for (Student_Entity studentEntityData : all) {
//		
//		  List<Course_Entity> course = studentEntityData.getCourse();
//		  System.err.println("------>" + course);
//
//		List<Course_DTOOO> childDummyList = new ArrayList<>();
//		
//		for(Course_Entity entityData : course) 
//		{
//			Course_DTOOO childDTOStaticdata = Course_DTOOO.childDTOStaticdata(entityData.getCid(), entityData.getName(), entityData.getFee());
//			childDummyList.add(childDTOStaticdata);
//		}
//		Student_DTO perentDtoStaticData = Student_DTO.perentDtoStaticData(studentEntityData.getSid(), studentEntityData.getSname(), studentEntityData.getDepartment(), childDummyList);
//		dummyList.add(perentDtoStaticData);
//		}
//		
//	return dummyList;
//	}
	
	
}
	

}


























