package com.Multiple_Acc.DTOO;

import com.Multiple_Acc.Entity.Account_Entity;
import com.Multiple_Acc.Entity.User_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor(staticName = "childStatic_DTO")
@NoArgsConstructor
@ToString
public class Account_DTO {
	
	private Long bid;
	
	private String bankName;
	
	private String accNumber;
	
	private Long accBalance;
}
