package com.example.Multiple_FileUpload.Proxy;

import java.util.List;

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
public class Multiple_DTOO {

	
	private Long id;
	
	
	private List<Child_DTOOO> files;

}
