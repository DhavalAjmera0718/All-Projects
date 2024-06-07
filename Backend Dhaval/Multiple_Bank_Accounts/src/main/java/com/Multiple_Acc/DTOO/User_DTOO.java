package com.Multiple_Acc.DTOO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor(staticName = "perentStatic_Dto")
@NoArgsConstructor
@Getter
@Setter
public class User_DTOO {

	private Long userId;
	
	private String username;
	
	private List<Account_DTO> accDetails;
}
