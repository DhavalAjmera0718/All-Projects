package com.example.Form.DTO;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class DTO_Form {

	
	private int id;
	@NotNull(message = "")
	private String name;
	/*-------------------------------------------------------*/	
	@Email(message = "Enter Valid Email Id ")
	private String email;
	/*-------------------------------------------------------*/	
	@Pattern(regexp = "^\\d{10}$" , message = "Please Enter Valid Mobile Number As per Record..")
	private String mobilNo;
	/*-------------------------------------------------------*/	

	@NotBlank
	private String gender;
	/*-------------------------------------------------------*/	
	
	@Min(18)
	@Max(60)
	private int age;
	/*-------------------------------------------------------*/	

	@NotBlank
	private String nation;
	/*-------------------------------------------------------*/	

	@NotNull
	private String address;
	/*-------------------------------------------------------*/	
	
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
}
