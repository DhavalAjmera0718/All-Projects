package com.example.Excel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class File_DTOO {

	private Long pId;
	private String pName;
	private Long pPrice;
}
