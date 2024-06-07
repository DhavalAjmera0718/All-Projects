package com.example.OneToMany.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.OneToMany.DTO_Customer.DTO_Customer;
import com.example.OneToMany.DTO_Customer.Product_DTO;
import com.example.OneToMany.MainEntity.Entity_Customer;
import com.example.OneToMany.MainEntity.Product_Entity;
import com.example.OneToMany.Repository.Repo_Customer;
import com.example.OneToMany.Service.Service_Coustomer;


@Component
public class Implimentation_Customer implements Service_Coustomer {

@Autowired
private Repo_Customer customerRepo;


	
	@Override
	public String SaveData(DTO_Customer cDto_Customer) {
		
		List<Product_Entity> product_Entities = new ArrayList<>();
		
		List<Product_DTO> product_DTOs = cDto_Customer.getProducts();
		
		for (Product_DTO product_DTOoBJ : product_DTOs) {

			Product_Entity productEntityStatic = Product_Entity.productEntityStatic(product_DTOoBJ.getPid(),
					product_DTOoBJ.getProductName(), product_DTOoBJ.getPrice());
			product_Entities.add(productEntityStatic);
		}
		
		Entity_Customer customerEntityStatic = Entity_Customer.customerStatic(cDto_Customer.getCustomerId(),
				cDto_Customer.getName(), product_Entities);
		customerRepo.save(customerEntityStatic);
		
		return "Data Hase Been Saved......";
	}
/*********************************************************GET DATA BY ID*******************************************************************************/
	@Override
	public DTO_Customer GetData(Long id) {
		
		Entity_Customer entity_Customer = customerRepo.findById(id).get();
		
		System.out.println(id);
		
		List<Product_DTO> productDto = new ArrayList<>();
		
		 List<Product_Entity> productsEntity1 = entity_Customer.getProducts();
		
		for(Product_Entity product_Entity : productsEntity1) 
		{
			Product_DTO productDTOstatic = Product_DTO.productDTOstatic(product_Entity.getPid(), product_Entity.getProductName(), product_Entity.getPrice());
			productDto.add(productDTOstatic);
		}
		
		DTO_Customer customerDTOstatic = DTO_Customer.customerDTOstatic(entity_Customer.getCustomerId(), entity_Customer.getName(), productDto);
		System.out.println(customerDTOstatic);
		return customerDTOstatic;
	}
/**********************************************************DELETE BY ID****************************************************************************/
	@Override
	public String DeleteById(Long id) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(id);
		return "Id Number " + id + " Is Deleted.........";
	}
/***************************************************************UPDATE BY ID*****************************************************************************/
	@Override
	public String UpdateById(Long id , DTO_Customer customer ) 
	{
		Optional<Entity_Customer> cEntity = customerRepo.findById(id);
		
		if(cEntity.isPresent()) 
		{
			Entity_Customer mainDataEntitity = cEntity.get(); 
			if(customer.getName()!=null) 
			{
				mainDataEntitity.setName(customer.getName());
		
			}
			
			List<Product_DTO> ChildproductDTO = customer.getProducts();//postman data
			System.err.println(ChildproductDTO);
			
			List<Product_Entity> existingEnititydata = mainDataEntitity.getProducts();// Existing Table Data
			System.err.println(existingEnititydata);
			if(!ChildproductDTO.isEmpty()) {
				
				for (Product_Entity product_Entity : existingEnititydata) {
					if(product_Entity.getProductName()!=null && product_Entity.getPrice()!=null) {
						for(Product_DTO child:ChildproductDTO) {
							
							product_Entity.setProductName(child.getProductName());
							product_Entity.setPrice(child.getPrice());
							
							
							
						}
					}
					mainDataEntitity.setProducts(existingEnititydata);
			}
				System.err.println(mainDataEntitity);
				
			}
			customerRepo.save(mainDataEntitity);
			
		}
		return "Data Updated..";
	}
/****************************************************************GET ALL DATA************************************************************************************************/
@Override
public List<DTO_Customer> GetAllData() {
	
		List<Entity_Customer> allData = (List<Entity_Customer>) customerRepo.findAll();
		
		List<DTO_Customer> dtos1 = new ArrayList<>();
		
		//List<Product_DTO> product_DTOs = customer.getProducts();
		
		for (Entity_Customer product_DTO1 : allData)
		{
			List<Product_Entity> products1 = product_DTO1.getProducts();
			List<Product_DTO> dummyList1 = new ArrayList<>();
			
			for(Product_Entity dto :products1) 
			{
				Product_DTO productDTOstatic = Product_DTO.productDTOstatic(dto.getPid(), dto.getProductName(), dto.getPrice());
				dummyList1.add(productDTOstatic);
			}
			DTO_Customer customerDTOstatic = DTO_Customer.customerDTOstatic(product_DTO1.getCustomerId(), product_DTO1.getName(), dummyList1);
			dtos1.add(customerDTOstatic);
		}
		System.err.println(dtos1);
		return dtos1;
}	

}
