package com.example.Book.Controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.Book.Entity.BookEntity;
import com.example.Book.Service.BookServices;
import com.example.Book.dto.Book_DTO;

@RestController
public class BookController {

	@Autowired
	private BookServices services;

//	@GetMapping("/GetAllBook")
//	public ResponseEntity<List<Book_DTO>> GetAllBook() {
//		return new ResponseEntity<List<Book_DTO>>(services.GetAllBook(),HttpStatus.ACCEPTED);
//	}
	/*----------------------------------------------------------Save Data ---------------------------------------------------------------------------*/

	@PostMapping("/SaveData/{count}")

	public ResponseEntity<String> SaveData(@PathVariable("count") int count) {
		//return new ResponseEntity<>(services.SaveData(books), HttpStatus.ACCEPTED);
		
		if(services.SaveData(count)) {
			return new ResponseEntity<>("Data Saved!",HttpStatus.OK);
		}
		return new ResponseEntity<>("Error!",HttpStatus.BAD_REQUEST);
	}

	/*--------------------------------------------------------DELET By ID----------------------------------------------------------------------------*/
//	@DeleteMapping("/DeleteByid/{Bid}")
//	public String DeleteByid(@PathVariable int Bid) {
//		return services.DeleteByid(Bid);
//	}
/*--------------------------------------------------------DELET By ID----------------------------------------------------------------------------*/
//	@DeleteMapping("/DeleAll")
//	public String DeleAll() {
//		return services.DeleAll();
//	}	

	/*--------------------------------------------------------FIND By ID----------------------------------------------------------------------------*/
//	@GetMapping("/findById/{Bid}")
//	public String findById(@PathVariable int Bid) {
//		return services.FingByid(Bid);
//	}

	/*--------------------------------------------------------UPDATE ByID----------------------------------------------------------------------------*/
//	@PutMapping("/UpdateById/{Bid}")
//	public ResponseEntity<String> UpdateById(@PathVariable int Bid, @RequestBody Book_DTO books) {
//		System.out.println("id-" + Bid);
//		return new ResponseEntity<String>(services.UpdateById(Bid, books),HttpStatus.ACCEPTED);
//	}

}
