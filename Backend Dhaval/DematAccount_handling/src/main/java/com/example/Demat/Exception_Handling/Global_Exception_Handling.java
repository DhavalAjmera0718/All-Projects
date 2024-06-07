package com.example.Demat.Exception_Handling;

import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Demat.Entity.Format_Exception;

@RestControllerAdvice
public class Global_Exception_Handling {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Format_Exception> First_Exception(NoSuchElementException e)
	{
		Format_Exception exception = new Format_Exception();
		LocalDateTime l1 = LocalDateTime.now();
		DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/mm/yy HH:MM:SS");
		String format1 = l1.format(d1);
		exception.setEMessage("Id Is Not Available Please Enter Correct ID");
		exception.setECode("500");
		exception.setDate(format1);
		
		return new ResponseEntity<Format_Exception>(exception,HttpStatus.BAD_REQUEST);
	}
/*****************************************************************************************************/	
	@ExceptionHandler(FileAlreadyExistsException.class)
	public ResponseEntity<Format_Exception> Third_Exception(FileAlreadyExistsException e)
	{
		Format_Exception exception = new Format_Exception();
		Date date = new Date();
		exception.setEMessage("Document Already Available");
		exception.setECode("5000");
		exception.setDate(date.toString());
		return new ResponseEntity<Format_Exception>(exception,HttpStatus.BAD_REQUEST);
	}	
/***********************************************************************************************************/	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Format_Exception> Second_Exception(Exception e)
	{
		Format_Exception exception = new Format_Exception();
		Date date = new Date();
		exception.setEMessage("Try Again");
		exception.setECode("404");
		exception.setDate(date.toString());
		return new ResponseEntity<Format_Exception>(exception,HttpStatus.BAD_REQUEST);
	}
	
	
}
