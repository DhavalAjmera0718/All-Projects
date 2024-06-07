package com.example.Excel.GlobalException_Handler;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Format_Exception {

	private String exceptioMessage;
	private String exceptionCode;
}
