package com.practise.Exception_Handling;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Format_Ex {

	private String eMessage;
	private String eCode;
	private String Date;
}