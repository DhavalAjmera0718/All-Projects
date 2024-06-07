package com.example.Student.Enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_DETAILS")
public class Users_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user1;
	private String Pass2;

}
