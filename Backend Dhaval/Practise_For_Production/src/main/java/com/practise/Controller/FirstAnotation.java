package com.practise.Controller;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface FirstAnotation {
	
	String name() default "Dhaval";
	
	int myValue() default 50;
		
	String city() default "Ahmedabad";

}
