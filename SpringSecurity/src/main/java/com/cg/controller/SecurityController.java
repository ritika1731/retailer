package com.cg.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/unsecured")
	public ExampleClass Unsecured(String field1,String field2)
	{
		return new ExampleClass("hello","hi");
		
	}
	@GetMapping("/secured")
	public ExampleClass Secured(String field1,String field2)
	{
		return new ExampleClass("asda","xcz");
		
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ExampleClass getAdminRes() {
		return new ExampleClass("ADMIN", "YYYY");
		
	}
	
	
	
}

 class ExampleClass{

	String feild2;
	String fiels1;
	/**
	 * @return the feild2
	 */
	public String getFeild2() {
		return feild2;
	}
	/**
	 * @param feild2 the feild2 to set
	 */
	public void setFeild2(String feild2) {
		this.feild2 = feild2;
	}
	/**
	 * @return the fiels1
	 */
	public String getFiels1() {
		return fiels1;
	}
	/**
	 * @param fiels1 the fiels1 to set
	 */
	public void setFiels1(String fiels1) {
		this.fiels1 = fiels1;
	}
	/**
	 * @param feild2
	 * @param fiels1
	 */
	public ExampleClass(String feild2, String fiels1) {
		this.feild2 = feild2;
		this.fiels1 = fiels1;
	}
	
	
	
}