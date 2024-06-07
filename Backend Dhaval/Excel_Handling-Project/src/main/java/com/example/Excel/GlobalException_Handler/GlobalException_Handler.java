package com.example.Excel.GlobalException_Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException_Handler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Format_Exception> First_Exception(ArithmeticException e)
	{
		Format_Exception exception = new Format_Exception();
		exception.setExceptioMessage("Please Enter Break");
		exception.setExceptionCode("10000");
		return new ResponseEntity<Format_Exception>(exception,HttpStatus.BAD_REQUEST);
	}

}
