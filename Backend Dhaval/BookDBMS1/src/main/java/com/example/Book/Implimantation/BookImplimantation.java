	package com.example.Book.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.Book.Entity.BookEntity;
import com.example.Book.Repository.BookRepo;
import com.example.Book.Service.BookServices;
import com.example.Book.dto.Book_DTO;
import com.github.javafaker.Faker;

@Component
public class BookImplimantation implements BookServices {

	@Autowired
	// Create Repository OBJ
	private BookRepo repo;
	
	@Autowired
	Faker faker;

	//@Override
	//public List<Book_DTO> GetAllBook() {

//		List<BookEntity> allData = (List<BookEntity>) repo.findAll();
//		System.out.println("ALL DATA >>>>>>>>>>>>>>>> " + allData);
//		
//		List<Book_DTO> dtos = new ArrayList<>();
//		
//		for (BookEntity student : allData) {
//			Book_DTO bookdto = new Book_DTO();
//			System.out.println(student);
//			bookdto.setSid(student.getSid());
//			bookdto.setName(student.getName());
//			bookdto.setType(student.getType());
//			
//			dtos.add(bookdto);
//			System.out.println("List dtos  in Get All ........." + dtos);
//		}
		
		//System.out.println("List Book DTO in Get All ........." + bookdto);
		//System.out.println("List dtos  in Get All ........." + dtos);

//		return dtos;
//		
//
//	}
/*****************************************************SAVE DATA****************************************************************************************/
	
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	@Override
	public boolean SaveData(int count) {
		for(int i=0;i<=count;i++) {
			
			BookEntity bentity  = new BookEntity();
			
			bentity.setTitle(faker.book().title());
			bentity.setGenre(faker.book().genre());
			repo.save(bentity);
			//throw new RuntimeException("somthing Went Wrong");
			
		}
		
		return true;
	}

/***************************************************** DeleteBy id****************************************************************************************/

	public String DeleteByid(int Bid) {
		repo.deleteById(Bid);
		return "Book Data Deleted";
	}


	/***************************************************** Find By id****************************************************************************************/

	public String FingByid(int Bid) {
		return "Data Founded >> " + repo.findById(Bid);

	}

/***************************************************** UPDATE BY ID****************************************************************************************/

//public String UpdateById(int Bid, Book_DTO books) {
		/* Optional <BookEntity> UpdateByID =  repo.findById(Bid);

		 BookEntity book1 = UpdateByID.stream().filter(a -> a.getSid() ==Bid).findAny().orElse(null);

		
		 System.out.println(" BOOK 1 DATA >>>>>" + book1);
		 System.out.println(" ENITY  VARIABLE BOOKs DATA >> " + books);
		 System.out.println(" LOCAL VARIABLE UpDATEBYID DATA >> " + UpdateByID);
		 book1.setName(books.getName()); 
		 book1.setType(books.getType());
		// repo.save(book1); 
		 return "Data Updated.............";
		 */
/******************************************************UPDATE BY ID***************************************************************************************/	
//		Optional<BookEntity> bookEntity = repo.findById(Bid);
//		System.out.println("Status-" + bookEntity);
//		
//	//	Book_DTO bookdto = new Book_DTO();
//		
//		//List<Book_DTO> dtos = new ArrayList<>();
//		
//		if (bookEntity.isPresent()) {
//			BookEntity up = bookEntity.get();
//			if(books.getName()!=null) 
//			{
//				up.setName(books.getName());
//
//			}
//			if(books.getType()!=null) 
//			{
//				up.setType(books.getType());
//			}
//			repo.save(up);
//			System.out.println(up);
//			return "Data Updated.............";
//		}
//		else 
//		{
//			return "You Entered Wrong ID";
//		}
//
//	}
/******************************************************DELETE ALL****************************************************************************************/
public String DeleAll() 
{
	repo.deleteAll();
	return "All Data Deleted";
}

@Override
public List<Book_DTO> GetAllBook() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String UpdateById(int Bid, Book_DTO books) {
	// TODO Auto-generated method stub
	return null;
}

}
