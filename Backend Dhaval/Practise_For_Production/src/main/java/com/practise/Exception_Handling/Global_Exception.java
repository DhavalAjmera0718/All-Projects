package com.practise.Exception_Handling;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class Global_Exception {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Format_Ex> NosuchElement(NoSuchElementException e)
	{
		Format_Ex fr =  new Format_Ex();
		LocalDateTime l1 =  LocalDateTime.now();
		DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/mm/yy HH:MM:SS");
		String fromatdate = l1.format(d1);
		fr.setEMessage("Id Not Found Pleaase Enter Correct Id..");
		fr.setECode("404");
		fr.setDate(fromatdate);
		return new ResponseEntity<Format_Ex>(fr , HttpStatus.BAD_GATEWAY);
	}
	
	
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<Format_Ex> First_Exception(NoSuchElementException e)
//	{
//		Format_Ex exception = new Format_Ex();
//		LocalDateTime l1 = LocalDateTime.now();
//		DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/mm/yy HH:MM:SS");
//		String format1 = l1.format(d1);
//		exception.setEMessage("Id Is Not Available Please Enter Correct ID............");
//		exception.setECode("500");
//		exception.setDate(format1);
//		
//		return new ResponseEntity<Format_Ex>(exception,HttpStatus.BAD_REQUEST);
//	}	
	
}
