package com.who.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.who.exception.AddressNotFoundException;
import com.who.exception.UserNotFoundException;

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
		throw new UserNotFoundException(1);
	}
	
	/**
	 * Second way of handling exception is "global exception handler class"
	 * 
	 * This method throws SQLException and this exception is handled by
	 * global exception handler that uses @ControllerAdvice annotation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data",method=RequestMethod.GET)
	public String data() throws Exception{
		throw new SQLException("SQLException, id="+2);
	}
	
	@RequestMapping(value="/file",method=RequestMethod.GET)
	public String file() throws Exception{
		throw new IOException("IOException, id="+3);
	}
	
	/**
	 * Third way is to configured the exception handler in xml using "SimpleMappingExceptionResolver"
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public String address(){
		System.out.println("sdfsd");
		throw new AddressNotFoundException(4);
	}
	
	
	
	
	//This is a exception handler method
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(HttpServletRequest request,Exception ex,Model model){
		
		System.out.println("Requested URL "+ request.getRequestURL());
		System.out.println("Exception Raised "+ ex);
		model.addAttribute("exception", ex);
		model.addAttribute("url", request.getRequestURL());
		return "error";
		
	}

}
