package com.example.OneToMany.DTO_Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName = "productDTOstatic")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product_DTO {
	
	private Long pid;
	private String productName;
	private Long price;

}
