package com.example.TestProject1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestProject1.StudentImpli.StudentIMPLI;

@RestController
public class TestController2 {

	@Autowired
	private StudentIMPLI st;
	@GetMapping("/Add/{x}/{y}")
	public int Addnumber(@PathVariable("x") int m ,@PathVariable("y") int n) 
	{
		return st.AddNumber(m, n);
	}
/*--------------------------------------With Using New KEy Word [ MULTIPLICATION ]----------------------------------------------------------------------------------*/	
	
	@GetMapping("/Multi/{q}/{w}")
	public int Mul(@PathVariable("q") int x ,@PathVariable("w") int y) 
	{
		StudentIMPLI st1 = new StudentIMPLI();
		int mul = st.MultiplyNumber(x, y);
		return mul;
	}
/*------------------------------------Divide Number-------------------------------------------------------------------------------------------------*/	

	@GetMapping("/div/{x}/{y}")
	public int Div(@PathVariable("x") int a ,@PathVariable("y") int b) 
	{
		return st.DivNumber(a, b);
	}



/*------------------------------------Subtract Number-------------------------------------------------------------------------------------------------*/	
	
	@GetMapping("/sub/{x}/{y}")
	public int sub(@PathVariable("x") int a ,@PathVariable("y") int b) 
	{
		return st.SubNumber(a, b);
	}
/*------------------------------------Concat String-------------------------------------------------------------------------------------------------*/	

	@GetMapping("/concat/{x}/{y}")
	public String Con(@PathVariable("x") String a ,@PathVariable("y") String b) 
	{
		return st.Concat(a, b);
	}
	
	
	
}
	