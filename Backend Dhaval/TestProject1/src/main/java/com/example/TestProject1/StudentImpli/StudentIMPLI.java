package com.example.TestProject1.StudentImpli;

import org.springframework.stereotype.Component;

@Component
public class StudentIMPLI {
	
	public int AddNumber(int a , int b) 
	{
		return a+b;
	}
/*----------------------------Multiplication-------------------------------------------*/	

	public int MultiplyNumber(int a , int b) 
	{
		return a*b;
	}
/*-----------------------------Divide----------------------------------------------------------*/

	public int DivNumber(int a , int b) 
	{
		return a/b;
	}
	
/*--------------------------------Subtrcact--------------------------------------------------------*/
	public int SubNumber(int a , int b) 
	{
		return a-b;
	}
	
/*-------------------------------------CONCAT STRING--------------------------------------------------------------------*/
	public String Concat(String a , String b)
	{
		return "Tou Enter name is >> " + a + " " + b;
		
	}
	
}
