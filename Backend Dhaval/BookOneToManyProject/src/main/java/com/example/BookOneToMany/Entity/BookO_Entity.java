package com.example.BookOneToMany.Entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "bookStaticEntity")
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookO_Entity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_name",referencedColumnName = "id")
	private AuthorMain_Entity author;
	
	
}
