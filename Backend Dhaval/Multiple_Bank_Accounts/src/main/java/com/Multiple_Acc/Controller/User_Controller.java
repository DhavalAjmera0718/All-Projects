package com.Multiple_Acc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiple_Acc.DTOO.User_DTOO;
import com.Multiple_Acc.Entity.DataBase_User_Id_Pass;
import com.Multiple_Acc.Entity.User_Entity;
import com.Multiple_Acc.Implimantation.User_Implimantation;

@RestController
public class User_Controller {

	
	@Autowired
	private User_Implimantation implimantation;
	
	@PostMapping("/SaveData")
	public ResponseEntity<String> SaveData(@RequestBody User_DTOO dtoo)
	{
		return new ResponseEntity<String>(implimantation.SaveData(dtoo) , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/GetByID/{id}")
	public ResponseEntity<User_DTOO> GetByID(@PathVariable("id") Long id) 
	{
		System.err.println("Id-----------------  " + id);
		
		return new ResponseEntity<User_DTOO>(implimantation.GetByID(id),HttpStatus.FOUND);
	}
/*************************************************** GET BANK BALANCE USING JPQL QUERY****************************************************************************************/	
	
	@GetMapping("/Get_Ac_Balance/{id}")
	public ResponseEntity<List<Long>> getAccountBalancesByUserId(@PathVariable("id") Long id)
	{
		System.err.println("ID---------" + id);
		return new ResponseEntity(implimantation.getAccountBalancesByUserId(id) , HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Add_User")
	public ResponseEntity<String> Add_User(@RequestBody DataBase_User_Id_Pass dtoo) 
	{
		return new ResponseEntity<String>(implimantation.Add_User(dtoo) , HttpStatus.CREATED);
	}	

/***********************************************  DELETE BY ID  *****************************************************************************************************/	
	@DeleteMapping("DeleteById/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable Long id) 
	{
		return new ResponseEntity<String>(implimantation.DeleteById(id) , HttpStatus.OK);
	}
/********************************************** UPDATE BY ID ********************************************************************************************/

	@PutMapping("/UpdateByID/{id}")
	 public ResponseEntity<String> UpdateByID(@PathVariable("id") Long id ,@RequestBody User_Entity entity ) 
	 {
		 return new ResponseEntity<String>(implimantation.UpdateByID(id, entity),HttpStatus.UPGRADE_REQUIRED);
	 }	
}
