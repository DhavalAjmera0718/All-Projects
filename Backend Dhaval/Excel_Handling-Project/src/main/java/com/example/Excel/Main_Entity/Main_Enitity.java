package com.example.Excel.Main_Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Builder
public class Main_Enitity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;
	private String pName;
	private Long pPrice;
	

}
