package com.Multiple_Acc.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "childStatic_Entity")
@NoArgsConstructor
@ToString
@Table(name = "AccountDetails")
public class Account_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bid;
	
	private String bankName;
	
	private String accNumber;
	
	private Long accBalance;
	
//	@JoinColumn(name = "Bank_id", referencedColumnName = "bid")
	@ManyToOne(cascade = CascadeType.ALL)
	private User_Entity accDetails;
	
	
}
