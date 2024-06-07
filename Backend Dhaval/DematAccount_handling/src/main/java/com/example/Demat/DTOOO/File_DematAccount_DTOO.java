package com.example.Demat.DTOOO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class File_DematAccount_DTOO {

	private Long id;
	
	private String name;
	
	private Long size;
	
	private String path;
	
	private String originalname;
	
	private String contentType;
}
