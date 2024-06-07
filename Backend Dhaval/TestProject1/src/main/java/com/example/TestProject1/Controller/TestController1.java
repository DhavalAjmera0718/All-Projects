package com.example.TestProject1.Controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController1 {

	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	@ResponseBody
	public String getInformation() {
		return "Hello";
	}
/*------------------------------------------------------------------------------------------------------*/
	
	@RequestMapping(value = "/getname1/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String getInfo2(@PathVariable String name) 
	{
		return "You Entered name IS >> " + name;
	}
/*--------------------------------------------------------------------------------------------------------*/	
	@RequestMapping(value = "/getname1/{fname}/{lname}", method = RequestMethod.GET)
	@ResponseBody
	public String getInfo2(@PathVariable String fname, @PathVariable String lname) 
	{
		return "You Entered name IS >> " + fname + lname;
	}
/*--------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/getname2", method = RequestMethod.GET)
	@ResponseBody
	public String getInfo3(@RequestParam String name) 
	{
		return "You Entered name IS >> " + name;
	}
/*--------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "/getname3", method = RequestMethod.GET)
	@ResponseBody
	public String getInfo4(@RequestParam String fname , @RequestParam String lname) 
	{
		return "You Entered name IS >> " + fname + lname;
	}
	/*--------------------------------------------------------------------------------------------*/
	
	@RequestMapping(value = "/getFullName/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String getOneParam(@PathVariable String name) {
 
		return "<html><body><h2 style='color:red'>"+"Hello- "+name+"</h2></body></html>";
	}
/*---------------------------------------------FACTORIYAl------------------------------------------------------------------------------*/
	
	@RequestMapping(value = "/getFact/{number}" , method = RequestMethod.GET)
	@ResponseBody
	public int fact(@PathVariable int number) 
	{
			int n = 1;
			for(int i=1; i<=number;i++) 
			{
				n=n*i;
			}
			return n;
	}
/*--------------------------------PRIME-----------------------------------------------------------------*/
	@RequestMapping(value = "/getprime/{number}",method = RequestMethod.GET)
	@ResponseBody
	public String prime(@PathVariable int number) 
	{
		
		  int i ,count=0;
		  
		  for(i=2;i<number;i++){ 
			  if(number%i==0) 
			  {
				  count++; 
			  }
			  } 
		  if(count>0)
		  {
			  return "Not Prime number";
		  } else
		  {
			  return "Prime number";
		  }	 		
	}
/*-------------------------------------------------FIBONACI--------------------------------------------------------------*/	
@RequestMapping(value = "/getfibo/{number}",method = RequestMethod.GET)
@ResponseBody
	public int Fibo(@PathVariable int number) 
	{
		int k=1 , i=0 , t;
				
		for(int j =1;j<=number;j++) 
		{
			System.out.println(i);
			t=i;
			i=k;
			k=t+i;
		}
		return k;
		
	}

}
