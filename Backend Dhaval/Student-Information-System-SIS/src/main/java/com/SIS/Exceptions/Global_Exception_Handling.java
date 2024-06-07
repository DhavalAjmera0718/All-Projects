package com.SIS.Exceptions;

import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice
public class Global_Exception_Handling {

	@ExceptionHandler(SignatureException.class)
	public ResponseEntity<Format_Exception> First_Exception(SignatureException e)
	{
		Format_Exception exception = new Format_Exception();
		LocalDateTime l1 = LocalDateTime.now();
		DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/mm/yy HH:MM:SS");
		String format1 = l1.format(d1);
		exception.setEMessage("Id Duplicate Please Enter Correct ID");
		exception.setECode("500");
		exception.setDate(format1);
		
		return new ResponseEntity<Format_Exception>(exception,HttpStatus.BAD_GATEWAY);
	}
/**************************************************************************************************************/		
		@ExceptionHandler(InvalidDataAccessApiUsageException.class)
		public ResponseEntity<Format_Exception> Second_Exception(InvalidDataAccessApiUsageException e)
		{
			Format_Exception exception = new Format_Exception();
			LocalDateTime l1 = LocalDateTime.now();
			DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/mm/yy HH:MM:SS");
			String format1 = l1.format(d1);
			exception.setEMessage("Id is not Present..");
			exception.setECode("500");
			exception.setDate(format1);
			
			return new ResponseEntity<Format_Exception>(exception,HttpStatus.BAD_GATEWAY);	
	}
	
}