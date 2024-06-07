package com.example.Book.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
public class Book_DTO {

	@Min(100)
	@Max(150)
	private int sid;
	@NotBlank(message = "Name is Mandatory")
	private String name;
	@NotNull(message = "You Should Enter Type....")
	private String type;
}
