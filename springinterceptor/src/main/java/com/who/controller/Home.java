package com.who.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	/**
	 * First way of handling exception-"Exception handler method".
	 * 
	 * This method throws UserNotFoundException and will be handled by Exception Handler method in 
	 * this same controller class
	 */
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String user(){
		return "sdf";
	}
	


}
