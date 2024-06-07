package com.example.Book.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	//@NotBlank(message = "Name is Mandatory")
	private String title;
	private String genre;
		

}
