package com.example.BookOneToMany.DTO;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName = "authorStaticDTO")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author_DTO {
	
	private Long id;
	private String name;
	private String country;
	
	
	private List<BookO_DTO> bookE;

}
