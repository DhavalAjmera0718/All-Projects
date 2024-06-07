package com.example.Student.Enitity;

import org.antlr.v4.runtime.misc.TestRig;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Password {
	@Id
	private Long id;
	private String pass;
}
