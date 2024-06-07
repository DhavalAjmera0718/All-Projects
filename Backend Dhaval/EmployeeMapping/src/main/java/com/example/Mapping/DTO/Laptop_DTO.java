package com.example.Mapping.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName = "laptopStaticDto")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Laptop_DTO {
	
	private Long lapId;
	private String lapCompany;
	private String lapPrice;
	

}
