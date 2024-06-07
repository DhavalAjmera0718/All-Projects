package com.example.BookOneToMany.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "authorStaticEntity")
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude()
public class AuthorMain_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = BookO_Entity.class)
	@JoinColumn(name = "fk_Book",referencedColumnName = "id")
	private List<BookO_Entity> bookE;

/*	@OneToOne(cascade= javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "Book_ID",referencedColumnName = "id")
	private BookO_Entity bookE;
	*/
	
	
}

