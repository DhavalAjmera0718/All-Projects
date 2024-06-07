package com.example.Mapping.DTO;



import com.example.Mapping.Entity.Laptop_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Data
@AllArgsConstructor(staticName = "empDtoName")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Emp_DTO {
	

	private Long emp_id;
	
	private String name;
	
	private String city;
	
	private Laptop_DTO laptop;

}
