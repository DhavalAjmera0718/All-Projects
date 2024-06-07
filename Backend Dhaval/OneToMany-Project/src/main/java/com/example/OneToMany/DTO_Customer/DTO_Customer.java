package com.example.OneToMany.DTO_Customer;





import java.util.List;

import com.example.OneToMany.MainEntity.Entity_Customer;
import com.example.OneToMany.MainEntity.Product_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor(staticName = "customerDTOstatic")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DTO_Customer {

	private Long customerId;
	
	private String name;
	
	private List<Product_DTO> products;

	
	

}
