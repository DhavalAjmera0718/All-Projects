package com.example.BookOneToMany.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName = "bookStaticDTO")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookO_DTO {
	private Long id;
	private String name;
	private String price;
}
