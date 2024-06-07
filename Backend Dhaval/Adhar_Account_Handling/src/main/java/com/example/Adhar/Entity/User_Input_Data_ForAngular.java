package com.example.Adhar.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class User_Input_Data_ForAngular {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLong;
	
	private String userName;
	
	private String city;
	
	//@Lob
//	@Column(length = 1000000)
//	private byte[] displayPicture;
	private String displayPicture;
	
	
}
