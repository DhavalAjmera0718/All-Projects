package com.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.User.DTO.EducationDetails_DTO;
import com.User.DTO.Student_DTO;
import com.User.Entity.Student_Entity;
import com.User.Service.Educational_Service;
import com.User.Service.StudentServices;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StudentServices stServices;
	
	@Autowired
	private Educational_Service edService;
/******************************************************** registerWithDetails ****************************************************************************************/	

	@PostMapping("/register-user")
	public ResponseEntity<?> registerWithDetails(@RequestBody Student_DTO sDto)
	{
		System.err.println("FROM USER SERVICE REGISTER USER" + sDto);
		return new ResponseEntity<>(stServices.registerWithDetails(sDto),HttpStatus.CREATED);
	}
/******************************************************** [ GET USER ] ****************************************************************************************/	
	
	@GetMapping("/getUser/{enRoll}")
	public ResponseEntity<Student_DTO>   getUser(@PathVariable("enRoll") String enRoll) 
	{
		return new ResponseEntity<Student_DTO>(stServices.getUser(enRoll),HttpStatus.ACCEPTED);
	}
/******************************************************** updateUserDetails ****************************************************************************************/	
	@PostMapping("updateUser/{enRoll}")
	public ResponseEntity<String> updateUserDetails(@PathVariable("enRoll") String enRoll, @RequestBody Student_Entity sEntity) 
	{
		System.err.println(sEntity);
		return new ResponseEntity<String>(stServices.updateUserDetails(enRoll, sEntity),HttpStatus.ACCEPTED);
	}
	
/************************************************************************************************************************************************/
	@PostMapping("/addEducationDetails")
	public ResponseEntity<String> addEducationDetails(@RequestBody EducationDetails_DTO eDto) 
	{
		return new ResponseEntity<String>(edService.addEducationDetails(eDto) , HttpStatus.OK);
	}	
	
/*************************************************************************************************************************************************/	
	@PostMapping("/updateEducationDetails/{id}")
	public ResponseEntity<String> updateEducationDetails(@PathVariable("id") Long id ,@RequestBody EducationDetails_DTO dto) 
	{
		return new ResponseEntity<String>(edService.updateEducationDetails(id, dto) , HttpStatus.OK);

	}
/**************************************************** GET FEES DETAILS *********************************************************************************************/	

	@GetMapping("/get_FeesDetails")
	public ResponseEntity<String> GetFeesDetail()
	{
	  System.err.println("Data to be Get FEES DETAILS From SERVISE-USER -------------> " );
	  String forObject =restTemplate.getForObject("http://SERVICE-ADMIN/admin/admin/get_FeesDetails	", String.class);;
	  return new ResponseEntity<String>(forObject , HttpStatus.ACCEPTED);
	} 

/*********************************************************************************************************************************************/	
	@GetMapping("/getKey/{enrollmentNo}")
    public List<Object[]> getSecurityKeyAndEnrollmentNo(@PathVariable String enrollmentNo) {
        return stServices.getSecurityKeyAndEnrollmentNo(enrollmentNo);
    }
    
  /*************************************************************DELETE BY ID******************************************************************************************/
    @GetMapping("/delete_user/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable("id") String id) 
    {
    	System.err.println("ID FROM USER CONTROLLER----------> "+id);
    	return new ResponseEntity<String>(stServices.DeleteUser(id),HttpStatus.OK);
    	
    }
    
 /*******************************************************[ GET ALL USER ]************************************************************************************************/
    @GetMapping("/getAllUser")
	public ResponseEntity<List<Student_DTO>> getUsers() 
	{
		return new ResponseEntity<List<Student_DTO>>(stServices.getUsers() , HttpStatus.ACCEPTED);

	}   
    
  /********************************************************** CHECKING API ***********************************************************************************/	
    
    @PostMapping("/check-api")
    public ResponseEntity<Object> checkingApi(@RequestBody Student_Entity student_Entity)
    {
    	System.out.println("Data to be saved from SERVICE-USER -------------> " + student_Entity);
    
    	Student_Entity st =  new Student_Entity();
    	st.setName(student_Entity.getName());
    	return new ResponseEntity<Object>(st , HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-api")
    public ResponseEntity<String> getApi()
    {
    	System.out.println("Data to be Get from SERVICE-USER -------------> " );
    	return new ResponseEntity<String>("Checking Get Api---> " , HttpStatus.ACCEPTED);
    }    
 /**************************************************** [ GET SECURITY KEY USINF JPQL ]*******************************************************************************/ 
    
    	@GetMapping("getOnly_SecurityKey_ByName/{name}")
    	public ResponseEntity<String> getOnly_SecurityKey_ByName(@PathVariable("name") String name)
    	{
    		return new ResponseEntity<String>(stServices.getOnly_SecurityKey_ByName(name),HttpStatus.ACCEPTED);
    	}
    
  /************************************************** [ COUNT DATA ] *****************************************************************************************/  

    	@GetMapping("Count_Data")
    	public ResponseEntity<String> Count_Data()
    	{
    		return new ResponseEntity<String>(stServices.Count_Data(),HttpStatus.CONTINUE);
    	}
   /*********************************************** [ Get Data By Character ] **********************************************************************************/ 	

    	@GetMapping("/Get_DataBy_Character/{ch}")
    	public ResponseEntity<List<Student_Entity>> Get_DataBy_Character(@PathVariable("ch") String character)
    	{
    		return new ResponseEntity<List<Student_Entity>>(stServices.Get_DataBy_Character(character) , HttpStatus.ACCEPTED);
    	}
}
