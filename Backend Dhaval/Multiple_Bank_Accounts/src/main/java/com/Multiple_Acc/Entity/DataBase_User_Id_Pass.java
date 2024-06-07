package com.Multiple_Acc.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBase_User_Id_Pass {

	@Id
	private String us;
	private String pass;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
   
	
	 
}
